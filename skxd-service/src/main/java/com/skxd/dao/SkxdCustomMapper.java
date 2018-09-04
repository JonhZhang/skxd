package com.skxd.dao;

import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdCustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdCustomMapper {
    int countByExample(SkxdCustomExample example);

    int deleteByExample(SkxdCustomExample example);

    int deleteByPrimaryKey(String id);

    int insert(SkxdCustom record);

    int insertSelective(SkxdCustom record);

    List<SkxdCustom> selectByExample(SkxdCustomExample example);

    SkxdCustom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SkxdCustom record, @Param("example") SkxdCustomExample example);

    int updateByExample(@Param("record") SkxdCustom record, @Param("example") SkxdCustomExample example);

    int updateByPrimaryKeySelective(SkxdCustom record);

    int updateByPrimaryKey(SkxdCustom record);
}