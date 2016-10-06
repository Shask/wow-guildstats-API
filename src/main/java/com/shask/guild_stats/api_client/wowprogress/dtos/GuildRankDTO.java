package com.shask.guild_stats.api_client.wowprogress.dtos;

/**
 * Created by Steven Fougeron on 02/06/16.
 */
public class GuildRankDTO {
    public int score;
    public int world_rank;
    public int area_rank;
    public int realm_rank;

    @Override
    public String toString() {
        return "GuildRankDTO{" +
                "score=" + score +
                ", world_rank=" + world_rank +
                ", area_rank=" + area_rank +
                ", realm_rank=" + realm_rank +
                '}';
    }
}
