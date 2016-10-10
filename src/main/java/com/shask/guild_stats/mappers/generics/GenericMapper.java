package com.shask.guild_stats.mappers.generics;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Steven Fougeron on 07/10/16.
 */

public interface GenericMapper<T, U extends Serializable> {
    /**
     * Map a model to a dto
     *
     * @param model model to map
     * @return
     */
    U modelToDto(T model);

    /**
     * Map a list of model to a list of dto
     *
     * @param modelList list of model to map
     * @return
     */
    List<U> modelToDto(List<T> modelList);

    /**
     * Map a dto to a model
     *
     * @param dto to map
     * @return
     */
    T dtoToModel(U dto);

    /**
     * Map a List of dto to a list of model
     *
     * @param dtoList list of dto to map
     * @return
     */
    List<T> dtoToModel(List<U> dtoList);
}