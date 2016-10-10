package com.shask.guild_stats.mappers;

import com.shask.guild_stats.dto.CharLittleDto;
import com.shask.guild_stats.mappers.generics.GenericMapper;
import com.shask.guild_stats.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Steven Fougeron on 07/10/16.
 *
 * This class generates a mapper between Character and CharLittleDto using mapStruct
 */
@Mapper
public interface CharacterMapper extends GenericMapper<Character,CharLittleDto> {

    CharacterMapper INSTANCE = Mappers.getMapper( CharacterMapper.class );

    @Override
    CharLittleDto modelToDto(Character model);

    @Override
    List<CharLittleDto> modelToDto(List<Character> modelList);

    @Override
    Character dtoToModel(CharLittleDto dto);

    @Override
    List<Character> dtoToModel(List<CharLittleDto> dtoList);
}
