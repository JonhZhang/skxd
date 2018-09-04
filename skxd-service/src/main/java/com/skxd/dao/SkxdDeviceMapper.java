package com.skxd.dao;

import com.skxd.model.SkxdDevice;
import com.skxd.model.SkxdDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdDeviceMapper {
    int countByExample(SkxdDeviceExample example);

    int deleteByExample(SkxdDeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(SkxdDevice record);

    int insertSelective(SkxdDevice record);

    List<SkxdDevice> selectByExample(SkxdDeviceExample example);

    SkxdDevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SkxdDevice record, @Param("example") SkxdDeviceExample example);

    int updateByExample(@Param("record") SkxdDevice record, @Param("example") SkxdDeviceExample example);

    int updateByPrimaryKeySelective(SkxdDevice record);

    int updateByPrimaryKey(SkxdDevice record);
}