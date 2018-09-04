package com.skxd.model;

import java.io.Serializable;
import java.util.Date;

public class SkxdAdminUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.password
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.created_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Date createdDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.created_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.updated_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Date updatedDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_user.updated_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String updatedUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_admin_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.id
     *
     * @return the value of skxd_admin_user.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.id
     *
     * @param id the value for skxd_admin_user.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.name
     *
     * @return the value of skxd_admin_user.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.name
     *
     * @param name the value for skxd_admin_user.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.password
     *
     * @return the value of skxd_admin_user.password
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.password
     *
     * @param password the value for skxd_admin_user.password
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.created_date
     *
     * @return the value of skxd_admin_user.created_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.created_date
     *
     * @param createdDate the value for skxd_admin_user.created_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.created_user
     *
     * @return the value of skxd_admin_user.created_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.created_user
     *
     * @param createdUser the value for skxd_admin_user.created_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.updated_date
     *
     * @return the value of skxd_admin_user.updated_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.updated_date
     *
     * @param updatedDate the value for skxd_admin_user.updated_date
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_user.updated_user
     *
     * @return the value of skxd_admin_user.updated_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getUpdatedUser() {
        return updatedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_user.updated_user
     *
     * @param updatedUser the value for skxd_admin_user.updated_user
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }
}