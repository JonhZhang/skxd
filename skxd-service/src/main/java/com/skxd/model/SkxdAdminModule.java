package com.skxd.model;

import java.io.Serializable;
import java.util.Date;

public class SkxdAdminModule implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.url
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.value
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.level
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.is_menu
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Integer isMenu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.parent
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String parent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.style
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private String style;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.sort
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.updated_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.created_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skxd_admin_module.is_delete
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private Integer isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_admin_module
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.id
     *
     * @return the value of skxd_admin_module.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.id
     *
     * @param id the value for skxd_admin_module.id
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.name
     *
     * @return the value of skxd_admin_module.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.name
     *
     * @param name the value for skxd_admin_module.name
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.url
     *
     * @return the value of skxd_admin_module.url
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.url
     *
     * @param url the value for skxd_admin_module.url
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.value
     *
     * @return the value of skxd_admin_module.value
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.value
     *
     * @param value the value for skxd_admin_module.value
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.level
     *
     * @return the value of skxd_admin_module.level
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.level
     *
     * @param level the value for skxd_admin_module.level
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.is_menu
     *
     * @return the value of skxd_admin_module.is_menu
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Integer getIsMenu() {
        return isMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.is_menu
     *
     * @param isMenu the value for skxd_admin_module.is_menu
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.parent
     *
     * @return the value of skxd_admin_module.parent
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.parent
     *
     * @param parent the value for skxd_admin_module.parent
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.style
     *
     * @return the value of skxd_admin_module.style
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public String getStyle() {
        return style;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.style
     *
     * @param style the value for skxd_admin_module.style
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.sort
     *
     * @return the value of skxd_admin_module.sort
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.sort
     *
     * @param sort the value for skxd_admin_module.sort
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.updated_time
     *
     * @return the value of skxd_admin_module.updated_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.updated_time
     *
     * @param updatedTime the value for skxd_admin_module.updated_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.created_time
     *
     * @return the value of skxd_admin_module.created_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.created_time
     *
     * @param createdTime the value for skxd_admin_module.created_time
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skxd_admin_module.is_delete
     *
     * @return the value of skxd_admin_module.is_delete
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skxd_admin_module.is_delete
     *
     * @param isDelete the value for skxd_admin_module.is_delete
     *
     * @mbggenerated Sun Nov 29 11:26:04 CST 2015
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}