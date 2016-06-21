package com.shask.guild_stats.dto.battlenet.guild;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shask.guild_stats.dto.battlenet.character.EmblemDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven Fougeron on 01/06/16.
 */
public class GuildDTO {
    public long lastModified;
    public String name;
    public String realm;
    public String battlegroup;
    public short level;
    public short side;
    public long achievementPoints;
    public List<Member> members = new ArrayList<>();
    public EmblemDTO emblem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
