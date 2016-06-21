package com.shask.guild_stats.webservice;

import com.shask.guild_stats.api_client.BattleNetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Steven Fougeron on 31/05/16.
 */


@Controller
@RequestMapping("/character")
public class CharactereWS {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharactereWS.class);

    @Autowired
    private BattleNetClient bNetService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        return id.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String getById() {
        return bNetService.getCharacter("Shask","les sentinelles").toString();
    }





}
