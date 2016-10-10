package com.shask.guild_stats.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Steven Fougeron on 02/06/16.
 */

@Entity(name = "WOW_CHARACTER")
public class Character implements Serializable {


    @Column(name = "last_modified")
    private LocalDateTime lastModified;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String realm;
    private byte classe;
    private byte race;
    private byte gender;
    private short level;

    private int ilvl;
    @Column(name = "ilvl_equiped")
    private int ilvlEquiped;


    private long achievement;
    private String thumbnail;
    @Column(name = "honorable_kill")
    private long honorableKill;

    @Column(name = "rating_2v2")
    private int rating2v2;
    @Column(name = "rating_3v3")
    private int rating3v3;
    @Column(name = "rating_5v5")
    private int rating5v5;
    @Column(name = "rating_RBG")
    private int ratingRBG;

    public Character() {
    }

    public Character(Builder builder) {
        lastModified = builder.lastModified;
        id = builder.id;
        name = builder.name;
        classe = builder.classe;
        race = builder.race;
        gender = builder.gender;
        level = builder.level;
        achievement = builder.achievement;
        thumbnail = builder.thumbnail;
        honorableKill = builder.honorableKill;
        rating2v2 = builder.rating2v2;
        rating3v3 = builder.rating3v3;
        rating5v5 = builder.rating5v5;
        ratingRBG = builder.ratingRBG;
        realm = builder.realm;
        ilvl = builder.ilvl;
        ilvlEquiped = builder.ilvlEquiped;

    }

    public static class Builder {

        private LocalDateTime lastModified;
        private long id;
        private String name;
        private byte classe;
        private byte race;
        private byte gender;
        private short level;
        private long achievement;
        private String thumbnail;
        private long honorableKill;
        private int rating2v2;
        private int rating3v3;
        private int rating5v5;
        private int ratingRBG;
        private String realm;

        private int ilvl;
        private int ilvlEquiped;

        public Builder setIlvl(int ilvl) {
            this.ilvl = ilvl;
            return this;
        }

        public Builder setIlvlEquiped(int ilvlEquiped) {
            this.ilvlEquiped = ilvlEquiped;
            return this;
        }

        public Builder setRealm(String realm) {
            this.realm = realm;
            return this;
        }

        public Builder(String name) {
            this.name = name;
        }

        public Builder setLastModified(LocalDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setClasse(byte classe) {
            this.classe = classe;
            return this;
        }

        public Builder setRace(byte race) {
            this.race = race;
            return this;
        }

        public Builder setGender(byte gender) {
            this.gender = gender;
            return this;
        }

        public Builder setLevel(short level) {
            this.level = level;
            return this;
        }

        public Builder setAchievement(long achievement) {
            this.achievement = achievement;
            return this;
        }

        public Builder setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder setHonorableKill(long honorableKill) {
            this.honorableKill = honorableKill;
            return this;
        }

        public Builder setRating2v2(int rating2v2) {
            this.rating2v2 = rating2v2;
            return this;
        }

        public Builder setRating3v3(int rating3v3) {
            this.rating3v3 = rating3v3;
            return this;
        }

        public Builder setRating5v5(int rating5v5) {
            this.rating5v5 = rating5v5;
            return this;
        }

        public Builder setRatingRBG(int ratingRBG) {
            this.ratingRBG = ratingRBG;
            return this;
        }
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
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

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getHonorableKill() {
        return honorableKill;
    }

    public void setHonorableKill(long honorableKill) {
        this.honorableKill = honorableKill;
    }

    public int getRating2v2() {
        return rating2v2;
    }

    public void setRating2v2(int rating2v2) {
        this.rating2v2 = rating2v2;
    }

    public int getRating3v3() {
        return rating3v3;
    }

    public void setRating3v3(int rating3v3) {
        this.rating3v3 = rating3v3;
    }

    public int getRating5v5() {
        return rating5v5;
    }

    public void setRating5v5(int rating5v5) {
        this.rating5v5 = rating5v5;
    }

    public int getRatingRBG() {
        return ratingRBG;
    }

    public void setRatingRBG(int ratingRBG) {
        this.ratingRBG = ratingRBG;
    }

    @Override
    public String toString() {
        return "Character{" +
                "realm='" + realm + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", achievement=" + achievement +
                ", honorableKill=" + honorableKill +
                '}';
    }
}
