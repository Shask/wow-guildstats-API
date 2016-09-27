package com.shask.guild_stats.mapper.battlenet;

import com.shask.guild_stats.dto.battlenet.character.CharacterDTO;
import com.shask.guild_stats.model.Character;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Steven Fougeron on 17/06/16.
 */
public interface CharacterDTOMapper {
    static Character toCharacter(CharacterDTO dto)
    {
        Character characterModel = new Character(
                new Character.Builder(dto.name)
                .setAchievement(dto.achievementPoints)
                .setClasse(dto.classe)
                .setGender(dto.gender)
                .setHonorableKill(dto.totalHonorableKills)
                .setLastModified(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.lastModified), ZoneId.systemDefault()))
                .setRace(dto.race)
                .setLevel(dto.level)
                .setRating2v2(dto.pvp.brackets.arena2v2.rating)
                .setRating3v3(dto.pvp.brackets.arena3v3.rating)
                .setRatingRBG(dto.pvp.brackets.arenaRBG.rating)
                .setThumbnail(dto.thumbnail)
                .setRealm(dto.realm)
        );
        return characterModel;
    }
}
