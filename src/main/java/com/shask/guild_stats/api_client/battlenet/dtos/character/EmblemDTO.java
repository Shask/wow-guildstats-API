package com.shask.guild_stats.api_client.battlenet.dtos.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmblemDTO {
    public int icon;
    public String iconColor;
    public byte iconColorId;
    public byte border;
    public String borderColor;
    public byte borderColorId;
    public String backgroundColor;
    public byte backgroundColorId;
}
