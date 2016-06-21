package com.shask.guild_stats.wow_progress;

import com.shask.guild_stats.GuildStatsApplication;
import com.shask.guild_stats.api_client.WowProgressClient;
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
public class WowProgressTest {

    @Autowired
    WowProgressClient wowProgressClient;

    @Test
    public void getGuildRank() {
        Assert.assertTrue(wowProgressClient.getGuildRank().realm_rank > 0);
    }
}
