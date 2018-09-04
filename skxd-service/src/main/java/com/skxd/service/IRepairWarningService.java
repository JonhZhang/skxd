package com.skxd.service;

import com.skxd.model.RepairWarning;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/8.
 */
public interface IRepairWarningService {

    public Page<RepairWarning> queryPage(Map params)throws Exception;

    public RepairWarning findById(String id)throws Exception;

    /**
     *  2 次维修间隔小于 30天发生同  1 台仪器重复维修时的列表
     * @param deviceId
     * @return
     * @throws Exception
     */
    public List<RepairWarning> findListByDeviceId(String deviceId)throws Exception;

    public int save(RepairWarning repairWarning)throws Exception;

}
