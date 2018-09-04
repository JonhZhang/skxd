package com.skxd.vo;

import com.skxd.model.SkxdAdminDictionary;
import com.skxd.model.SkxdAdminDictionaryValue;
import com.skxd.model.SkxdTemplateInput;

import java.util.List;

/**
 * Created by shang-pc on 2015/11/15.
 */
public class SkxdTemplateInputVo extends SkxdTemplateInput{

    private String answers;

    private String values;

    public String getAnswers() {
        return answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
