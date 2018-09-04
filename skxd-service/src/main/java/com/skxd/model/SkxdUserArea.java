package com.skxd.model;

import java.io.Serializable;

public class SkxdUserArea implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_user_area.id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_user_area.user_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_user_area.area_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    private String areaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_user_area
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_user_area.id
     *
     * @return the value of skxd_user_area.id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_user_area.id
     *
     * @param id the value for skxd_user_area.id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_user_area.user_id
     *
     * @return the value of skxd_user_area.user_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_user_area.user_id
     *
     * @param userId the value for skxd_user_area.user_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_user_area.area_id
     *
     * @return the value of skxd_user_area.area_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_user_area.area_id
     *
     * @param areaId the value for skxd_user_area.area_id
     *
     * @mbggenerated Sun Nov 29 11:26:05 CST 2015
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}