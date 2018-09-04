package com.skxd.service;
import com.skxd.model.SkxdAdminDictionary;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminDictionaryExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminDictionaryService {

    public int saveOrUpdateSkxdAdminDictionary(SkxdAdminDictionary obj)throws Exception;

    public SkxdAdminDictionary querySkxdAdminDictionaryById(String id)throws Exception;

    public int removeSkxdAdminDictionaryByIds(String ids)throws Exception;

    public List<SkxdAdminDictionary> querySkxdAdminDictionaryList(SkxdAdminDictionaryExample example)throws Exception;

    public Page<SkxdAdminDictionary> querySkxdAdminDictionaryPage(Map params)throws Exception;

    public List<SkxdAdminDictionary> queryAllSkxdAdminDictionary();
}
