package com.skxd.model;

public class SkxdAnswerWithBLOBs extends SkxdAnswer {
    private String answerJsonData;

    private String sign;

    public String getAnswerJsonData() {
        return answerJsonData;
    }

    public void setAnswerJsonData(String answerJsonData) {
        this.answerJsonData = answerJsonData == null ? null : answerJsonData.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }
}