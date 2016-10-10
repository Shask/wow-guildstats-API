package com.shask.guild_stats.api_client.battlenet.mapper;

import com.shask.guild_stats.api_client.battlenet.dtos.character.CharacterDTO;
import com.shask.guild_stats.api_client.exception.ApiCallEnum;
import com.shask.guild_stats.api_client.exception.ApiCallException;
import com.shask.guild_stats.model.Character;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Steven Fougeron on 17/06/16.
 */
public interface CharacterDTOMapper {
    static Character toCharacter(CharacterDTO dto) {
        Character characterModel;
        try {
            characterModel = new Character(
                    new Character.Builder(dto.name)
                            .setAchievement(dto.achievementPoints)
                            .setClasse(dto.classe)
                            .setGender(dto.gender)
                            .setIlvl(dto.items.averageItemLevel)
                            .setIlvlEquiped(dto.items.averageItemLevelEquipped)
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
        } catch (Exception e) {
            throw new ApiCallException("Error during mapping", e, ApiCallEnum.BATTLE_NET_DTO_MAPPER);
        }

        return characterModel;
    }
}
