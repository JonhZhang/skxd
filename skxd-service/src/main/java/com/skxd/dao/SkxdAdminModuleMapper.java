package com.skxd.dao;

import com.skxd.model.SkxdAdminModule;
import com.skxd.model.SkxdAdminModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkxdAdminModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int countByExample(SkxdAdminModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int deleteByExample(SkxdAdminModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int insert(SkxdAdminModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int insertSelective(SkxdAdminModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    List<SkxdAdminModule> selectByExample(SkxdAdminModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    SkxdAdminModule selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int updateByExampleSelective(@Param("record") SkxdAdminModule record, @Param("example") SkxdAdminModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int updateByExample(@Param("record") SkxdAdminModule record, @Param("example") SkxdAdminModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int updateByPrimaryKeySelective(SkxdAdminModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    int updateByPrimaryKey(SkxdAdminModule record);
}