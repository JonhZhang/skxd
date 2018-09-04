package com.skxd.service;

import com.skxd.model.SkxdAnswer;
import com.skxd.model.SkxdAnswerExample;
import com.skxd.vo.AnswerValueVo;
import com.skxd.vo.ProjectParamsVo;
import com.skxd.vo.SkxdAnswerPageVo;
import com.skxd.vo.SkxdAnswerVo;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/10.
 */
public interface ISkxdAnswerService {

    public String addAnswer(SkxdAnswer answer)throws Exception;

    public String addSkxdAnswerValue(ProjectParamsVo projectParamsVo,String answers)throws Exception;

    public SkxdAnswer querySkxdAnswerById(String id);

    public List<AnswerValueVo> queryAnswerValueVoByMap(Map params);
    
    public List<SkxdAnswer> queryAnswerByDeviceId(String deviceId);

    public Page<SkxdAnswerVo> queryAnswerPage(Map params) throws Exception;

    public int  updateSkxdAnswer(SkxdAnswer skxdAnswer);

    public Page<SkxdAnswerPageVo> queryAnswerPageByParams(Map params) throws Exception;

    public List<Map<String, String>> queryInputValueByProjectId(String projectId,String startDate,String endDate) throws Exception;

    public List<SkxdAnswer> querySkxdAnswer(SkxdAnswerExample skxdAnswerExample);

    public int removeAnswerByIds(String ids) throws Exception;
}
