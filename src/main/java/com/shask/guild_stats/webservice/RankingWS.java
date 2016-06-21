package com.shask.guild_stats.webservice;

import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.service.battlenet.BattleNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Steven Fougeron on 21/06/16.
 */
@Controller
@RequestMapping("/ranking")
public class RankingWS {

    @Autowired
    BattleNetService battleNetService;

    @RequestMapping(value = "/achievement/top/{sizeOfTopTier}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getTopAchievementRanks(@PathVariable int sizeOfTopTier) {
        return battleNetService.getAchievementRanking(sizeOfTopTier);
    }

    @RequestMapping(value = "/achievement/{idCharacter}/{sizeOfTierList}", method = RequestMethod.GET)
    @ResponseBody
    public List<Character> getAchievementRanksAroundCharacter(@PathVariable int idCharacter, @PathVariable int sizeOfTierList) {
        return battleNetService.getAchievementRankingAroundCharacter(idCharacter, sizeOfTierList);
    }
}
