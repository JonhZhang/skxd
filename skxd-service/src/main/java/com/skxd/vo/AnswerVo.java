package com.skxd.vo;

import com.skxd.model.SkxdAnswer;

import java.util.List;

/**
 * Created by shang-pc on 2015/11/15.
 */
public class AnswerVo extends SkxdAnswer {

    private String userName;

    private String projectName;

    private String customName;

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    private List<AnswerValueVo> answerValueVoList;

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

    public List<AnswerValueVo> getAnswerValueVoList() {
        return answerValueVoList;
    }

    public void setAnswerValueVoList(List<AnswerValueVo> answerValueVoList) {
        this.answerValueVoList = answerValueVoList;
    }
}
