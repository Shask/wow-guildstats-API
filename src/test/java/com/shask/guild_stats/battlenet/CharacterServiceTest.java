package com.shask.guild_stats.battlenet;

import com.shask.guild_stats.GuildStatsApplication;

import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.service.battlenet.AchievementService;
import com.shask.guild_stats.service.battlenet.CharacterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuildStatsApplication.class)
@WebAppConfiguration
public class CharacterServiceTest {
    @Autowired
    CharacterService characterService;

    @Autowired
    AchievementService achievementService;

    @Test
    public void testRefreshAll() {
        characterService.refreshAll();
        Assert.assertTrue(true);
    }

    @Test
    public void testTopAchievement() {
        List<Character> charFromDB = achievementService.getRanking(5);
        Assert.assertFalse(charFromDB.isEmpty());
    }

    @Test
    public void testAroundingAchievement() {
        List<Character> charFromDB = characterService.getAchievementRankingAroundCharacter(1, 5);
        Assert.assertFalse(charFromDB.isEmpty());
    }

    @Test
    public void testAroundingAchievementSize() {
        List<Character> charFromDB = characterService.getAchievementRankingAroundCharacter(1, 5);
        Assert.assertTrue(charFromDB.size() == 5);
    }

    @Test
    public void testAroundingAchievementSizePair() {
        List<Character> charFromDB = characterService.getAchievementRankingAroundCharacter(1, 6);
        charFromDB.stream().forEach(a->System.out.println(a));
        Assert.assertTrue(charFromDB.size() == 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAroundingAchievementParams() {
        characterService.getAchievementRankingAroundCharacter(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHonorableKillsParams() {
        characterService.getHonorableKillTopRanking(-1);
    }

    @Test
    public void testHonorableKillsSize() {
        List<Character> charFromDB = characterService.getHonorableKillTopRanking(5);
        Assert.assertTrue(charFromDB.size() == 5);
    }

}

