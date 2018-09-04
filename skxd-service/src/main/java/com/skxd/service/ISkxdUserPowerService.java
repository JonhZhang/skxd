package com.skxd.service;
import com.skxd.model.SkxdArea;
import com.skxd.model.SkxdUserPower;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdUserPowerExample;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdUserPowerService {

    public int saveOrUpdateSkxdUserPower(SkxdUserPower obj) throws Exception;

    public SkxdUserPower querySkxdUserPowerById(String id) throws Exception;

    public int removeSkxdUserPowerByIds(String ids) throws Exception;

    public List<SkxdUserPower> querySkxdUserPowerList(SkxdUserPowerExample example) throws Exception;

    public Page<SkxdArea> querySkxdUserPowerPage(Map params) throws Exception;

    public SkxdUserPower getSkxdUserPowerByUserId(String userId) throws Exception;

    public int selectArea(int level, String value, String userId) throws Exception;

    public int deleteArea(int level, String value, String userId) throws Exception;

    public void templateConfig(String userId) throws Exception;

}