package com.skxd.service.impl;

import com.skxd.dao.SkxdCustomMapper;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdCustomExample;
import com.skxd.model.SkxdQuarter;
import com.skxd.service.ISkxdCustomService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.StaticsVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class SkxdCustomService implements ISkxdCustomService {

    @Autowired
    private SkxdCustomMapper skxdCustomMapper;

    @Autowired
    private SelectService<SkxdCustom> selectService;

    @Autowired
    private GenericDAOImpl genericDAO;

    static Map<String, String> customParams;

    public Page<SkxdCustom> queryCustomPage(Map params) throws Exception {
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "CUSTOM.getSkxdCustomCount";
        String listSqlId = "CUSTOM.getSkxdCustomPage";
        return selectService.getPage(countSqlId, listSqlId, params);
    }

    public int saveOrUpdateCustom(SkxdCustom skxdCustom) throws Exception {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdCustom.getId())) {
            skxdCustom.setUpdatedDate(new Date());
            flag = skxdCustomMapper.updateByPrimaryKeySelective(skxdCustom);
        } else {
            skxdCustom.setId(StringUtils.randomUUID());
            skxdCustom.setCreatedDate(new Date());
            flag = skxdCustomMapper.insert(skxdCustom);
        }
        return flag;
    }

    public SkxdCustom queryCustomById(String id) throws Exception {
        return skxdCustomMapper.selectByPrimaryKey(id);
    }

    public int removeCustomByIds(String ids) throws Exception {
        SkxdCustomExample skxdCustomExample = new SkxdCustomExample();
        List<String> idsList = new ArrayList<String>();
        String idsArray[] = ids.split(",");
        for (int i = 0; i < idsArray.length; i++) {
            idsList.add(idsArray[i]);
        }
        skxdCustomExample.createCriteria().andIdIn(idsList);
        int flag = skxdCustomMapper.deleteByExample(skxdCustomExample);
        return flag;
    }

    public List<SkxdCustom> queryCustomByAreaNo(String areaNo) throws Exception {
        SkxdCustomExample skxdCustomExample = new SkxdCustomExample();
        skxdCustomExample.createCriteria().andAreaNoEqualTo(areaNo);
        return skxdCustomMapper.selectByExample(skxdCustomExample);
    }

    public List<SkxdCustom> querySkxdCustomList(SkxdCustomExample example) throws Exception {
        return skxdCustomMapper.selectByExample(example);
    }

    public Page<SkxdCustom> queryCustomInfoByUserId(String[] areaNos, String customIds[], String page, String rows, String customName) {
        Map map = new HashMap();
        map.put("areaNos", areaNos);
        map.put("page", page);
        map.put("rows", rows);
        map.put("customIds", EmptyUtils.isEmpty(customIds) ? null : customIds);
        map.put("customName", customName);
        return selectService.getPage("CUSTOM.queryCustomInfoByUserIdCount", "CUSTOM.queryCustomInfoByUserId", map);
    }

    public int batchSaveCustomList(List<SkxdCustom> skxdCustomList) {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdCustomList)) {
            flag = genericDAO.insert("CUSTOM.batchAddSkxdCustom", skxdCustomList);
        }
        return flag;
    }

    public String getCustomIdByCustomName(String name, int i) {
        List<SkxdCustom> skxdCustomList = new ArrayList<>();
        if (EmptyUtils.isEmpty(customParams) || i == 1) {
            customParams = new HashMap<>();
            SkxdCustomExample skxdCustomExample = new SkxdCustomExample();
            skxdCustomList = skxdCustomMapper.selectByExample(skxdCustomExample);
            for (SkxdCustom skxdCustom : skxdCustomList) {
                customParams.put(skxdCustom.getCustomName(), skxdCustom.getId());
            }
        }
        return customParams.get(name);
    }

    @Override
    public List<SkxdQuarter> queryStatics(String customId,Integer year) throws Exception {
        Map params = new HashMap();
        params.put("customId", customId);
        params.put("year", year);
        SkxdCustom skxdCustom = skxdCustomMapper.selectByPrimaryKey(customId);
        List<StaticsVo> staticsVoList = genericDAO.list("statics.selectStatics", params);
        List<SkxdQuarter> quarterVoList = new ArrayList<SkxdQuarter>();
        Map<String, SkxdQuarter> map = new LinkedHashMap<String, SkxdQuarter>();
        for (StaticsVo vo : staticsVoList) {
            SkxdQuarter skxdQuarter = map.get(vo.getName()+"-"+vo.getStaticType()+"-"+vo.getYear());
            if (EmptyUtils.isEmpty(skxdQuarter)) {
                skxdQuarter = new SkxdQuarter(vo.getName());
                skxdQuarter.setCustomId(vo.getCustomId());
                skxdQuarter.setCustomName(skxdCustom.getCustomName());
                skxdQuarter.setStaticType(vo.getStaticType());
                skxdQuarter.setYear(vo.getYear());
            } else {
                skxdQuarter = map.get(vo.getName()+"-"+vo.getStaticType()+"-"+vo.getYear());
            }
            if (vo.getMonth() >= 1 && vo.getMonth() <= 3) {
                skxdQuarter.setSpring(skxdQuarter.getSpring() + vo.getTotal());
            } else if (vo.getMonth() >= 4 && vo.getMonth() <= 6) {
                skxdQuarter.setSummer(skxdQuarter.getSummer() + vo.getTotal());
            } else if (vo.getMonth() >= 7 && vo.getMonth() <= 9) {
                skxdQuarter.setAutumn(skxdQuarter.getAutumn() + vo.getTotal());
            } else if (vo.getMonth() >= 10 && vo.getMonth() <= 12) {
                skxdQuarter.setWinter(skxdQuarter.getWinter() + vo.getTotal());
            }
            map.put(vo.getName()+"-"+vo.getStaticType()+"-" + vo.getYear(), skxdQuarter);
        }
        for (Map.Entry<String, SkxdQuarter> entry : map.entrySet()) {
            quarterVoList.add(entry.getValue());
        }
        for (SkxdQuarter quarterVo : quarterVoList) {
            quarterVo.setSpring(caculate(quarterVo.getSpring() * 1.0 / 90.0));
            quarterVo.setWinter(caculate(quarterVo.getWinter() * 1.0 / 90.0));
            quarterVo.setAutumn(caculate(quarterVo.getAutumn() * 1.0 / 90.0));
            quarterVo.setSummer(caculate(quarterVo.getSummer() * 1.0 / 90.0));
        }
        return quarterVoList;
    }

    private double caculate(Double doub) {
        String dstr = String.valueOf(doub);
        BigDecimal bd = new BigDecimal(dstr);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    /**
     * 批量添加统计信息
     *
     * @param skxdQuarterList
     * @return
     * @throws Exception
     */
    public int batchAddSkxdQuarter(List<SkxdQuarter> skxdQuarterList) throws Exception {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(skxdQuarterList)) {
            flag = genericDAO.insert("statics.batchAddSkxdQuarter", skxdQuarterList);
        }
        return flag;
    }
}
