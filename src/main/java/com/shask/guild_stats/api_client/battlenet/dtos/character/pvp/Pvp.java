package com.shask.guild_stats.api_client.battlenet.dtos.character.pvp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pvp {
    public Brackets brackets;

    @Override
    public String toString() {
        return "Pvp{" +
                "brackets=" + brackets +
                '}';
    }
}
