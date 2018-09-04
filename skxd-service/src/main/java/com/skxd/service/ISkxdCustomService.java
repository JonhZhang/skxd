package com.skxd.service;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdCustomExample;
import com.skxd.model.SkxdQuarter;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface ISkxdCustomService {
    /**
     * @param params
     * @return
     */
    public Page<SkxdCustom> queryCustomPage(Map params)throws Exception;
    /**
     * @param skxdCustom
     */
    public int saveOrUpdateCustom(SkxdCustom skxdCustom)throws Exception;
    /**
     * @param id
     * @return
     */
    public SkxdCustom queryCustomById(String id)throws Exception;
    /**
     * @param ids
     * @return
     */
    public int removeCustomByIds(String ids)throws Exception;
    /**
     * @param areaNo
     * @return
     * @throws Exception
     */
    public List<SkxdCustom> queryCustomByAreaNo(String areaNo)throws Exception;
    /**
     * 根据用户id查询用户信息
     * @param areaNos
     * @param page
     * @param rows
     * @return
     */
    Page<SkxdCustom> queryCustomInfoByUserId(String[] areaNos,String customIds[],String page,String rows,String customName);
    /**
     * 根据用户名查询用户信息
     * @param name
     * @param i
     * @return
     */
    public String getCustomIdByCustomName(String name,int i);
    /**
     * 根据客户id查询统计
     * @param customId
     * @return
     */
    public List<SkxdQuarter> queryStatics(String customId,Integer year)throws Exception;
    /**
     *
     * @param skxdCustomExample
     * @return
     * @throws Exception
     */
    public List<SkxdCustom> querySkxdCustomList(SkxdCustomExample skxdCustomExample)throws Exception;
    /**
     *
     * @param skxdQuarterList
     * @return
     * @throws Exception
     */
    public int batchAddSkxdQuarter(List<SkxdQuarter> skxdQuarterList)throws Exception;
}
