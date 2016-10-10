package com.shask.guild_stats.api_client.wowprogress;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.shask.guild_stats.api_client.GenericClient;
import com.shask.guild_stats.api_client.exception.ApiCallEnum;
import com.shask.guild_stats.api_client.exception.ApiCallException;
import com.shask.guild_stats.api_client.wowprogress.dtos.GuildRankDTO;
import com.shask.guild_stats.utils.UriEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
@Service
public class WowProgressClient extends GenericClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(WowProgressClient.class);
    private static final String WOW_PROGRESS_URL = "http://www.wowprogress.com/guild/";
    @Value("${wow.guilde_name}")
    private String guild;
    @Value("${wow.realm}")
    private String realm;
    @Value("${wow.server}")
    private String serverLocation;

    @Autowired
    ObjectMapper mapper;


    public GuildRankDTO getGuildRank() {
        StringBuilder urlBuilder = new StringBuilder();
        String guildUrlFormat = UriEncoder.encodeURI(guild, UriEncoder.Format.WOW_PROGRESS, UriEncoder.Field.GUILD_NAME);
        String realmUrlFormat = UriEncoder.encodeURI(realm, UriEncoder.Format.WOW_PROGRESS, UriEncoder.Field.REALM);

        urlBuilder = urlBuilder.append(WOW_PROGRESS_URL)
                .append(serverLocation)
                .append('/')
                .append(realmUrlFormat)
                .append('/')
                .append(guildUrlFormat)
                .append("/json_rank");
        LOGGER.info("Requesting url : " + urlBuilder.toString());

        String response = apiGetRequest(urlBuilder.toString(), ApiCallEnum.WOW_PROGRESS_ERROR);
        try {
            return mapper.readValue(response, GuildRankDTO.class);
        } catch (IOException e) {
            String errMsg = "Error reading json from BNet for Guilds";
            LOGGER.error(errMsg);
            throw new ApiCallException(errMsg, ApiCallEnum.WOW_PROGRESS_ERROR);
        }

    }
}
