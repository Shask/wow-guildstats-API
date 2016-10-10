package com.shask.guild_stats.api_client.battlenet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shask.guild_stats.api_client.GenericClient;
import com.shask.guild_stats.api_client.battlenet.dtos.character.CharacterDTO;
import com.shask.guild_stats.api_client.battlenet.dtos.guild.GuildDTO;
import com.shask.guild_stats.api_client.battlenet.params.BattleNetParams;
import com.shask.guild_stats.api_client.battlenet.params.GuildParams;
import com.shask.guild_stats.api_client.exception.ApiCallEnum;
import com.shask.guild_stats.api_client.exception.ApiCallException;
import com.shask.guild_stats.utils.UriEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


/**
 * Created by Steven Fougeron on 27/05/16.
 */
@Service
public class BattleNetClient extends GenericClient{

    private static final Logger LOGGER = LoggerFactory.getLogger(BattleNetClient.class);

    private static final String REST_URL_CHARACTER = "https://eu.api.battle.net/wow/character/";
    private static final String REST_URL_GUILD = "https://eu.api.battle.net/wow/guild/";
    private static final String FIELD_PARAM = "?fields=";
    private static final String LOCAL_PARAM = "locale=";
    private static final String API_KEY_PARAM = "apikey=";

    @Value("${battlenet.api_key}")
    private String api_key;
    @Value("${wow.guilde_name}")
    private String guild;
    @Value("${wow.realm}")
    private String defaultRealm;
    @Value("${wow.local}")
    private String local;

    @Autowired
    ObjectMapper mapper;

    /**
     * Call battleNet API to get a Character stats
     *
     * @param realmName     name of the realm the character is in (null if you want the default one defined in application.properties)
     * @param characterName Name of the character you want to get
     * @param Params        Possible handled params are : pvp, progression
     * @return CharacterDTO (same format as the json received)
     */
    public CharacterDTO getCharacter(String characterName, String realmName, BattleNetParams... Params) {

        String realmUri = UriEncoder.encodeURI(realmName, UriEncoder.Format.BATTLE_NET, UriEncoder.Field.REALM);

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder = urlBuilder.append(REST_URL_CHARACTER)
                .append(realmUri)
                .append('/')
                .append(characterName)
                .append(FIELD_PARAM)
                .append(paramsFormatter(Params))
                .append('&')
                .append(LOCAL_PARAM)
                .append(local)
                .append('&')
                .append(API_KEY_PARAM)
                .append(api_key);

        String response = apiGetRequest(urlBuilder.toString(),ApiCallEnum.BATTLE_NET_ERROR);

        try {
            return mapper.readValue(response, CharacterDTO.class);
        } catch (IOException e) {
            String errMsg = "Error reading json from BNet for Characters";
            LOGGER.error(errMsg);
            throw new ApiCallException(errMsg, ApiCallEnum.BATTLE_NET_ERROR);
        }
    }

    /**
     * Call battleNet API to get the guild informations
     *
     * @param Params possible handled params are : membres
     * @return GuildDTO (Formatted as the JSON received form BNet)
     */
    public GuildDTO getGuild(GuildParams... Params) {
        String guildUri = UriEncoder.encodeURI(guild, UriEncoder.Format.BATTLE_NET, UriEncoder.Field.GUILD_NAME);
        String defaultRealmUri = UriEncoder.encodeURI(defaultRealm, UriEncoder.Format.BATTLE_NET, UriEncoder.Field.REALM);

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder = urlBuilder.append(REST_URL_GUILD)
                .append(defaultRealmUri)
                .append('/')
                .append(guildUri)
                .append(FIELD_PARAM)
                .append(paramsFormatter(Params))
                .append('&')
                .append(LOCAL_PARAM)
                .append(local)
                .append('&')
                .append(API_KEY_PARAM)
                .append(api_key);

        String response = apiGetRequest(urlBuilder.toString(),ApiCallEnum.BATTLE_NET_ERROR);
        try {
            return mapper.readValue(response, GuildDTO.class);
        } catch (IOException e) {
            String errMsg = "Error reading json from BNet for Guilds";
            LOGGER.error(errMsg);
            throw new ApiCallException(errMsg, ApiCallEnum.BATTLE_NET_ERROR);
        }
    }


    /**
     * Take a BattlenetParams in parameter and parse it to a String ready to use in URL
     * (All enum separated by %2C)
     *
     * @param Params BattleNetParams
     * @return string for URL
     */
    private String paramsFormatter(BattleNetParams... Params) {
        final StringBuilder Param;
        if (Params.length <= 0) {
            return "+"; //return + so that the URL is still correct
        } else {
            Param = new StringBuilder();
            Arrays.stream(Params).forEach(p -> {
                Param.append(p.toString());
                Param.append("%2C");
            });
        }
        return Param.toString();
    }
}