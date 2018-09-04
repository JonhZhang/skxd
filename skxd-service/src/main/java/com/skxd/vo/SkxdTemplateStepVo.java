package com.skxd.vo;
import com.skxd.model.SkxdTemplateInput;
import com.skxd.model.SkxdTemplateStep;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/10.
 */
public class SkxdTemplateStepVo extends SkxdTemplateStep implements Serializable{

    private List<SkxdTemplateInputVo> skxdTemplateInputVoList;

    public List<SkxdTemplateInputVo> getSkxdTemplateInputVoList() {
        return skxdTemplateInputVoList;
    }

    public void setSkxdTemplateInputVoList(List<SkxdTemplateInputVo> skxdTemplateInputVoList) {
        this.skxdTemplateInputVoList = skxdTemplateInputVoList;
    }
}
