package com.shask.guild_stats.api_client.battlenet.params;

/**
 * Created by Steven Fougeron on 20/06/16.
 */
public enum CharacterParams implements BattleNetParams {
    AUDIT, TITLES, TALENTS, STATS, STATISTICS, REPUTATION, QUESTS, PVP, PROGRESSION, PROFESSIONS, PETSLOTS, PETS, MOUNTS,
    ITEMS, HUNTERPETS, GUILD, FEED, APPEARANCE, ACHIEVEMENTS;


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
