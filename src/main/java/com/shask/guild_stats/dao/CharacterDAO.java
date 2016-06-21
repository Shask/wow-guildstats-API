package com.shask.guild_stats.dao;

import com.shask.guild_stats.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Steven Fougeron on 17/06/16.
 */
@Repository
public interface CharacterDAO extends CrudRepository<Character, Long> {

    Character findByNameAndRealm(String name, String realm);
    Character findById(long id);
    List<Character> findAllOrderByAchievement(Pageable pageable);
    Page<Character> findAll(Pageable pageable);
    Page<Character> findAllByAchievementLessThan(long achievement,Pageable pageable);
    Page<Character> findAllByAchievementGreaterThan(long achievement,Pageable pageable);

}
