package com.shask.guild_stats.api_client.battlenet.dtos.character.pvp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Arena {
    public String slug;
    public int rating;
    public int weeklyPlayed;
    public int weeklyWon;
    public int weeklyLost;
    public int seasonPlayed;
    public int seasonWon;
    public int seasonLost;

    @Override
    public String toString() {
        return "Arena{" +
                "slug='" + slug + '\'' +
                ", rating=" + rating +
                ", weeklyPlayed=" + weeklyPlayed +
                ", weeklyWon=" + weeklyWon +
                ", weeklyLost=" + weeklyLost +
                ", seasonPlayed=" + seasonPlayed +
                ", seasonWon=" + seasonWon +
                ", seasonLost=" + seasonLost +
                '}';
    }
}
