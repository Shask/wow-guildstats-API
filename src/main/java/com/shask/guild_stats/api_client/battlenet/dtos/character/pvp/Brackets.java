package com.shask.guild_stats.api_client.battlenet.dtos.character.pvp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Brackets {
    @JsonProperty("ARENA_BRACKET_2v2")
    public Arena arena2v2;
    @JsonProperty("ARENA_BRACKET_3v3")
    public Arena arena3v3;

    @JsonProperty("ARENA_BRACKET_5v5")
    public Arena arena5v5;
    @JsonProperty("ARENA_BRACKET_2v2_SKIRMISH")
    public Arena arena2v2skir;
    @JsonProperty("ARENA_BRACKET_5v5_SKIRMISH")
    public Arena arena5v5skir;

    @JsonProperty("ARENA_BRACKET_RBG")
    public Arena arenaRBG;

    @Override
    public String toString() {
        return "Brackets{" +
                "arena2v2=" + arena2v2 +
                ", arena3v3=" + arena3v3 +
                ", arena5v5=" + arena5v5 +
                ", arena2v2skir=" + arena2v2skir +
                ", arena5v5skir=" + arena5v5skir +
                ", arenaRBG=" + arenaRBG +
                '}';
    }
}
