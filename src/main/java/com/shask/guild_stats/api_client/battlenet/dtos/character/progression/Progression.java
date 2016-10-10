package com.shask.guild_stats.api_client.battlenet.dtos.character.progression;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Progression {
    public List<Raid> raids;
}
