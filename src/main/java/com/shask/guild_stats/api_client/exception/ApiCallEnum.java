package com.shask.guild_stats.api_client.exception;


public enum ApiCallEnum {


    BATTLE_NET_ERROR("Something went wrong with getting information from battle.net API"),
    WOW_PROGRESS_ERROR("Something went wrong with getting information from wow-progress API"),

    BATTLE_NET_DTO_MAPPER("Something went wrong during the mapping from battlenet dto to models");


    private String msg;

    ApiCallEnum(String msg)
    {
        this.msg=msg;
    }
}
