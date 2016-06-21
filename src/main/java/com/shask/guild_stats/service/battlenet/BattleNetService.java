package com.shask.guild_stats.service.battlenet;

import com.shask.guild_stats.api_client.BattleNetClient;
import com.shask.guild_stats.api_client.params.CharacterParams;
import com.shask.guild_stats.api_client.params.GuildParams;
import com.shask.guild_stats.dao.CharacterDAO;
import com.shask.guild_stats.dto.battlenet.character.CharacterDTO;
import com.shask.guild_stats.dto.battlenet.guild.GuildDTO;
import com.shask.guild_stats.mapper.battlenet.CharacterDTOMapper;
import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.utils.AchievementSorter;
import jersey.repackaged.com.google.common.collect.Lists;
import org.hibernate.dialect.identity.Chache71IdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Fougeron on 15/06/16.
 */
@Service
public class BattleNetService {

    @Autowired
    BattleNetClient battleNetClient;

    @Autowired
    CharacterDAO characterDAO;


    public void refreshAll() {
        GuildDTO gDto = battleNetClient.getGuild(GuildParams.MEMBERS);
        //refresh DB from BattleNet foreach character that has at least lvl 100
        gDto.members.stream().filter(member -> member.character.level >= 100).forEach(member -> refresh(member.character.name, member.character.realm));
    }

    private Character refresh(String characterName, String realm) {
        final CharacterDTO charDTO = battleNetClient.getCharacter(characterName, realm, CharacterParams.PVP, CharacterParams.PROGRESSION);
        Character charBD = characterDAO.findByNameAndRealm(characterName, realm);
        final Character updatedChar;

        //If the data from BattleNet is more resent then what we have in DB
        if (charBD == null || LocalDateTime.ofInstant(Instant.ofEpochMilli(charDTO.lastModified), ZoneId.systemDefault()).isAfter(charBD.getLastModified())) {
            updatedChar = CharacterDTOMapper.toCharacter(charDTO);
            //launch update in BDD in a thread

            characterDAO.save(updatedChar);

        } else {
            updatedChar = charBD;
        }
        return updatedChar;
    }

    /**
     * Get a list of characters with the highest achievement points
     *
     * @param sizeOfTop size of the list wanted
     * @return Sorted List of unique character with the highest achievement points
     */
    public List<Character> getAchievementRanking(int sizeOfTop) {
        //Page of the size sizeOfTheList * Number of potential character on the same account on 3 server on the same cluster(21)
        PageRequest pageRequest = new PageRequest(0, sizeOfTop * 21, Sort.Direction.DESC, "achievement");
        Page<Character> p = characterDAO.findAll(pageRequest);
        List<Character> uniqueList = AchievementSorter.getUniqueAchievementTopList(p.getContent());
        return uniqueList.subList(0, sizeOfTop);
    }

    /**
     * Get a List of {sizeOfRanking} Charactere surrounding the character with {idCharacter} on a achievement point level
     *
     * @param idCharacter   Character to compare to
     * @param sizeOfRanking Size of the total list
     * @return a List of character ordered by achievement points
     */
    public List<Character> getAchievementRankingAroundCharacter(int idCharacter, int sizeOfRanking) {
        int sizeGreater, sizeBelow;
        if (sizeOfRanking % 2 == 0) {
            sizeGreater = (sizeOfRanking / 2) + 1;
            sizeBelow = (sizeOfRanking / 2);
        } else {
            sizeGreater = (sizeOfRanking / 2);
            sizeBelow = sizeGreater;
        }

        List<Character> charAndSurroundingAchievers;
        PageRequest pageRequestDesc = new PageRequest(0, sizeBelow * 21, Sort.Direction.DESC, "achievement");
        PageRequest pageRequestAsc = new PageRequest(0, sizeGreater * 21, Sort.Direction.ASC, "achievement");

        //get the Characters we're looking for
        Character CharInCenter = characterDAO.findById(idCharacter);
        //get some characters below in achievement points
        //TODO Handle the case when there is no character found
        Page<Character> pLess = characterDAO.findAllByAchievementLessThan(CharInCenter.getAchievement(), pageRequestDesc);
        //get some characters with more achievement points
        Page<Character> pGreater = characterDAO.findAllByAchievementGreaterThan(CharInCenter.getAchievement(), pageRequestAsc);
        //TODO Handle the case where the is no greater/lesser achievement
        //remove characters on the same account and sort it in both list
        List<Character> lLess = AchievementSorter.getUniqueAchievementTopList(pLess.getContent());
        List<Character> lGreater = AchievementSorter.getUniqueAchievementTopList(pGreater.getContent());

        //Reverse the list of characters with lower achievement points and only keep sizeOfRanking/2 +1
        charAndSurroundingAchievers = Lists.reverse(lLess.subList(0, sizeBelow));
        charAndSurroundingAchievers.add(CharInCenter);
        charAndSurroundingAchievers.addAll(lGreater.subList(0, sizeGreater));

        return charAndSurroundingAchievers;
    }
}
