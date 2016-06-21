package com.shask.guild_stats.dto.battlenet.character.pvp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
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
}
