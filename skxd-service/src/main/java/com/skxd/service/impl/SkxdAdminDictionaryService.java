package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminDictionaryMapper;
import com.skxd.model.SkxdAdminDictionary;
import com.skxd.model.SkxdAdminDictionaryExample;
import com.skxd.service.ISkxdAdminDictionaryService;
import com.skxd.service.common.SelectService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SkxdAdminDictionaryService implements ISkxdAdminDictionaryService {

    @Autowired
    private SkxdAdminDictionaryMapper skxdAdminDictionaryMapper;

    @Autowired
    private SelectService<SkxdAdminDictionary> selectService;

    public int saveOrUpdateSkxdAdminDictionary(SkxdAdminDictionary skxdAdminDictionary) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminDictionary.getId())){
            skxdAdminDictionary.setUpdatedTime(new Date());
            flag=skxdAdminDictionaryMapper.updateByPrimaryKeySelective(skxdAdminDictionary);
        }else{
            skxdAdminDictionary.setId(StringUtils.randomUUID());
            skxdAdminDictionary.setCreatedTime(new Date());
            flag=skxdAdminDictionaryMapper.insert(skxdAdminDictionary);
        }
        return flag;
    }

    public SkxdAdminDictionary querySkxdAdminDictionaryById(String id) throws Exception{
        return skxdAdminDictionaryMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminDictionaryByIds(String ids)throws Exception{
        SkxdAdminDictionaryExample skxdAdminDictionaryExample=new SkxdAdminDictionaryExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminDictionaryExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminDictionaryMapper.deleteByExample(skxdAdminDictionaryExample);
        return flag;
    }

    public List<SkxdAdminDictionary> querySkxdAdminDictionaryList(SkxdAdminDictionaryExample example)throws Exception{
        return skxdAdminDictionaryMapper.selectByExample(example);
    }

    public Page<SkxdAdminDictionary> querySkxdAdminDictionaryPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminDictionary.getSkxdAdminDictionaryCount";
        String listSqlId = "SkxdAdminDictionary.getSkxdAdminDictionaryPage";
        Page<SkxdAdminDictionary> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public List<SkxdAdminDictionary> queryAllSkxdAdminDictionary() {
        SkxdAdminDictionaryExample skxdAdminDictionaryExample=new SkxdAdminDictionaryExample();
        skxdAdminDictionaryExample.setOrderByClause("name asc");
        List<SkxdAdminDictionary> skxdAdminDictionaryList=skxdAdminDictionaryMapper.selectByExample(skxdAdminDictionaryExample);
        return skxdAdminDictionaryList;
    }
}
