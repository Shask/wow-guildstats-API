package com.shask.guild_stats.api_client.battlenet.dtos.character.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Steven Fougeron on 06/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items
{
    public int averageItemLevel;
    public int averageItemLevelEquipped;
    public Object head;
    public Object neck;
    public Object shoulder;
    public Object back;
    public Object chest;
    public Object wrist;
    public Object hands;
    public Object waist;
    public Object legs;
    public Object feet;
    public Object finger1;
    public Object finger2;
    public Object trinket1;
    public Object trinket2;
    public Object mainHand;
    public Object offHand;
    public Object tabard;
    public Object shirt;
}
