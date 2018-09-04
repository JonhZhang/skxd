package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminDictionaryValueMapper;
import com.skxd.model.SkxdAdminDictionaryValue;
import com.skxd.model.SkxdAdminDictionaryValueExample;
import com.skxd.service.ISkxdAdminDictionaryValueService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.SkxdAdminDictionaryValueVo;
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
public class SkxdAdminDictionaryValueServiceImpl implements ISkxdAdminDictionaryValueService {

    @Autowired
    private SkxdAdminDictionaryValueMapper skxdAdminDictionaryValueMapper;

    @Autowired
    private SelectService<SkxdAdminDictionaryValueVo> selectService;

    public int saveOrUpdateSkxdAdminDictionaryValue(SkxdAdminDictionaryValue skxdAdminDictionaryValue) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminDictionaryValue.getId())){
            skxdAdminDictionaryValue.setUpdatedTime(new Date());
            flag=skxdAdminDictionaryValueMapper.updateByPrimaryKeySelective(skxdAdminDictionaryValue);
        }else{
            skxdAdminDictionaryValue.setId(StringUtils.randomUUID());
            skxdAdminDictionaryValue.setCreatedTime(new Date());
            flag=skxdAdminDictionaryValueMapper.insert(skxdAdminDictionaryValue);
        }
        return flag;
    }

    public SkxdAdminDictionaryValue querySkxdAdminDictionaryValueById(String id) throws Exception{
        return skxdAdminDictionaryValueMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminDictionaryValueByIds(String ids)throws Exception{
        SkxdAdminDictionaryValueExample skxdAdminDictionaryValueExample=new SkxdAdminDictionaryValueExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminDictionaryValueExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminDictionaryValueMapper.deleteByExample(skxdAdminDictionaryValueExample);
        return flag;
    }

    public List<SkxdAdminDictionaryValue> querySkxdAdminDictionaryValueList(SkxdAdminDictionaryValueExample example)throws Exception{
        return skxdAdminDictionaryValueMapper.selectByExample(example);
    }

    public Page<SkxdAdminDictionaryValueVo> querySkxdAdminDictionaryValuePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminDictionaryValue.getSkxdAdminDictionaryValueCount";
        String listSqlId = "SkxdAdminDictionaryValue.getSkxdAdminDictionaryValuePage";
        Page<SkxdAdminDictionaryValueVo> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public List<SkxdAdminDictionaryValue> querySkxdAdminDictionaryValueByDictionary(String dId) {
        List<SkxdAdminDictionaryValue> skxdAdminDictionaryValues=new ArrayList<SkxdAdminDictionaryValue>();
        SkxdAdminDictionaryValueExample skxdAdminDictionaryValueExample=new SkxdAdminDictionaryValueExample();
        skxdAdminDictionaryValueExample.createCriteria().andDIdEqualTo(dId);
        skxdAdminDictionaryValueExample.setOrderByClause("name asc");
        return skxdAdminDictionaryValueMapper.selectByExample(skxdAdminDictionaryValueExample);
    }
}
