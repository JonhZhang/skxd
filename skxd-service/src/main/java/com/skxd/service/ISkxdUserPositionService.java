package com.skxd.service;
import com.skxd.model.SkxdUserPosition;
import com.skxd.model.SkxdUserPositionExample;
import com.zxs.common.Page;

import java.util.*;
import java.util.List;
import java.util.Map;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdUserPositionService{

    public int saveOrUpdateSkxdUserPosition(SkxdUserPosition obj)throws Exception;

    public SkxdUserPosition querySkxdUserPositionById(String id)throws Exception;

    public Page<SkxdUserPosition> querySkxdUserPositionPage(Map params)throws Exception;

    public int removeSkxdUserPositionByIds(String ids)throws Exception;

    public List<SkxdUserPosition> querySkxdUserPositionList(SkxdUserPositionExample example)throws Exception;

    public List<SkxdUserPosition> querySkxdUserPositionList(Date startDate, Date endDate, String userId)throws Exception;
}
