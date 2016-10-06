package com.shask.guild_stats.webservice;

import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.service.battlenet.AchievementService;
import com.shask.guild_stats.service.battlenet.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Steven Fougeron on 21/06/16.
 */
@RestController
@CrossOrigin
@RequestMapping("/ranking")
public class RankingWS {

    @Autowired
    CharacterService characterService;

    @Autowired
    AchievementService achievementService;

    @CrossOrigin
    @RequestMapping(value = "/achievement/top/{sizeOfTopTier}", method = RequestMethod.GET)
    public  @ResponseBody List<Character> getAchievementTopRanks(@PathVariable int sizeOfTopTier) {
        return achievementService.getRanking(sizeOfTopTier);
    }

    @RequestMapping(value = "/achievement/{idCharacter}/{sizeOfTierList}", method = RequestMethod.GET)
    public   @ResponseBody List<Character> getAchievementRanksSurroundingRanks(@PathVariable int idCharacter, @PathVariable int sizeOfTierList) {
        return characterService.getAchievementRankingAroundCharacter(idCharacter, sizeOfTierList);
    }


    @RequestMapping(value = "/honorable-kill/top/{sizeOfTopTier}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getHonorableKillTopRanks(@PathVariable int sizeOfTopTier) {
        return characterService.getHonorableKillTopRanking(sizeOfTopTier);
    }

    @RequestMapping(value = "/honorable-kill/{idCharacter}/{sizeOfTierList}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getHonorableKillSurroundingRanks(@PathVariable int idCharacter, @PathVariable int sizeOfTierList) {
        return characterService.getHonorableKillRankingAroundCharacter(idCharacter, sizeOfTierList);
    }
}
