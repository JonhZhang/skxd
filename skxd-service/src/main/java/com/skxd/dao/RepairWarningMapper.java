package com.skxd.dao;

import com.skxd.model.RepairWarning;
import com.skxd.model.RepairWarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairWarningMapper {
    int countByExample(RepairWarningExample example);

    int deleteByExample(RepairWarningExample example);

    int deleteByPrimaryKey(String id);

    int insert(RepairWarning record);

    int insertSelective(RepairWarning record);

    List<RepairWarning> selectByExample(RepairWarningExample example);

    RepairWarning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RepairWarning record, @Param("example") RepairWarningExample example);

    int updateByExample(@Param("record") RepairWarning record, @Param("example") RepairWarningExample example);

    int updateByPrimaryKeySelective(RepairWarning record);

    int updateByPrimaryKey(RepairWarning record);
}