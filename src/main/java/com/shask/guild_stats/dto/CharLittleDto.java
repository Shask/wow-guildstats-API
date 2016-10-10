package com.shask.guild_stats.dto;

import java.io.Serializable;

/**
 * Created by Steven Fougeron on 07/10/16.
 */
public class CharLittleDto implements Serializable {

    private long id;
    private String name;
    private String realm;
    private byte classe;
    private byte race;
    private short level;
    private int ilvl;
    private int ilvlEquiped;
    private long achievement;
    private long honorableKill;

    @Override
    public String toString() {
        return "CharLittleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realm='" + realm + '\'' +
                ", classe=" + classe +
                ", race=" + race +
                ", level=" + level +
                ", ilvl=" + ilvl +
                ", ilvlEquiped=" + ilvlEquiped +
                ", achievement=" + achievement +
                ", honorableKill=" + honorableKill +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public byte getClasse() {
        return classe;
    }

    public void setClasse(byte classe) {
        this.classe = classe;
    }

    public byte getRace() {
        return race;
    }

    public void setRace(byte race) {
        this.race = race;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public int getIlvl() {
        return ilvl;
    }

    public void setIlvl(int ilvl) {
        this.ilvl = ilvl;
    }

    public int getIlvlEquiped() {
        return ilvlEquiped;
    }

    public void setIlvlEquiped(int ilvlEquiped) {
        this.ilvlEquiped = ilvlEquiped;
    }

    public long getAchievement() {
        return achievement;
    }

    public void setAchievement(long achievement) {
        this.achievement = achievement;
    }

    public long getHonorableKill() {
        return honorableKill;
    }

    public void setHonorableKill(long honorableKill) {
        this.honorableKill = honorableKill;
    }
}
