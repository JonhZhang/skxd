package com.skxd.dao;

import com.skxd.model.SkxdUserArea;
import com.skxd.model.SkxdUserAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdUserAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int countByExample(SkxdUserAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int deleteByExample(SkxdUserAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int insert(SkxdUserArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int insertSelective(SkxdUserArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    List<SkxdUserArea> selectByExample(SkxdUserAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    SkxdUserArea selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByExampleSelective(@Param("record") SkxdUserArea record, @Param("example") SkxdUserAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByExample(@Param("record") SkxdUserArea record, @Param("example") SkxdUserAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByPrimaryKeySelective(SkxdUserArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    int updateByPrimaryKey(SkxdUserArea record);
}