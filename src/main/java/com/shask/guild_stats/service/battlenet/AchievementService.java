package com.shask.guild_stats.service.battlenet;

import com.shask.guild_stats.dao.CharacterDAO;
import com.shask.guild_stats.model.Character;
import com.shask.guild_stats.utils.AchievementSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by Steven Fougeron on 30/09/16.
 */
@Service
public class AchievementService {

    @Autowired
    CharacterDAO characterDAO;

    /**
     * Get a list of characters with the highest achievement points
     *
     * @param sizeOfTier size of the list wanted
     * @return Sorted List of unique character with the highest achievement points
     */
    public List<Character> getRanking(@Min(0) int sizeOfTier) {
        //Page of the size sizeOfTheList * Number of potential character on the same account on 3 server on the same cluster(21)
        PageRequest pageRequest = new PageRequest(0, sizeOfTier * 21, Sort.Direction.DESC, "achievement");
        Page<Character> p = characterDAO.findAll(pageRequest);
        List<Character> uniqueList = AchievementSorter.getUniqueAchievementTopList(p.getContent());
        return uniqueList.subList(0, sizeOfTier);
    }
}
