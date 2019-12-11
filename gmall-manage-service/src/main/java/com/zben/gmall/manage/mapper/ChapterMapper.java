package com.zben.gmall.manage.mapper;

import com.zben.gmall.bean.CalculatorChapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @DESC:
 * @AUTHOR: zhouben
 * @DATE: 2019/12/5 0005 18:06
 */
@Mapper
public interface ChapterMapper {

    @Select("select * from t_hc_calculator_chapter where his_id=#{hisId} and article_id=#{articleId}")
    List<CalculatorChapter> chapterList(@Param("hisId") Long hisId, @Param("articleId") Integer articleId);

}
