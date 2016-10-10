package com.shask.guild_stats.api_client.battlenet.dtos.character.progression;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Boss {
    public long id;
    public String name;
    public int lfrKills;
    public long lfrTimestamp;
    public int normalKills;
    public long normalTimestamp;
    public int heroicKills;
    public long heroicTimestamp;
    public int mythicKills;
    public long mythicTimestamp;
}
