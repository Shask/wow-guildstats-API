package com.shask.guild_stats.api_client;

import com.shask.guild_stats.api_client.exception.ApiCallEnum;
import com.shask.guild_stats.api_client.exception.ApiCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Steven Fougeron on 10/10/16.
 */
public class GenericClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericClient.class);


    protected String apiGetRequest(String urlString, ApiCallEnum apiName) {

        LOGGER.info("Requesting url : " + urlString);
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String finalOutput = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                finalOutput += output;
            }
            conn.disconnect();
            return finalOutput;

        } catch (MalformedURLException e) {
            LOGGER.error(e.toString());
            throw new ApiCallException("Malformed URL", apiName);

        } catch (IOException e) {
            LOGGER.error(e.toString());
            throw new ApiCallException("IO Error on call", apiName);
        }
    }
}
