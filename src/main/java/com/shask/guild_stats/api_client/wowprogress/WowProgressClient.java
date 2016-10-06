package com.shask.guild_stats.api_client.wowprogress;


import com.shask.guild_stats.api_client.wowprogress.dtos.GuildRankDTO;
import com.shask.guild_stats.utils.UriEncoder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
@Service
public class WowProgressClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(WowProgressClient.class);
    private static final String WOW_PROGRESS_URL = "http://www.wowprogress.com/guild/";
    @Value("${wow.guilde_name}")
    private String guild;
    @Value("${wow.realm}")
    private String realm;
    @Value("${wow.server}")
    private String serverLocation;

    public GuildRankDTO getGuildRank() {
        StringBuilder urlBuilder = new StringBuilder();
        String guildUrlFormat = UriEncoder.encodeURI(guild,UriEncoder.Format.WOW_PROGRESS,UriEncoder.Field.GUILD_NAME);
        String realmUrlFormat = UriEncoder.encodeURI(realm,UriEncoder.Format.WOW_PROGRESS,UriEncoder.Field.REALM);

        urlBuilder = urlBuilder.append(WOW_PROGRESS_URL)
                .append(serverLocation)
                .append('/')
                .append(realmUrlFormat)
                .append('/')
                .append(guildUrlFormat)
                .append("/json_rank");
        LOGGER.info("Requesting url : " + urlBuilder.toString());

        //Configure Call to wowProgress API
        ClientConfig cfg = new DefaultClientConfig();
        ClientResponse response = Client.create(cfg)
                .resource(urlBuilder.toString())
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            LOGGER.error("Failed HTTP request : error code = " + response.getStatus());
            //TODO Error Handling ? Custom Exception ?
        }

        //Parse manually string from wowProgress because there are sending string formatted as json
        String unformattedJSONRank = response.getEntity(new GenericType<String>() {});
        GuildRankDTO guildRankDTO= null;
        try{
            guildRankDTO =  new ObjectMapper().readValue(unformattedJSONRank, GuildRankDTO.class);
        }
        catch (IOException io)
        {
            LOGGER.error("Failed to map string from wow progress to proper GuildRank Object ");
            LOGGER.error(io.getMessage());
        }
       return guildRankDTO;
    }
}
