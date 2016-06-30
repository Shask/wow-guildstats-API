package com.shask.guild_stats.webservice;

import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.service.battlenet.BattleNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    BattleNetService battleNetService;

    @CrossOrigin
    @RequestMapping(value = "/achievement/top/{sizeOfTopTier}", method = RequestMethod.GET)
    public  @ResponseBody List<Character> getAchievementTopRanks(@PathVariable int sizeOfTopTier) {
        return battleNetService.getAchievementRanking(sizeOfTopTier);
    }

    @RequestMapping(value = "/achievement/{idCharacter}/{sizeOfTierList}", method = RequestMethod.GET)
    public   @ResponseBody List<Character> getAchievementRanksSurroundingRanks(@PathVariable int idCharacter, @PathVariable int sizeOfTierList) {
        return battleNetService.getAchievementRankingAroundCharacter(idCharacter, sizeOfTierList);
    }


    @RequestMapping(value = "/honorable-kill/top/{sizeOfTopTier}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getHonorableKillTopRanks(@PathVariable int sizeOfTopTier) {
        return battleNetService.getHonorableKillTopRanking(sizeOfTopTier);
    }

    @RequestMapping(value = "/honorable-kill/{idCharacter}/{sizeOfTierList}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getHonorableKillSurroundingRanks(@PathVariable int idCharacter, @PathVariable int sizeOfTierList) {
        return battleNetService.getHonorableKillRankingAroundCharacter(idCharacter, sizeOfTierList);
    }
}
