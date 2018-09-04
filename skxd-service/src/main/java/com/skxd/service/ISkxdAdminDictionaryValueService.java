package com.skxd.service;
import com.skxd.model.SkxdAdminDictionaryValue;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminDictionaryValueExample;
import java.util.List;
import java.util.Map;

import com.skxd.vo.SkxdAdminDictionaryValueVo;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminDictionaryValueService {

    public int saveOrUpdateSkxdAdminDictionaryValue(SkxdAdminDictionaryValue obj)throws Exception;

    public SkxdAdminDictionaryValue querySkxdAdminDictionaryValueById(String id)throws Exception;

    public int removeSkxdAdminDictionaryValueByIds(String ids)throws Exception;

    public List<SkxdAdminDictionaryValue> querySkxdAdminDictionaryValueList(SkxdAdminDictionaryValueExample example)throws Exception;

    public Page<SkxdAdminDictionaryValueVo> querySkxdAdminDictionaryValuePage(Map params)throws Exception;

    public List<SkxdAdminDictionaryValue> querySkxdAdminDictionaryValueByDictionary(String dId);
}
