package com.skxd.dao;

import com.skxd.model.SkxdAnswer;
import com.skxd.model.SkxdAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdAnswerMapper {
    int countByExample(SkxdAnswerExample example);

    int deleteByExample(SkxdAnswerExample example);

    int deleteByPrimaryKey(String id);

    int insert(SkxdAnswer record);

    int insertSelective(SkxdAnswer record);

    List<SkxdAnswer> selectByExample(SkxdAnswerExample example);

    SkxdAnswer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SkxdAnswer record, @Param("example") SkxdAnswerExample example);

    int updateByExample(@Param("record") SkxdAnswer record, @Param("example") SkxdAnswerExample example);

    int updateByPrimaryKeySelective(SkxdAnswer record);

    int updateByPrimaryKey(SkxdAnswer record);
}