package com.skxd.service.impl;
import com.skxd.dao.SkxdUserPositionMapper;
import com.skxd.model.SkxdUserPosition;
import com.skxd.model.SkxdUserPositionExample;
import com.skxd.service.ISkxdUserPositionService;
import com.zxs.busidao.GenericDAOImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.*;

import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import com.skxd.service.common.SelectService;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SkxdUserPositionService implements ISkxdUserPositionService {

    @Autowired
    private SkxdUserPositionMapper skxdUserPositionMapper;

    @Autowired
    private GenericDAOImpl genericDAO;

    @Autowired
    private  SelectService<SkxdUserPosition> skxdUserPositionService;

    public int saveOrUpdateSkxdUserPosition(SkxdUserPosition skxdUserPosition) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdUserPosition.getId())){
//            skxdUserPosition.setUpdatedDate(new Date());
            flag=skxdUserPositionMapper.updateByPrimaryKeySelective(skxdUserPosition);
        }else{
            skxdUserPosition.setId(StringUtils.randomUUID());
            skxdUserPosition.setCreatedDate(new Date());
            flag=skxdUserPositionMapper.insert(skxdUserPosition);
        }
        return flag;
    }

    public SkxdUserPosition querySkxdUserPositionById(String id) throws Exception{
        return skxdUserPositionMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdUserPositionByIds(String ids)throws Exception{
        SkxdUserPositionExample skxdUserPositionExample=new SkxdUserPositionExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdUserPositionExample.createCriteria().andIdIn(idsList);
        int flag=skxdUserPositionMapper.deleteByExample(skxdUserPositionExample);
        return flag;
    }

    public List<SkxdUserPosition> querySkxdUserPositionList(SkxdUserPositionExample example)throws Exception{
        return skxdUserPositionMapper.selectByExample(example);
    }

    public Page<SkxdUserPosition> querySkxdUserPositionPage(Map params) throws Exception{
        int page = 0;
        if(EmptyUtils.isNotEmpty(params.get("page"))) {
           page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdUserPosition.getSkxdUserPositionCount";
        String listSqlId = "SkxdUserPosition.getSkxdUserPositionPage";
        Page<SkxdUserPosition> result = skxdUserPositionService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    public List<SkxdUserPosition> querySkxdUserPositionList(Date startDate,Date endDate,String userId)throws Exception{
        String listSqlId = "SkxdUserPosition.getSkxdUserPositionPage";
        Map params=new HashMap();
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("userId",userId);
        return genericDAO.list(listSqlId,params);
    }
}
