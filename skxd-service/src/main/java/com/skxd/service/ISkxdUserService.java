package com.skxd.service;
import com.skxd.model.SkxdUser;
import com.skxd.model.SkxdUserExample;
import com.skxd.vo.SkxdUserVo;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>账户管理service</p>
 * <p/>
 * Created by zzshang on 2015/8/19.
 */
public interface ISkxdUserService {
    /**
     * 根据账户查询用户
     * @param userAccount
     * @return
     */
    public SkxdUser querySkxdUserByUserEmail(String userAccount) throws Exception ;
    /**
     * 注册用户
     * @param phone password
     */
    public SkxdUser registerSkxdUser(String email, String password,String account) throws Exception;
    /**
     * 验证用户
     * @param phone
     * @return
     */
    public SkxdUser validateSkxdUser(String phone, String password) throws Exception ;
    /**
     *修改用户的操作
     */
    public int modifySkxdUser(SkxdUser skxdUser)throws Exception ;
    /**
     * 查询注册的用户数据
     * @param params
     * @return
     */
    public Page<SkxdUserVo> querySkxdUserPage(Map params) throws Exception ;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public SkxdUser querySkxdUserById(String id) throws Exception ;
    /**
     *  根据ids查询用户信息
     * @param ids
     * @return
     */
    List<SkxdUser> querySkxdUserByIds(List<String> ids);

	SkxdUser querySkxdUserByUserAccountAndPwd(String userAccount,String password) throws Exception;
	
	List<SkxdUserVo> selectSkxdUser(String userId);
	 
	List<SkxdUser> findEngineer(String userId);

    public List<SkxdUser> findLeaders(String userId);
    public SkxdUser findLeader(String userId);

    List<SkxdUser> querySkxdUserList(SkxdUserExample skxdUserExample);

    int removeSkxdUsersByIds(String ids)throws Exception;
}
