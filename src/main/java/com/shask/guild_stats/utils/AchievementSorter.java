package com.shask.guild_stats.utils;

import com.shask.guild_stats.model.Character;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Fougeron on 21/06/16.
 */

/**
 * Util class allowing you to get a list of unique Character belonging to the same account
 * Trying to determine the most played charactere ( Highter level, last update )
 */
//TODO Better Comparison to get the most played character for sure (PvE progression comparison / Pvp )
public class AchievementSorter {
    /**
     * Sort by Achievement -> Level -> LastModifiedDate unique Character (Characters that doesn't belong to the same account)
     * @param charList
     * @return
     */
    public static List<Character> getUniqueAchievementTopList(@NotEmpty List<Character> charList) {
        Character charBuffer = charList.get(0);
        List<Character> SortedUniqueList = new ArrayList<>();
        for (int i = 1; i < charList.size(); i++) {
            Character c = charList.get(i);
            if (c.getAchievement() != charBuffer.getAchievement()) {
                SortedUniqueList.add(charBuffer);
                charBuffer = c;
            } else if (c.getLevel() > charBuffer.getLevel()) {
                charBuffer = c;
            } else if (c.getLastModified().isAfter(charBuffer.getLastModified())) {
                charBuffer = c;
            }
        }
        return SortedUniqueList;
    }
}
