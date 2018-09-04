package com.skxd.dao;

import com.skxd.model.SkxdTask;
import com.skxd.model.SkxdTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int countByExample(SkxdTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int deleteByExample(SkxdTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int insert(SkxdTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int insertSelective(SkxdTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    List<SkxdTask> selectByExample(SkxdTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    SkxdTask selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int updateByExampleSelective(@Param("record") SkxdTask record, @Param("example") SkxdTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int updateByExample(@Param("record") SkxdTask record, @Param("example") SkxdTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int updateByPrimaryKeySelective(SkxdTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_task
     *
     * @mbggenerated Sun Nov 29 18:27:24 CST 2015
     */
    int updateByPrimaryKey(SkxdTask record);
}