package com.skxd.service.impl;
import com.skxd.dao.SkxdQuarterMapper;
import com.skxd.model.SkxdQuarter;
import com.skxd.model.SkxdQuarterExample;
import com.skxd.service.ISkxdQuarterService;
import com.skxd.service.common.SelectService;
import com.zxs.busidao.GenericDAO;
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
public class SkxdQuarterServiceImpl implements ISkxdQuarterService {

    @Autowired
    private SkxdQuarterMapper skxdQuarterMapper;

    @Autowired
    private GenericDAO genericDAO;

    @Autowired
    private SelectService<SkxdQuarter> selectService;

    public int saveOrUpdateSkxdQuarter(SkxdQuarter skxdQuarter) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdQuarter.getId())){
            flag=skxdQuarterMapper.updateByPrimaryKeySelective(skxdQuarter);
        }else{
            skxdQuarter.setId(StringUtils.randomUUID());
            skxdQuarter.setCreatedTime(new Date());
            flag=skxdQuarterMapper.insert(skxdQuarter);
        }
        return flag;
    }

    public SkxdQuarter querySkxdQuarterById(String id) throws Exception{
        return skxdQuarterMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdQuarterByIds(String ids)throws Exception{
        SkxdQuarterExample skxdQuarterExample=new SkxdQuarterExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdQuarterExample.createCriteria().andIdIn(idsList);
        int flag=skxdQuarterMapper.deleteByExample(skxdQuarterExample);
        return flag;
    }

    public List<SkxdQuarter> querySkxdQuarterList(SkxdQuarterExample example)throws Exception{
        return skxdQuarterMapper.selectByExample(example);
    }

    public Page<SkxdQuarter> querySkxdQuarterPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdQuarter.getSkxdQuarterCount";
        String listSqlId = "SkxdQuarter.getSkxdQuarterPage";
        Page<SkxdQuarter> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public int batchAddSkxdQuarter(List<SkxdQuarter> skxdQuarterList) throws Exception {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdQuarterList)) {
            flag = genericDAO.insert("statics.batchAddSkxdQuarter",skxdQuarterList);
        }
        return flag;
    }
}
