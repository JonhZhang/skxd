package com.skxd.controller.util;

import com.zxs.utils.lang.StringUtils;

import java.io.Serializable;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/15.
 */
public class UploadConfig implements Serializable{

    private String savePath="";

    private int smallWidth;

    private int smallHeight;

    private int mediumWidth;

    private int mediumHeight;

    public int getSmallWidth() {
        return smallWidth;
    }

    public void setSmallWidth(int smallWidth) {
        this.smallWidth = smallWidth;
    }

    public int getSmallHeight() {
        return smallHeight;
    }

    public void setSmallHeight(int smallHeight) {
        this.smallHeight = smallHeight;
    }

    public int getMediumWidth() {
        return mediumWidth;
    }

    public void setMediumWidth(int mediumWidth) {
        this.mediumWidth = mediumWidth;
    }

    public int getMediumHeight() {
        return mediumHeight;
    }

    public void setMediumHeight(int mediumHeight) {
        this.mediumHeight = mediumHeight;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public static String createNewFileName(){
        return StringUtils.getCurrentTime().replaceAll(" ","@").replaceAll(":","-").replaceAll("\\.", "-")+"@skxd-"+ StringUtils.createValidateCode(5);
    }
}
