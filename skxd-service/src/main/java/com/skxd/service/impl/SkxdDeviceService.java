package com.skxd.service.impl;
import com.skxd.dao.SkxdDeviceMapper;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdDevice;
import com.skxd.model.SkxdDeviceExample;
import com.skxd.service.ISkxdDeviceService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.SkxdDeviceVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by shang-pc on 2015/11/8.
 */
@Service
public class SkxdDeviceService implements ISkxdDeviceService{

    @Autowired
    private SkxdDeviceMapper skxdDeviceMapper;

    @Autowired
    private SelectService<SkxdDeviceVo> selectService;

    @Autowired
    private GenericDAOImpl genericDAO;

    /**
     * @param params
     * @return
     */
    @Override
    public Page<SkxdDeviceVo> queryDevicePage(Map params) throws Exception{
        int page =0;
        if(EmptyUtils.isNotEmpty(params.get("page"))){
            page =Integer.parseInt(params.get("page").toString());
        }
        params.put("page",page);
        String countSqlId = "DEVICE.getSkxdDeviceCount";
        String listSqlId = "DEVICE.getSkxdDevicePage";
        return selectService.getPage(countSqlId,listSqlId,params);
    }
    /**
     * @param ids
     * @return
     */
    @Override
    public int removeDeviceByIds(String ids) throws Exception{
        SkxdDeviceExample skxdDeviceExample=new SkxdDeviceExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdDeviceExample.createCriteria().andIdIn(idsList);
        int flag=skxdDeviceMapper.deleteByExample(skxdDeviceExample);
        return flag;
    }
    /**
     * @param id
     * @return
     */
    @Override
    public SkxdDevice queryDeviceById(String id)throws Exception {
        return skxdDeviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdateDevice(SkxdDevice skxdDevice)throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdDevice.getId())){
            skxdDevice.setUpdatedDate(new Date());
            flag=skxdDeviceMapper.updateByPrimaryKeySelective(skxdDevice);
        }else{
            skxdDevice.setId(StringUtils.randomUUID());
            skxdDevice.setCreatedDate(new Date());
            flag=skxdDeviceMapper.insert(skxdDevice);
        }
        return flag;
    }

    public List<SkxdDeviceVo> queryDeviceList(){
        return genericDAO.list("DEVICE.getSkxdDevicePage",new HashMap<>());
    }

    public int batchSaveDeviceList(List<SkxdDevice> skxdDeviceList) {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdDeviceList)) {
            flag = genericDAO.insert("DEVICE.batchAddSkxdDevice", skxdDeviceList);
        }
        return flag;
    }

    @Override
    public List<SkxdDevice> querySkxdDeviceList(SkxdDeviceExample skxdDeviceExample) {
        return skxdDeviceMapper.selectByExample(skxdDeviceExample);
    }

}
