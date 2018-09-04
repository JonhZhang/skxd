package com.skxd.dao;

import com.skxd.model.SkxdTemplateInput;
import com.skxd.model.SkxdTemplateInputExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdTemplateInputMapper {
    int countByExample(SkxdTemplateInputExample example);

    int deleteByExample(SkxdTemplateInputExample example);

    int deleteByPrimaryKey(String id);

    int insert(SkxdTemplateInput record);

    int insertSelective(SkxdTemplateInput record);

    List<SkxdTemplateInput> selectByExample(SkxdTemplateInputExample example);

    SkxdTemplateInput selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SkxdTemplateInput record, @Param("example") SkxdTemplateInputExample example);

    int updateByExample(@Param("record") SkxdTemplateInput record, @Param("example") SkxdTemplateInputExample example);

    int updateByPrimaryKeySelective(SkxdTemplateInput record);

    int updateByPrimaryKey(SkxdTemplateInput record);
}