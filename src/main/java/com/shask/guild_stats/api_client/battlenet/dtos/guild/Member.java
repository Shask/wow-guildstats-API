package com.shask.guild_stats.api_client.battlenet.dtos.guild;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shask.guild_stats.api_client.battlenet.dtos.character.CharacterDTO;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    public CharacterDTO character;
    public int rank;
}