package com.skxd.service;

import com.skxd.model.SkxdDevice;
import com.skxd.model.SkxdDeviceExample;
import com.skxd.vo.SkxdDeviceVo;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/8.
 */
public interface ISkxdDeviceService {

    public Page<SkxdDeviceVo> queryDevicePage(Map params)throws Exception;

    public int removeDeviceByIds(String ids)throws Exception;

    public SkxdDevice queryDeviceById(String id)throws Exception;

    public int saveOrUpdateDevice(SkxdDevice skxdDevice)throws Exception;

    public List<SkxdDeviceVo> queryDeviceList();

    public int batchSaveDeviceList(List<SkxdDevice> skxdDeviceList);

    public List<SkxdDevice> querySkxdDeviceList(SkxdDeviceExample skxdDeviceExample);
}
