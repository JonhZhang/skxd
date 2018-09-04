package com.skxd.model;

import java.util.Date;

public class SkxdCustom {
    private String id;

    private String customName;

    private String address;

    private String areaNo;

    private String createdUser;

    private Date createdDate;

    private String updatedUser;

    private Date updatedDate;

    private String customType;

    private String customLevel;

    private String roomTest;

    private String linkman;

    private String phone;

    private String itemSpread;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo == null ? null : areaNo.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser == null ? null : updatedUser.trim();
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
    }

    public String getCustomLevel() {
        return customLevel;
    }

    public void setCustomLevel(String customLevel) {
        this.customLevel = customLevel == null ? null : customLevel.trim();
    }

    public String getRoomTest() {
        return roomTest;
    }

    public void setRoomTest(String roomTest) {
        this.roomTest = roomTest == null ? null : roomTest.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getItemSpread() {
        return itemSpread;
    }

    public void setItemSpread(String itemSpread) {
        this.itemSpread = itemSpread == null ? null : itemSpread.trim();
    }
}