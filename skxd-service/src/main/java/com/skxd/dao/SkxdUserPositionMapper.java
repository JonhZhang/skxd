package com.skxd.dao;

import com.skxd.model.SkxdUserPosition;
import com.skxd.model.SkxdUserPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdUserPositionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int countByExample(SkxdUserPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int deleteByExample(SkxdUserPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int insert(SkxdUserPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int insertSelective(SkxdUserPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    List<SkxdUserPosition> selectByExample(SkxdUserPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    SkxdUserPosition selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByExampleSelective(@Param("record") SkxdUserPosition record, @Param("example") SkxdUserPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByExample(@Param("record") SkxdUserPosition record, @Param("example") SkxdUserPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByPrimaryKeySelective(SkxdUserPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_position
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByPrimaryKey(SkxdUserPosition record);
}