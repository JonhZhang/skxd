package com.skxd.vo;

import com.skxd.model.SkxdAnswer;

/**
 * Created by shang-pc on 2015/12/19.
 */
public class SkxdAnswerPageVo extends SkxdAnswer{
    private String userName;
    private String projectName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
