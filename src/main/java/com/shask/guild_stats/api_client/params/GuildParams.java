package com.shask.guild_stats.api_client.params;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
public enum GuildParams implements BattleNetParams{
    MEMBERS, ACHIEVEMENTS, NEWS, CHALLENGE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
