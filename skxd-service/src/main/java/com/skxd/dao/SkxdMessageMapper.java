package com.skxd.dao;

import com.skxd.model.SkxdMessage;
import com.skxd.model.SkxdMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int countByExample(SkxdMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int deleteByExample(SkxdMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int insert(SkxdMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int insertSelective(SkxdMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    List<SkxdMessage> selectByExample(SkxdMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    SkxdMessage selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int updateByExampleSelective(@Param("record") SkxdMessage record, @Param("example") SkxdMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int updateByExample(@Param("record") SkxdMessage record, @Param("example") SkxdMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int updateByPrimaryKeySelective(SkxdMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_message
     *
     * @mbggenerated Sun Nov 29 21:24:30 CST 2015
     */
    int updateByPrimaryKey(SkxdMessage record);
}