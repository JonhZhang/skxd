package com.skxd.vo;

import com.skxd.model.SkxdAnswerValue;

/**
 * Created by shang-pc on 2015/11/15.
 */
public class AnswerValueVo extends SkxdAnswerValue {

    private String inputName;
    private String inputType;
    private String inputContent;

    @Override
    public String getInputName() {
        return inputName;
    }

    @Override
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    @Override
    public String getInputType() {
        return inputType;
    }

    @Override
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
