package com.shask.guild_stats.webservice;

import com.shask.guild_stats.api_client.battlenet.BattleNetClient;
import com.shask.guild_stats.dto.CharLittleDto;
import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.service.battlenet.CharacterService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by Steven Fougeron on 31/05/16.
 */


@Controller
@RequestMapping("/characters")
public class CharactereWS {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharactereWS.class);

    @Autowired
    private BattleNetClient bNetClient;

    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        return "" ;//characterService.getCharacter(id);//TODO
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String refresh() {
        return bNetClient.getCharacter("Shask","les sentinelles").toString(); //TODO
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiImplicitParams({         // All this mumbo jumbo is for swagger to properly create proper field for the pageable object of Spring, no impact on the code what so ever
            //TODO Remove it when  https://github.com/springfox/springfox/issues/755 is closed
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.") })
    public List<CharLittleDto> getAll(@ApiIgnore @PageableDefault(value = 50) Pageable pageable) {
        return characterService.findAll(pageable);
    }






}
