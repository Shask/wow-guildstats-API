package com.shask.guild_stats.dto.battlenet.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shask.guild_stats.dto.battlenet.character.progression.Progression;
import com.shask.guild_stats.dto.battlenet.character.pvp.Pvp;

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
