package com.shask.guild_stats.battlenet;

import com.shask.guild_stats.GuildStatsApplication;
import com.shask.guild_stats.api_client.battlenet.BattleNetClient;
import com.shask.guild_stats.api_client.battlenet.params.CharacterParams;
import com.shask.guild_stats.api_client.battlenet.params.GuildParams;
import com.shask.guild_stats.api_client.battlenet.dtos.character.CharacterDTO;
import com.shask.guild_stats.api_client.battlenet.dtos.guild.GuildDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Steven Fougeron on 20/06/16.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuildStatsApplication.class)
@WebAppConfiguration
public class BattleNetClientTest {

    @Autowired
    BattleNetClient battleNetClient;

    @Test
    public void getCharacter()
    {
        CharacterDTO charDTO = battleNetClient.getCharacter("Shask","les sentinelles");
        Assert.assertTrue(charDTO.name.equals("Shask"));
    }

    @Test
    public void getCharacterPvp()
    {
        CharacterDTO charDTO = battleNetClient.getCharacter("Shask","les sentinelles", CharacterParams.PVP);
        Assert.assertTrue(charDTO.pvp.brackets.arena2v2.slug.equals("2v2"));
    }

    @Test
    public void getCharacterProgression()
    {
        CharacterDTO charDTO = battleNetClient.getCharacter("Shask","les sentinelles", CharacterParams.PROGRESSION);
        Assert.assertFalse(charDTO.progression.raids.isEmpty());
    }

    @Test
    public void getGuildMembers()
    {
        GuildDTO guildDTO = battleNetClient.getGuild(GuildParams.MEMBERS);
        Assert.assertFalse(guildDTO.members.isEmpty());
    }


}
