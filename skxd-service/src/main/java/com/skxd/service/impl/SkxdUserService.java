package com.skxd.service.impl;
import java.util.*;

import com.skxd.dao.*;
import com.skxd.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skxd.service.ISkxdUserService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.SkxdUserVo;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import com.zxs.utils.security.SecurityUtils;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/8/19.
 */
@Service
public class SkxdUserService implements ISkxdUserService {

    @Autowired
    private SkxdUserMapper skxdUserMapper;
    
    @Autowired
    private SkxdAreaMapper skxdAreaMapper;

    @Autowired
    private SelectService<SkxdUserVo> selectServiceVo;

    @Autowired
    private SkxdUserAreaMapper skxdUserAreaMapper;

    @Autowired
    private SkxdUserPowerMapper skxdUserPowerMapper;

    @Autowired
    private SkxdAnswerMapper skxdAnswerMapper;
    
    @Override
    public SkxdUser querySkxdUserByUserEmail(String userEmail) throws Exception {
        SkxdUserExample skxdUserExample=new SkxdUserExample();
        skxdUserExample.createCriteria().andUserEmailEqualTo(userEmail);
        skxdUserMapper.countByExample(skxdUserExample);
        List<SkxdUser> skxdUserList=skxdUserMapper.selectByExample(skxdUserExample);
        if(EmptyUtils.isNotEmpty(skxdUserList)){
             return  skxdUserList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public SkxdUser registerSkxdUser(String email,String password,String account) throws Exception {
        SkxdUserExample skxdUserExample=new SkxdUserExample();
        skxdUserExample.createCriteria().andUserEmailEqualTo(email);
        int count=skxdUserMapper.countByExample(skxdUserExample);
        if(count>0){
           return null;
        }
        SkxdUser skxdUser=new SkxdUser();
        skxdUser.setUserEmail(email);
        skxdUser.setPassword(SecurityUtils.md5Hex(password));
        skxdUser.setId(StringUtils.randomUUID());
        skxdUser.setCreatedTime(new Date());
        skxdUser.setUserName(account);
        skxdUser.setStatus(0);
        skxdUserMapper.insert(skxdUser);
        return skxdUserMapper.selectByPrimaryKey(skxdUser.getId());
    }

    @Override
    public SkxdUser validateSkxdUser(String phone,String password) {
        SkxdUserExample skxdUserExample=new SkxdUserExample();
        skxdUserExample.createCriteria().andUserEmailEqualTo(phone).andPasswordEqualTo(SecurityUtils.md5Hex(password));
        List<SkxdUser> skxdUserList=skxdUserMapper.selectByExample(skxdUserExample);
        if(EmptyUtils.isNotEmpty(skxdUserList)){
            return  skxdUserList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public int modifySkxdUser(SkxdUser skxdUser){
        if(EmptyUtils.isEmpty(skxdUser)){
            return 0;
        }else{
            skxdUser.setUpdatedTime(new Date());
            return skxdUserMapper.updateByPrimaryKeySelective(skxdUser);
        }
    }
    
    private String findAreaIdByAreaNo(String areaNo) {
    	SkxdAreaExample example = new SkxdAreaExample();
    	example.createCriteria().andAreaNoEqualTo(areaNo);
    	return skxdAreaMapper.selectByExample(example).get(0).getId();
    }
    
    @Override
    public Page<SkxdUserVo> querySkxdUserPage(Map params){
        int page =0;
        if(EmptyUtils.isNotEmpty(params.get("page"))){
            page =Integer.parseInt(params.get("page").toString());
        }
        params.put("page",page);
        String countSqlId = "USER.getSkxdUserCount";
        String listSqlId = "USER.getSkxdUserPage";
        return selectServiceVo.getPageByLimit(countSqlId, listSqlId, params);
    }

    @Override
    public SkxdUser querySkxdUserById(String id) {
        return skxdUserMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<SkxdUser> querySkxdUserByIds(List<String> ids) {
    	 SkxdUserExample skxdUserExample=new SkxdUserExample();
    	 skxdUserExample.createCriteria().andIdIn(ids);
    	 return skxdUserMapper.selectByExample(skxdUserExample);
    }
    
    @Override
    public SkxdUser querySkxdUserByUserAccountAndPwd(String userAccount,String password) throws Exception {
        SkxdUserExample skxdUserExample=new SkxdUserExample();
        skxdUserExample.createCriteria().andUserEmailEqualTo(userAccount).andPasswordEqualTo(SecurityUtils.md5Hex(password));
        List<SkxdUser> skxdUserList=skxdUserMapper.selectByExample(skxdUserExample);
        if(EmptyUtils.isNotEmpty(skxdUserList)){
             return  skxdUserList.get(0);
        }else{
            return null;
        }
    }
    
    @Override
    public List<SkxdUserVo> selectSkxdUser(String userId){
    	Map params = new HashMap();
        params.put("userId", userId);
        params.put("beginPos",0);
        params.put("rows",10);
       return (List<SkxdUserVo>) selectServiceVo.list("USER.getSkxdUserPage",params);
    }

	public List<SkxdUser> findEngineer(String userId) {
        SkxdUser skxdUser=skxdUserMapper.selectByPrimaryKey(userId);
        Map params = new HashMap();
        params.put("id",userId);
        return (List<SkxdUser>) selectServiceVo.list("USER.findEngineer",params);
	}

    public List<SkxdUser> findLeaders(String userId) {
        SkxdUser skxdUser=skxdUserMapper.selectByPrimaryKey(userId);
        Map params = new HashMap();
        params.put("userIds",skxdUser.getLeader());
        return (List<SkxdUser>) selectServiceVo.list("USER.findLeaders",params);
    }
    public SkxdUser findLeader(String userId) {
        Map params = new HashMap();
        SkxdUser skxdUser=skxdUserMapper.selectByPrimaryKey(userId);
        SkxdUser leader=skxdUserMapper.selectByPrimaryKey(skxdUser.getLeader());
        return leader;
    }

    @Override
    public List<SkxdUser> querySkxdUserList(SkxdUserExample skxdUserExample) {
        return skxdUserMapper.selectByExample(skxdUserExample);
    }

    public int removeSkxdUsersByIds(String ids)throws Exception{
        SkxdUserExample skxdUserExample=new SkxdUserExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdUserExample.createCriteria().andIdIn(idsList);
        int flag=skxdUserMapper.deleteByExample(skxdUserExample);
        //删除用户权限
        SkxdUserPowerExample skxdUserPowerExample=new SkxdUserPowerExample();
        skxdUserPowerExample.createCriteria().andUserIdIn(idsList);
        skxdUserPowerMapper.deleteByExample(skxdUserPowerExample);
        //删除工单
        SkxdAnswerExample skxdAnswerExample=new SkxdAnswerExample();
        skxdAnswerExample.createCriteria().andUserIdIn(idsList);
        skxdAnswerMapper.deleteByExample(skxdAnswerExample);
        return flag;
    }
}
