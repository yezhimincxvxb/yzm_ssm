package com.yzm3.mapper;

import com.yzm3.entity.Movie;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {

    Movie getMovieById(@Param("id") Integer id);

}
