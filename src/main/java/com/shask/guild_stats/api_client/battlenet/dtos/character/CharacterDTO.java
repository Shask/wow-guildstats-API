package com.shask.guild_stats.api_client.battlenet.dtos.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shask.guild_stats.api_client.battlenet.dtos.character.item.Items;
import com.shask.guild_stats.api_client.battlenet.dtos.character.progression.Progression;
import com.shask.guild_stats.api_client.battlenet.dtos.character.pvp.Pvp;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDTO {
    public long lastModified;
    public String name;
    public String realm;
    public String guildRealm;
    public String guild;
    public String battlegroup;
    @JsonProperty("class")
    public byte classe;
    public byte race;
    public byte gender;
    public short level;
    public long achievementPoints;
    public String thumbnail;
    @JsonProperty()
    public char calcClass;
    public SpecDTO spec;
    public byte faction;
    public long totalHonorableKills;

    public Items items;

    public Pvp pvp;
    public Progression progression;

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "lastModified=" + lastModified +
                ", name='" + name + '\'' +
                ", realm='" + realm + '\'' +
                ", guildRealm='" + guildRealm + '\'' +
                ", guild='" + guild + '\'' +
                ", battlegroup='" + battlegroup + '\'' +
                ", classe=" + classe +
                ", race=" + race +
                ", gender=" + gender +
                ", level=" + level +
                ", achievementPoints=" + achievementPoints +
                ", thumbnail='" + thumbnail + '\'' +
                ", calcClass=" + calcClass +
                ", spec=" + spec +
                ", faction=" + faction +
                ", totalHonorableKills=" + totalHonorableKills +
                ", pvp=" + pvp +
                ", progression=" + progression +
                '}';
    }
}
