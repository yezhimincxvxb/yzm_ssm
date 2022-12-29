package com.yzm4.mapper;

import com.yzm4.entity.Movie;
import com.yzm4.entity.MovieCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieMapper {
    long countByExample(MovieCriteria example);

    int deleteByExample(MovieCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieCriteria example);

    Movie selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieCriteria example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieCriteria example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);
}