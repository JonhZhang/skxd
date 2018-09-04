package com.skxd.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.skxd.dao.SkxdAnswerMapper;
import com.skxd.dao.SkxdAnswerValueMapper;
import com.skxd.dao.SkxdCustomMapper;
import com.skxd.dao.SkxdDeviceMapper;
import com.skxd.model.*;
import com.skxd.service.ISkxdAnswerService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.*;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/10.
 */
@Service
public class SkxdAnswerService implements ISkxdAnswerService{

    @Autowired
    private SkxdAnswerMapper skxdAnswerMapper;

    @Autowired
    private GenericDAOImpl genericDAO;

    @Autowired
    private SelectService<SkxdAnswerVo> selectService;

    @Autowired
    private SelectService<SkxdAnswerPageVo> selectAnswerPageService;

    @Autowired
    private SkxdDeviceMapper skxdDeviceMapper;

    @Autowired
    private SkxdCustomMapper skxdCustomMapper;

    @Override
    public String addAnswer(SkxdAnswer answer) throws Exception{
        answer.setId(StringUtils.randomUUID());
        answer.setCreatedDate(new Date());
          genericDAO.insert("ANSWERVALUE.addSkxdAnswer", answer);
        return  answer.getId();
    }

    public String addSkxdAnswerValue(ProjectParamsVo projectParamsVo,String answers) throws Exception{
        //添加答案项目
        SkxdAnswer skxdAnswer = new SkxdAnswer();
        skxdAnswer.setProjectId(projectParamsVo.getProjectId());
        skxdAnswer.setDeviceId(projectParamsVo.getDeviceId());
        skxdAnswer.setUserId(projectParamsVo.getUserId());
        skxdAnswer.setTitle(projectParamsVo.getTitle());
        skxdAnswer.setAnswerJsonData(answers);
        skxdAnswer.setStatus(0);
        String rId = addAnswer(skxdAnswer);
        List<SkxdAnswerValue> skxdAnswerValueList = formatAnswerFromJson(answers,skxdAnswer.getId());
        if(EmptyUtils.isNotEmpty(skxdAnswerValueList)){
             genericDAO.insert("ANSWERVALUE.addSkxdAnswerValueBatch", skxdAnswerValueList);
        }
        return rId;
    }

    @Override
    public SkxdAnswer querySkxdAnswerById(String id) {
        return skxdAnswerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AnswerValueVo> queryAnswerValueVoByMap(Map params) {
       return genericDAO.list("ANSWERVALUE.selectSkxdAnswerValues", params);
    }

    private List<SkxdAnswerValue> formatAnswerFromJson(String json, String answerId) {
        List<SkxdAnswerValue> skxdAnswerValueList = new ArrayList<SkxdAnswerValue>();
        JSONArray jsonArray = JSONArray.parseArray(json);
        for (int i = 0; i < jsonArray.size(); i++) {
            SkxdAnswerValue skxdAnswerValue = new SkxdAnswerValue();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String inputId = jsonObject.getString("name");
            String value = jsonObject.getString("value");
            skxdAnswerValue.setId(StringUtils.randomUUID());
            skxdAnswerValue.setInputId(inputId);
            skxdAnswerValue.setValue(value);
            skxdAnswerValue.setAnswerId(answerId);
            skxdAnswerValueList.add(skxdAnswerValue);
        }
        return skxdAnswerValueList;
    }

    @Override
    public List<SkxdAnswer> queryAnswerByDeviceId(String deviceId) {
    	SkxdAnswerExample example = new SkxdAnswerExample();
    	example.createCriteria().andDeviceIdEqualTo(deviceId);
    	return skxdAnswerMapper.selectByExample(example);
    }

    @Override
    public Page<SkxdAnswerVo> queryAnswerPage(Map params) throws Exception{
        int page=0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAnswer.getSkxdAnswerCount";
        String listSqlId = "SkxdAnswer.getSkxdAnswerPage";
        return selectService.getPage(countSqlId, listSqlId, params);
    }


    public int  updateSkxdAnswer(SkxdAnswer skxdAnswer){
        return skxdAnswerMapper.updateByPrimaryKey(skxdAnswer);
    }

    @Override
    public Page<SkxdAnswerPageVo> queryAnswerPageByParams(Map params) throws Exception {
        int page=0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAnswerPage.getSkxdAnswerCount";
        String listSqlId = "SkxdAnswerPage.getSkxdAnswerPage";
        return selectAnswerPageService.getPage(countSqlId, listSqlId, params);
    }

    @Override
    public List<Map<String, String>> queryInputValueByProjectId(String projectId,String startDate,String endDate) throws Exception {
        Map params=new HashMap();
        params.put("projectId",projectId);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        List<Map<String, String>> mapList=new ArrayList<>();
        List<SkxdAnswerValueVo> skxdAnswerValueVos=genericDAO.list("SkxdAnswerPage.getSkxdAnswerValueList",params);
        Map<String,Map<String,String>> result=new HashMap<>();
        for(int i=0;i<skxdAnswerValueVos.size();i++){
            SkxdAnswerValueVo skxdAnswerValueVo=skxdAnswerValueVos.get(i);
            Map map=result.get(skxdAnswerValueVos.get(i).getAnswerId());
            if(EmptyUtils.isEmpty(map)){
                map=new HashMap<String,String>();
                map.put("orderno",skxdAnswerValueVo.getOrderno());
                map.put("customName",skxdAnswerValueVo.getCustomName());
                map.put("deviceState",skxdAnswerValueVo.getDeviceState());
                map.put("deviceType",skxdAnswerValueVo.getDeviceType());
                map.put("deviceNo",skxdAnswerValueVo.getDeviceNo());
                map.put("customLevel",skxdAnswerValueVo.getCustomLevel());
                map.put("address",skxdAnswerValueVo.getAddress());
                map.put("customType",skxdAnswerValueVo.getCustomType());
                map.put("installer",skxdAnswerValueVo.getInstaller());
                map.put("title",skxdAnswerValueVo.getTitle());
                map.put("userName",skxdAnswerValueVo.getUserName());
                map.put("seller",skxdAnswerValueVo.getSeller());
                map.put("server",skxdAnswerValueVo.getServer());
                map.put("leaderName",skxdAnswerValueVo.getLeaderName());

                result.put(skxdAnswerValueVo.getAnswerId(),map);
            }
           // if(skxdAnswerValueVos.get(i).getInputId().equals("28F7DF5A22D7434DACE50CB39446C2E9") && "935EAC74A08145A8A02777A892161CF7".equals(skxdAnswerValueVos.get(i).getAnswerId())){
                if(map.get(skxdAnswerValueVos.get(i).getInputId()) == null){
                    map.put(skxdAnswerValueVos.get(i).getInputId(),skxdAnswerValueVos.get(i).getValue());
                }else {
                    String s = (String) map.get(skxdAnswerValueVos.get(i).getInputId());
                    s = s+","+skxdAnswerValueVos.get(i).getValue();
                    map.put(skxdAnswerValueVos.get(i).getInputId(),s);
                }
//                System.out.println(i+"++++++++++++++++++++++++++++++++");
//                System.out.println(JSON.toJSONString(skxdAnswerValueVos.get(i)));
//                System.out.println("inputid:"+skxdAnswerValueVos.get(i).getInputId()+",val:"+skxdAnswerValueVos.get(i).getValue());
//                System.out.println("++++++++++++++++++++++++++++++++");
            }
      //  }
        //变量map
        for (String key : result.keySet()) {
            Map<String,String> map=result.get(key);
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public List<SkxdAnswer> querySkxdAnswer(SkxdAnswerExample skxdAnswerExample) {
        return skxdAnswerMapper.selectByExample(skxdAnswerExample);
    }

    @Override
    public int removeAnswerByIds(String ids) throws Exception {
        SkxdAnswerExample skxdAnswerExample=new SkxdAnswerExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAnswerExample.createCriteria().andIdIn(idsList);
        int flag=skxdAnswerMapper.deleteByExample(skxdAnswerExample);
        return flag;
    }
}
