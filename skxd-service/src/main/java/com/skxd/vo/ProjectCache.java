package com.skxd.vo;

import com.skxd.model.SkxdTemplateInput;
import com.skxd.model.SkxdTemplateStep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/15.
 */
public class ProjectCache {

    public static Map<String, List<SkxdTemplateStep>> projectSteps = new HashMap<String, List<SkxdTemplateStep>>();

    public static Map<String, List<SkxdTemplateInput>> stepInputs = new HashMap<String, List<SkxdTemplateInput>>();

}