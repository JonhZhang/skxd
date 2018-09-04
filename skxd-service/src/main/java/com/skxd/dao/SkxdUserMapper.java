package com.skxd.dao;

import com.skxd.model.SkxdUser;
import com.skxd.model.SkxdUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdUserMapper {
    int countByExample(SkxdUserExample example);

    int deleteByExample(SkxdUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SkxdUser record);

    int insertSelective(SkxdUser record);

    List<SkxdUser> selectByExample(SkxdUserExample example);

    SkxdUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SkxdUser record, @Param("example") SkxdUserExample example);

    int updateByExample(@Param("record") SkxdUser record, @Param("example") SkxdUserExample example);

    int updateByPrimaryKeySelective(SkxdUser record);

    int updateByPrimaryKey(SkxdUser record);
}