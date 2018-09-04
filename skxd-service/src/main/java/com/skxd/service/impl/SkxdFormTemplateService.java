package com.skxd.service.impl;

import com.skxd.dao.SkxdFormTemplateMapper;
import com.skxd.model.SkxdFormTemplate;
import com.skxd.service.ISkxdFormTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/10.
 */
@Service
public class SkxdFormTemplateService implements ISkxdFormTemplateService {

    @Autowired
    private SkxdFormTemplateMapper skxdFormTemplateMapper;

    @Override
    public SkxdFormTemplate querySkxdFormTemplateById(String id) {
        return skxdFormTemplateMapper.selectByPrimaryKey(id);
    }

}
