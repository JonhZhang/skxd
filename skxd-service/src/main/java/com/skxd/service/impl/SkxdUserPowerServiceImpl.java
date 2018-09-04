package com.skxd.service.impl;

import com.skxd.dao.SkxdAreaMapper;
import com.skxd.dao.SkxdCustomMapper;
import com.skxd.dao.SkxdDeviceMapper;
import com.skxd.dao.SkxdUserPowerMapper;
import com.skxd.model.*;
import com.skxd.service.ISkxdUserPowerService;
import com.skxd.service.common.SelectService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SkxdUserPowerServiceImpl implements ISkxdUserPowerService {

    @Autowired
    private SkxdUserPowerMapper skxdUserPowerMapper;

    @Autowired
    private SkxdCustomMapper skxdCustomMapper;

    @Autowired
    private SkxdDeviceMapper skxdDeviceMapper;

    @Autowired
    private SkxdAreaMapper skxdAreaMapper;

    @Autowired
    private SelectService<SkxdUserPower> selectService;

    @Autowired
    private SelectService<SkxdArea> selectAreaService;

    public int saveOrUpdateSkxdUserPower(SkxdUserPower skxdUserPower) throws Exception {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdUserPower.getId())) {
            skxdUserPower.setUpdatedTime(new Date());
            flag = skxdUserPowerMapper.updateByPrimaryKeySelective(skxdUserPower);
        } else {
            skxdUserPower.setId(StringUtils.randomUUID());
            skxdUserPower.setCreatedTime(new Date());
            flag = skxdUserPowerMapper.insert(skxdUserPower);
        }
        return flag;
    }

    public SkxdUserPower querySkxdUserPowerById(String id) throws Exception {
        return skxdUserPowerMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdUserPowerByIds(String ids) throws Exception {
        SkxdUserPowerExample skxdUserPowerExample = new SkxdUserPowerExample();
        List<String> idsList = new ArrayList<String>();
        String idsArray[] = ids.split(",");
        for (int i = 0; i < idsArray.length; i++) {
            idsList.add(idsArray[i]);
        }
        skxdUserPowerExample.createCriteria().andIdIn(idsList);
        int flag = skxdUserPowerMapper.deleteByExample(skxdUserPowerExample);
        return flag;
    }

    public List<SkxdUserPower> querySkxdUserPowerList(SkxdUserPowerExample example) throws Exception {
        return skxdUserPowerMapper.selectByExample(example);
    }

    public Page<SkxdArea> querySkxdUserPowerPage(Map params) throws Exception {
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdArea.getSkxdAreaCount";
        String listSqlId = "SkxdArea.getSkxdAreaPage";
        Page<SkxdArea> result = selectAreaService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public SkxdUserPower getSkxdUserPowerByUserId(String userId) throws Exception {
        SkxdUserPowerExample skxdUserPowerExample = new SkxdUserPowerExample();
        skxdUserPowerExample.createCriteria().andUserIdEqualTo(userId);
        List<SkxdUserPower> skxdUserPowerList = querySkxdUserPowerList(skxdUserPowerExample);
        if (EmptyUtils.isNotEmpty(skxdUserPowerList)) {
            return skxdUserPowerList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int selectArea(int level, String value, String userId) throws Exception {
        SkxdUserPower skxdUserPower = getSkxdUserPowerByUserId(userId);
        if (EmptyUtils.isEmpty(skxdUserPower)) {
            skxdUserPower = new SkxdUserPower();
            skxdUserPower.setUserId(userId);
        }
        if (level == 1) {
            skxdUserPower.setProvinceNo((EmptyUtils.isEmpty(skxdUserPower.getProvinceNo()) ? "" : skxdUserPower.getProvinceNo()) + "," + value);
        } else if (level == 2) {
            skxdUserPower.setCityNo((EmptyUtils.isEmpty(skxdUserPower.getCityNo()) ? "" : skxdUserPower.getCityNo()) + "," + value);
        } else if (level == 3) {
            skxdUserPower.setCustomId((EmptyUtils.isEmpty(skxdUserPower.getCustomId()) ? "" : skxdUserPower.getCustomId()) + "," + value);
        } else if (level == 4) {
            skxdUserPower.setDeviceId((EmptyUtils.isEmpty(skxdUserPower.getDeviceId()) ? "" : skxdUserPower.getDeviceId()) + "," + value);
        }
        return saveOrUpdateSkxdUserPower(skxdUserPower);
    }

    @Override
    public int deleteArea(int level, String value, String userId) throws Exception {
        SkxdUserPower skxdUserPower = getSkxdUserPowerByUserId(userId);
        if (EmptyUtils.isEmpty(skxdUserPower)) {
            skxdUserPower = new SkxdUserPower();
            skxdUserPower.setUserId(userId);
        }
        if (level == 1) {
            skxdUserPower.setProvinceNo(skxdUserPower.getProvinceNo().replaceAll("," + value, ""));
            if (EmptyUtils.isNotEmpty(skxdUserPower.getCityNo())) {
                deleteCityByParent(skxdUserPower, value);
            }
        } else if (level == 2) {
            skxdUserPower.setCityNo(skxdUserPower.getCityNo().replaceAll("," + value, ""));
            if (EmptyUtils.isNotEmpty(skxdUserPower.getCustomId())) {
                deleteCustomyCity(skxdUserPower, value);
            }
        } else if (level == 3) {
            skxdUserPower.setCustomId(skxdUserPower.getCustomId().replaceAll("," + value, ""));
            if (EmptyUtils.isNotEmpty(skxdUserPower.getDeviceId())) {
                deleteDeviceyCustom(skxdUserPower, value);
            }
        } else if (level == 4) {
            skxdUserPower.setDeviceId(skxdUserPower.getDeviceId().replaceAll("," + value, ""));
        }
        return saveOrUpdateSkxdUserPower(skxdUserPower);
    }

    /**
     * 根据省份删除市区
     *
     * @param skxdUserPower
     * @param parent
     */
    public void deleteCityByParent(SkxdUserPower skxdUserPower, String parent) {
        SkxdAreaExample skxdAreaExample = new SkxdAreaExample();
        skxdAreaExample.createCriteria().andParentEqualTo(parent);
        List<SkxdArea> skxdAreaList = skxdAreaMapper.selectByExample(skxdAreaExample);
        for (SkxdArea skxdArea : skxdAreaList) {
            skxdUserPower.setCityNo(skxdUserPower.getCityNo().replaceAll("," + skxdArea.getAreaNo(), ""));
            if (EmptyUtils.isNotEmpty(skxdUserPower.getCustomId())) {
                deleteCustomyCity(skxdUserPower, skxdArea.getAreaNo());
            }
        }
    }

    /**
     * 根据市区删除客户
     *
     * @param skxdUserPower
     * @param city
     */
    public void deleteCustomyCity(SkxdUserPower skxdUserPower, String city) {
        SkxdCustomExample skxdCustomExample = new SkxdCustomExample();
        skxdCustomExample.createCriteria().andAreaNoEqualTo(city);
        List<SkxdCustom> skxdCustomList = skxdCustomMapper.selectByExample(skxdCustomExample);
        for (SkxdCustom skxdCustom : skxdCustomList) {
            skxdUserPower.setCustomId(skxdUserPower.getCustomId().replaceAll("," + skxdCustom.getId(), ""));
            if (EmptyUtils.isNotEmpty(skxdUserPower.getDeviceId())) {
                deleteDeviceyCustom(skxdUserPower, skxdCustom.getId());
            }
        }
    }

    /**
     * 根据客户删除设备
     *
     * @param skxdUserPower
     * @param custom
     */
    public void deleteDeviceyCustom(SkxdUserPower skxdUserPower, String custom) {
        SkxdDeviceExample skxdDeviceExample = new SkxdDeviceExample();
        skxdDeviceExample.createCriteria().andCustomIdEqualTo(custom);
        List<SkxdDevice> skxdDeviceList = skxdDeviceMapper.selectByExample(skxdDeviceExample);
        for (SkxdDevice skxdDevice : skxdDeviceList) {
            skxdUserPower.setDeviceId(skxdUserPower.getDeviceId().replaceAll("," + skxdDevice.getId(), ""));
        }
    }

    public SkxdUserPower findByUserId(String userId) {
        SkxdUserPowerExample example = new SkxdUserPowerExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<SkxdUserPower> skxdUserPowers = skxdUserPowerMapper.selectByExample(example);
        if (!skxdUserPowers.isEmpty()) {
            return skxdUserPowers.get(0);
        }
        return null;
    }

    public void templateConfig(String userId) throws Exception {
        String templateUserId = "f911ab4e27b0e95b5c88e507bb9a7693"; //王旭
        SkxdUserPower userPower = this.findByUserId(userId);
        SkxdUserPower templateUserPower = this.findByUserId(templateUserId);

        userPower.setCustomId(templateUserPower.getCustomId());
        userPower.setDeviceId(templateUserPower.getDeviceId());
        userPower.setCityNo(templateUserPower.getCityNo());
        userPower.setProvinceNo(templateUserPower.getProvinceNo());
        this.saveOrUpdateSkxdUserPower(userPower);
    }
}
