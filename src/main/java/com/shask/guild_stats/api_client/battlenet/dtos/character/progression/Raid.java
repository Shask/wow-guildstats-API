package com.shask.guild_stats.api_client.battlenet.dtos.character.progression;

import java.util.List;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
public class Raid {
    public String name;
    public int lfr;
    public int heroic;
    public int normal;
    public int mythic;
    public int id;
    public List<Boss> bosses;
}
