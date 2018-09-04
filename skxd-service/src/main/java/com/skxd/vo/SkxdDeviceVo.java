package com.skxd.vo;

import com.skxd.model.SkxdDevice;

/**
 * Created by shang-pc on 2015/11/8.
 */
public class SkxdDeviceVo extends SkxdDevice{

    private String customName;

    private String departMentName;

    private String province;

    private String city;
    private String customType;

    private String customLevel;

    private String roomTest;

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public String getCustomLevel() {
        return customLevel;
    }

    public void setCustomLevel(String customLevel) {
        this.customLevel = customLevel;
    }

    public String getRoomTest() {
        return roomTest;
    }

    public void setRoomTest(String roomTest) {
        this.roomTest = roomTest;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getDepartMentName() {
        return departMentName;
    }

    public void setDepartMentName(String departMentName) {
        this.departMentName = departMentName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
