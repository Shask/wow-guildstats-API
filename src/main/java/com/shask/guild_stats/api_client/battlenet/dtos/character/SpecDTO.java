package com.shask.guild_stats.api_client.battlenet.dtos.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecDTO {
    public String name;
    public String role;
    public String backgroundImage;
    public String icon;
    public String description;
    public byte order;
}
