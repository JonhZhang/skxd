package com.skxd.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skxd.dao.SkxdAreaMapper;
import com.skxd.dao.SkxdUserAreaMapper;
import com.skxd.model.SkxdArea;
import com.skxd.model.SkxdAreaExample;
import com.skxd.service.ISkxdAreaService;
import com.skxd.service.common.SelectService;

/**
 * 
 * @author taohuabi
 *
 */
@Service
public class SkxdAreaService implements ISkxdAreaService {

	@Autowired
	private SkxdAreaMapper skxdAreaMapper;

	@Autowired
	private SelectService<SkxdAreaMapper> selectService;
	
	@Autowired
    private SkxdUserAreaMapper skxdUserAreaMapper;
	
	static  Map<String,String> areaMap=null;
	@Override
	public List<SkxdArea> findCityByParent(String parent) {
		SkxdAreaExample example = new SkxdAreaExample();
		example.createCriteria().andParentEqualTo(parent);
		return skxdAreaMapper.selectByExample(example);
	}
	@Override
	public SkxdArea querySkxdAreaByAreaNo(String areaNo){
		SkxdAreaExample example = new SkxdAreaExample();
		example.createCriteria().andAreaNoEqualTo(areaNo);
		return skxdAreaMapper.selectByExample(example).get(0);
	}

	@Override
	public List<SkxdArea> findSelectedAreas(String userId) {
		return null;
	}

	public List<SkxdArea> querySkxdAreaListByExample(SkxdAreaExample skxdAreaExample){
		return skxdAreaMapper.selectByExample(skxdAreaExample);
	}

	public String getAreaNoByName(String name){
		SkxdAreaExample skxdAreaExample=new SkxdAreaExample();
		skxdAreaExample.createCriteria().andLevelEqualTo(2);
		if(EmptyUtils.isEmpty(areaMap)){
			areaMap=new HashMap<String,String>();
			List<SkxdArea> skxdAreaList=skxdAreaMapper.selectByExample(skxdAreaExample);
			for(SkxdArea skxdArea:skxdAreaList){
				areaMap.put(skxdArea.getName(),skxdArea.getAreaNo());
			}
		}
		return areaMap.get(name);
	}

	@Override
	public Page<SkxdArea> querySkxdAreaPage(Map params) throws Exception {
		int page = 0;
		if (EmptyUtils.isNotEmpty(params.get("page"))) {
			page = Integer.parseInt(params.get("page").toString());
		}
		params.put("page", page);
		String countSqlId = "SkxdUserPower.getSkxdUserPowerCount";
		String listSqlId = "SkxdUserPower.getSkxdUserPowerPage";
		Page result = selectService.getPage(countSqlId, listSqlId, params);
		return result;
	}

}