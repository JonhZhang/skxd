package com.skxd.service;
import com.skxd.model.SkxdQuarter;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdQuarterExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdQuarterService {

    public int saveOrUpdateSkxdQuarter(SkxdQuarter obj)throws Exception;

    public SkxdQuarter querySkxdQuarterById(String id)throws Exception;

    public int removeSkxdQuarterByIds(String ids)throws Exception;

    public List<SkxdQuarter> querySkxdQuarterList(SkxdQuarterExample example)throws Exception;

    public Page<SkxdQuarter> querySkxdQuarterPage(Map params)throws Exception;

    public int batchAddSkxdQuarter(List<SkxdQuarter> skxdQuarterList)throws Exception;
}
