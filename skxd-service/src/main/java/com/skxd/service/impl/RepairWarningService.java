package com.skxd.service.impl;

import com.skxd.dao.RepairWarningMapper;
import com.skxd.model.RepairWarning;
import com.skxd.service.IRepairWarningService;
import com.skxd.service.common.SelectService;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RepairWarningService implements IRepairWarningService {
    @Autowired
    private RepairWarningMapper repairWarningMapper;
    @Autowired
    private GenericDAOImpl genericDAO;
    @Autowired
    private SelectService<RepairWarning> selectService;
    @Override
    public Page<RepairWarning> queryPage(Map params) throws Exception {
        int page=0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "RepairWarning.findPageCount";
        String listSqlId = "RepairWarning.findPage";
        return selectService.getPage(countSqlId,listSqlId,params);
    }

    @Override
    public RepairWarning findById(String id) throws Exception {
        return repairWarningMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RepairWarning> findListByDeviceId(String deviceId) throws Exception {
        return genericDAO.list("RepairWarning.findListByDeviceId",deviceId);
    }

    @Override
    public int save(RepairWarning repairWarning) throws Exception {

        return repairWarningMapper.insert(repairWarning);
    }
}
