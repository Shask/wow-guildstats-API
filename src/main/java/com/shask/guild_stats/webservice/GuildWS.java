package com.shask.guild_stats.webservice;

import com.shask.guild_stats.api_client.battlenet.dtos.guild.GuildDTO;
import com.shask.guild_stats.api_client.battlenet.dtos.guild.Member;
import com.shask.guild_stats.api_client.battlenet.BattleNetClient;
import com.shask.guild_stats.api_client.wowprogress.WowProgressClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Steven Fougeron on 03/06/16.
 */
@Controller
@RequestMapping("/guild")
public class GuildWS {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuildWS.class);

    @Autowired
    WowProgressClient wowProgressClient;
    @Autowired
    BattleNetClient battleNetClient;

    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    @ResponseBody
    public String getRank() {
        return wowProgressClient.getGuildRank().toString();
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    @ResponseBody
    public String getMembers() {
        StringBuilder s = new StringBuilder();
        GuildDTO g = battleNetClient.getGuild();
        LOGGER.info(g.name);
        for (Member m : g.members) {
            s.append(m.character.name).append(" ");
        }
        return s.toString();
    }
}
