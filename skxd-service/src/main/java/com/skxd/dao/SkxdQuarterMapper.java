package com.skxd.dao;

import com.skxd.model.SkxdQuarter;
import com.skxd.model.SkxdQuarterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdQuarterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int countByExample(SkxdQuarterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int deleteByExample(SkxdQuarterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int insert(SkxdQuarter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int insertSelective(SkxdQuarter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    List<SkxdQuarter> selectByExample(SkxdQuarterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    SkxdQuarter selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int updateByExampleSelective(@Param("record") SkxdQuarter record, @Param("example") SkxdQuarterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int updateByExample(@Param("record") SkxdQuarter record, @Param("example") SkxdQuarterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int updateByPrimaryKeySelective(SkxdQuarter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_quarter
     *
     * @mbggenerated Sat Jul 02 19:49:52 CST 2016
     */
    int updateByPrimaryKey(SkxdQuarter record);
}