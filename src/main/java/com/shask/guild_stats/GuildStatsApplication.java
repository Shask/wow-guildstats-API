package com.shask.guild_stats;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class GuildStatsApplication {


    public static void main(String args[]) {
        SpringApplication.run(GuildStatsApplication.class);
    }

    @Bean
    public ObjectMapper jacksonMapper() {
        return new ObjectMapper();
    }
}
