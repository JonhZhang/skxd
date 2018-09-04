//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.skxd.service.impl;
import com.skxd.controller.ClientController;
import com.skxd.controller.util.ReturnResultExt;
import com.skxd.model.*;
import com.skxd.service.*;
import com.skxd.util.Common;
import com.skxd.util.DateUtil;
import com.skxd.util.PushUtil;
import com.skxd.vo.PageVo;
import com.skxd.vo.SkxdAreaVo;
import com.zxs.common.Page;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.DateUtils;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.security.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ClientService {
    private static Map<String, Object> validateContainer = new ConcurrentHashMap();
    @Autowired
    private ISkxdUserService userService;
    @Autowired
    private ISkxdCustomService customService;
    @Autowired
    private ISkxdDeviceService deviceService;
    @Autowired
    private ISkxdAnswerService answerService;
    @Autowired
    private ISkxdAreaService areaService;
    @Autowired
    private ISkxdDepartmentService departmentService;
    @Autowired
    private ISkxdAdminProjectService projectService;
    @Autowired
    private ISkxdUserPositionService skxdUserPositionService;
    @Autowired
    private ISkxdUserAreaService skxdUserAreaService;
    @Autowired
    private ISkxdAreaService skxdAreaService;
    @Autowired
    private ISkxdMessageService messageService;
    @Autowired
    private ISkxdUserPowerService skxdUserPowerService;

    public ClientService() {
    }

    public ReturnResult userRegister(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        String userAccount = request.getParameter("userAccount");
        String validateCode = request.getParameter("validateCode");
        SkxdUser user = this.userService.querySkxdUserByUserEmail(userEmail);
        if (user != null) {
            return ReturnResultExt.returnFail("邮箱已经存在", (Object) null);
        } else {
            String oldCode = validateContainer.get(userEmail) == null ? "" : validateContainer.get(userEmail).toString();
            if (!validateCode.equals(oldCode)) {
                return ReturnResultExt.returnFail("验证码不正确", (Object) null);
            } else {
                user = this.userService.registerSkxdUser(userEmail, password, userAccount);
                return ReturnResultExt.returnSuccess(user);
            }
        }
    }

    public ReturnResult generateValidateCode(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter("userEmail");
        int num = Common.nextInt(100000, 999999);
        Map map = new HashMap();
        map.put("validateCode", num);
        validateContainer.put(userEmail, num);
        System.out.println("--------------------------------验证码：" + num);
        messageService.sendEmail(userEmail,"感谢注册赛科希德客户端","您的验证码为：" + num);
        return ReturnResultExt.returnSuccess(map);
    }

    public ReturnResult userLogin(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        SkxdUser user = this.userService.querySkxdUserByUserAccountAndPwd(userEmail, password);
        return user == null ? ReturnResultExt.returnFail("用户名或密码不正确", (Object) null) : ReturnResultExt.returnSuccess(user);
    }

    public ReturnResult loginOut(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        return ReturnResultUtil.returnSuccess();
    }

    public ReturnResult selectAreaByUserId(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        HashMap params = new HashMap();
        params.put("userId", userId);
        SkxdUser skxdUser = this.userService.querySkxdUserById(userId);
        List<SkxdAreaVo> result = new ArrayList<>();
        if (skxdUser != null && skxdUser.getStatus().intValue() != 0) {
            SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
            //如果没有分配区域
            if (EmptyUtils.isEmpty(skxdUserPower) || EmptyUtils.isEmpty(skxdUserPower.getProvinceNo())) {
                return ReturnResultUtil.returnFail("暂未分配相关区域");
            }
            //如果分配到省份
            if (EmptyUtils.isNotEmpty(skxdUserPower.getProvinceNo())) {
                String areaArray[] = skxdUserPower.getProvinceNo().split(",");
                List<String> provinceNoList = new ArrayList<>();
                List<String> cityNoList = new ArrayList<>();
                for (int i = 0; i < areaArray.length; i++) {
                    provinceNoList.add(i, areaArray[i]);
                }
                SkxdAreaExample skxdAreaExample = new SkxdAreaExample();
                skxdAreaExample.createCriteria().andAreaNoIn(provinceNoList);
                //省份的区域
                List<SkxdArea> provinceList = skxdAreaService.querySkxdAreaListByExample(skxdAreaExample);
                //市区域
                if (EmptyUtils.isNotEmpty(skxdUserPower.getCityNo())) {
                    String cityArray[] = skxdUserPower.getCityNo().split(",");
                    for (int i = 0; i < cityArray.length; i++) {
                        cityNoList.add(i, cityArray[i]);
                    }
                }
                for (SkxdArea province : provinceList) {
                    SkxdAreaVo skxdAreaVo = new SkxdAreaVo();
                    SkxdAreaExample skxdAreaExample1 = new SkxdAreaExample();
                    List<SkxdArea> children = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(skxdUserPower.getCityNo())) {
                        skxdAreaExample1.createCriteria().andParentEqualTo(province.getAreaNo()).andAreaNoIn(cityNoList);
                    } else {
                        skxdAreaExample1.createCriteria().andParentEqualTo(province.getAreaNo());
                    }
                    children = skxdAreaService.querySkxdAreaListByExample(skxdAreaExample1);
                    skxdAreaVo.setChichildren(children);
                    BeanUtils.copyProperties(province, skxdAreaVo);
                    result.add(skxdAreaVo);
                }
            }
            return ReturnResultExt.returnSuccess(result);
        } else {
            return ReturnResultUtil.returnFail("用户未通过审核");
        }
    }

    public ReturnResult updatePassword(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        String oldpassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newPassword");
        SkxdUser user = this.userService.querySkxdUserById(userId);
        if (user != null && user.getPassword().equals(SecurityUtils.md5Hex(oldpassword))) {
            user.setPassword(SecurityUtils.md5Hex(newPassword));
            this.userService.modifySkxdUser(user);
            return ReturnResultExt.returnSuccess(user);
        } else {
            return ReturnResultUtil.returnFail();
        }
    }





    public ReturnResult queryCustomInfoByUserId(HttpServletRequest request) throws Exception {
        String customName = request.getParameter("customName");
        String userId = request.getParameter("userId");
        String areaNo = request.getParameter("areaNo");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        SkxdUser skxdUser = this.userService.querySkxdUserById(userId);
        String[] customIds = null;
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if(skxdUserPower==null){
            return ReturnResultUtil.returnFail("用户暂未分配区域");
        }
        if (skxdUser != null && skxdUser.getStatus().intValue() != 0) {
            if (EmptyUtils.isNotEmpty(skxdUserPower.getCustomId())) {
                customIds = skxdUserPower.getCustomId().split(",");
            }
            //区域
            if (EmptyUtils.isEmpty(areaNo)) {
                return ReturnResultUtil.returnFail("请选择区域");
            } else {
                SkxdArea area = this.areaService.querySkxdAreaByAreaNo(areaNo);
                SkxdAreaExample skxdAreaExample = new SkxdAreaExample();
                ArrayList areaNoList = new ArrayList();
                if (area.getParent().equals("0")) {
                    List<String> cityNoList = new ArrayList<>();
                    if (EmptyUtils.isNotEmpty(skxdUserPower.getCityNo())) {
                        String cityArray[] = skxdUserPower.getCityNo().split(",");
                        for (int i = 0; i < cityArray.length; i++) {
                            cityNoList.add(i, cityArray[i]);
                        }
                        skxdAreaExample.createCriteria().andParentEqualTo(areaNo).andAreaNoIn(cityNoList);
                    } else {
                        skxdAreaExample.createCriteria().andParentEqualTo(areaNo);
                    }
                    List<SkxdArea> children = areaService.querySkxdAreaListByExample(skxdAreaExample);
                    for (SkxdArea city : children) {
                        areaNoList.add(city.getAreaNo());
                    }
                } else {
                    String[] areas = new String[]{"110101","110102","110105","110106","110107","110108","110109","110111","110112","110113","110114","110115","110116","110117"};//110100
                    List<String> areaList = Arrays.asList(areas);
                    if(area.getAreaNo().equals("110100")) {
                        for(String s :areaList) {
                            areaNoList.add(s);
                        }
                    }else {
                        areaNoList.add(area.getAreaNo());
                    }
                }
                String[] areaNoArray1 = (String[]) areaNoList.toArray(new String[0]);
                Page customPage1 = this.customService.queryCustomInfoByUserId(areaNoArray1, customIds, page, rows,customName);
                return ReturnResultExt.returnSuccess((new PageVo()).toPageVo(customPage1));
            }
        } else {
            return ReturnResultUtil.returnFail("用户未通过审核");
        }
    }

    public ReturnResult addCustom(HttpServletRequest request) throws Exception {
        String name = request.getParameter("customName");
        String areaNo = request.getParameter("areaNo");
        String address = request.getParameter("address");

        String customType = request.getParameter("customType");
        String customLevel = request.getParameter("customLevel");
        String roomTest = request.getParameter("roomTest");
        String userId = request.getParameter("userId");

        String linkman = request.getParameter("linkman");
        String phone = request.getParameter("phone");
        String itemSpread = request.getParameter("itemSpread");

        SkxdCustom custom = new SkxdCustom();
        custom.setCustomName(name);
        custom.setAddress(address);
        custom.setAreaNo(areaNo);
        custom.setCustomType(customType);
        custom.setCustomLevel(customLevel);
        custom.setRoomTest(roomTest);
        custom.setPhone(phone);
        custom.setLinkman(linkman);
        custom.setItemSpread(itemSpread);
        custom.setCreatedDate(new Date());
        custom.setCreatedUser(userService.querySkxdUserById(userId).getUserName());

        this.customService.saveOrUpdateCustom(custom);

        SkxdUserPower skxdUserPower=skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if(EmptyUtils.isNotEmpty(skxdUserPower.getCustomId())){
            skxdUserPower.setCustomId(skxdUserPower.getCustomId()+","+custom.getId());
            skxdUserPowerService.saveOrUpdateSkxdUserPower(skxdUserPower);
        }
        return ReturnResultUtil.returnSuccess();
    }

    public ReturnResult queryDevicePage(HttpServletRequest request) throws Exception {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String customId = request.getParameter("customId");
        String userId = request.getParameter("userId");
        String deviceArray[]=null;
        HashMap params = new HashMap();
        params.put("page", page);
        params.put("rows", rows);
        params.put("customId", customId);
        params.put("userId", userId);
        SkxdUserPower skxdUserPower = skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if(EmptyUtils.isNotEmpty(skxdUserPower.getDeviceId())){
            deviceArray=skxdUserPower.getDeviceId().split(",");
        }
        params.put("deviceArray", deviceArray);
        Page pageResult = this.deviceService.queryDevicePage(params);
        return ReturnResultExt.returnSuccess(pageResult);
    }

    public ReturnResult addDevice(HttpServletRequest request) throws Exception {
        String customId = request.getParameter("customId");
        String departmentId = request.getParameter("departmentId");
        String deviceType = request.getParameter("deviceType");
        String deviceNo = request.getParameter("deviceNo");
        String leaderPhone = request.getParameter("leaderPhone");
        String operatorPhone = request.getParameter("operatorPhone");
        String operatorName = request.getParameter("operatorName");
        String leaderName = request.getParameter("leaderName");
        String fixedPhone = request.getParameter("fixedPhone");

        String seller = request.getParameter("seller");
        String server = request.getParameter("server");
        String installTime = request.getParameter("installTime");
        String installer = request.getParameter("installer");
        String deviceState = request.getParameter("deviceState");
        String projectRemark = request.getParameter("projectRemark");
        String competitor = request.getParameter("competitor");

        String userId=request.getParameter("userId");
        String deviceInstallType = request.getParameter("deviceInstallType");


        SkxdDevice device = new SkxdDevice();
        device.setCreatedDate(new Date());
        device.setCustomId(customId);
        device.setDepartmentId(departmentId);
        device.setDeviceNo(deviceNo);
        device.setDeviceType(deviceType);
        device.setLeaderPhone(leaderPhone);
        device.setLeaderName(leaderName);
        device.setOperatorPhone(operatorPhone);
        device.setOperatorName(operatorName);
        device.setFixedPhone(fixedPhone);
        device.setSeller(seller);
        device.setServer(server);
        device.setInstallTime(DateUtil.strToDate(installTime));
        device.setInstaller(installer);
        device.setDeviceState(deviceState);
        device.setProjectRemark(projectRemark);
        device.setCompetitor(competitor);
        device.setDeviceInstallType(deviceInstallType);
        device.setCreatedUser(userService.querySkxdUserById(userId).getUserName());
        this.deviceService.saveOrUpdateDevice(device);
        SkxdUserPower skxdUserPower=skxdUserPowerService.getSkxdUserPowerByUserId(userId);
        if(EmptyUtils.isNotEmpty(skxdUserPower.getDeviceId())){
            skxdUserPower.setDeviceId(skxdUserPower.getDeviceId()+","+device.getId());
            skxdUserPowerService.saveOrUpdateSkxdUserPower(skxdUserPower);
        }
        return ReturnResultExt.returnSuccess(device);
    }

    public ReturnResult queryDepartmentAll(HttpServletRequest request) throws Exception {
        return ReturnResultExt.returnSuccess(this.departmentService.queryDepartmentAll());
    }

    public ReturnResult queryAnswerByDeviceId(HttpServletRequest request) throws Exception {
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        String deviceId = request.getParameter("deviceId");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        HashMap param = new HashMap();
        param.put("deviceId", deviceId);
        param.put("page", page);
        param.put("rows", rows);
        Page skxdAnswerPage = this.answerService.queryAnswerPage(param);
        returnResult.setData(skxdAnswerPage);
        return returnResult;
    }

    public ReturnResult projectList(HttpServletRequest request) throws Exception {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        HashMap params = new HashMap();
        params.put("page", page);
        params.put("rows", rows);
        Page projectPage = this.projectService.queryProjectPage(params);
        return ReturnResultExt.returnSuccess((new PageVo()).toPageVo(projectPage));
    }

    public ReturnResult findEngineer(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        return ReturnResultExt.returnSuccess(this.userService.findEngineer(userId));
    }

    public ReturnResult publishTask(HttpServletRequest request) throws Exception {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String recipients = request.getParameter("recipients");
        String userId = request.getParameter("userId");
        SkxdUser user = this.userService.querySkxdUserById(userId);
        if (EmptyUtils.isEmpty(recipients)) {
            return ReturnResultUtil.returnFail();
        } else {
            String[] reIdArr = recipients.split(",");

            for (int ids = 0; ids < reIdArr.length; ++ids) {
                SkxdMessage users = new SkxdMessage();
                users.setContent(content);
                users.setTitle(title);
                users.setSenderId(userId);
                users.setSenderName(user.getUserName());
                users.setRecipient(reIdArr[ids]);
                this.messageService.saveOrUpdateSkxdMessage(users);
            }

            List var13 = Arrays.asList(reIdArr);
            List var14 = this.userService.querySkxdUserByIds(var13);
            StringBuilder sb = new StringBuilder();
            Iterator i$ = var14.iterator();
            List<String> emails = new ArrayList<String>();
            while (i$.hasNext()) {
                SkxdUser u = (SkxdUser) i$.next();
                emails.add(u.getUserEmail());
            }
            PushUtil.sendPush(title,content,emails);
            return ReturnResultUtil.returnSuccess();
        }
    }

    public ReturnResult queryTaskList(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        HashMap params = new HashMap();
        params.put("page", page);
        params.put("rows", rows);
        params.put("recipient", userId);
        PageVo pageVo = new PageVo();
        return ReturnResultExt.returnSuccess(pageVo.toPageVo(this.messageService.querySkxdMessagePage(params)));
    }

    public ReturnResult uploadLocation(HttpServletRequest request) throws Exception {
        SkxdUserPosition skxdUserPosition = new SkxdUserPosition();
        skxdUserPosition.setCreatedDate(new Date());
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String userId = request.getParameter("userId");
        skxdUserPosition.setLatitude(Double.valueOf(Double.parseDouble(latitude)));
        skxdUserPosition.setLongitude(Double.valueOf(Double.parseDouble(longitude)));
        skxdUserPosition.setUserId(userId);
        int flag = this.skxdUserPositionService.saveOrUpdateSkxdUserPosition(skxdUserPosition);
        return flag > 0 ? ReturnResultUtil.returnSuccess() : ReturnResultUtil.returnFail();
    }

    public ReturnResult findPassword(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        String validateCode = request.getParameter("validateCode");
        if (EmptyUtils.isEmpty(validateContainer.get(userEmail))) {
            return ReturnResultUtil.returnFail("验证码错误");
        } else {
            String validateCode_temp = validateContainer.get(userEmail).toString();
            if (!EmptyUtils.isEmpty(validateCode_temp) && validateCode_temp.equals(validateCode)) {
                SkxdUser skxdUser = this.userService.querySkxdUserByUserEmail(userEmail);
                if (EmptyUtils.isEmpty(skxdUser)) {
                    return ReturnResultUtil.returnFail("用户不存在");
                } else {
                    skxdUser.setPassword(SecurityUtils.md5Hex(password));
                    this.userService.modifySkxdUser(skxdUser);
                    return ReturnResultUtil.returnSuccess();
                }
            } else {
                return ReturnResultUtil.returnFail("验证码错误");
            }
        }
    }

    public ReturnResult queryAnswerByUserId(HttpServletRequest request) throws Exception {
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        String userId = request.getParameter("userId");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        HashMap param = new HashMap();
        param.put("userId", userId);
        param.put("page", page);
        param.put("rows", rows);
        Page skxdAnswerPage = this.answerService.queryAnswerPage(param);
        returnResult.setData(skxdAnswerPage);
        return returnResult;
    }

    public ReturnResult queryAnswerByLeaderId(HttpServletRequest request) throws Exception {
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        String leaderId = request.getParameter("userId");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        HashMap param = new HashMap();
        Object skxdUserList = this.userService.findEngineer(leaderId);
        if (EmptyUtils.isEmpty(skxdUserList)) {
            skxdUserList = new ArrayList();
        }

        SkxdUser skxdUser = this.userService.querySkxdUserById(leaderId);
        ((List) skxdUserList).add(skxdUser);
        ArrayList userIdList = new ArrayList();
        if (EmptyUtils.isNotEmpty(skxdUserList)) {
            Iterator skxdAnswerPage = ((List) skxdUserList).iterator();

            while (skxdAnswerPage.hasNext()) {
                SkxdUser temp = (SkxdUser) skxdAnswerPage.next();
                userIdList.add(temp.getId());
            }
        }

        param.put("userIds", userIdList);
        param.put("page", page);
        param.put("rows", rows);
        Page skxdAnswerPage1 = this.answerService.queryAnswerPage(param);
        returnResult.setData(skxdAnswerPage1);
        return returnResult;
    }

    public ReturnResult examinateAnswer(HttpServletRequest request) throws Exception {
        String leaderId = request.getParameter("userId");
        String answerId = request.getParameter("answerId");
        String status = request.getParameter("status");
        SkxdAnswer skxdAnswer = this.answerService.querySkxdAnswerById(answerId);
        SkxdUser receiptentUser = this.userService.querySkxdUserById(skxdAnswer.getUserId());
        SkxdUser leaderUser = this.userService.querySkxdUserById(leaderId);
        if (EmptyUtils.isEmpty(skxdAnswer)) {
            return ReturnResultUtil.returnFail("未查询到相关工单");
        } else {
            skxdAnswer.setLeaderId(leaderId);
            skxdAnswer.setStatus(Integer.valueOf(Integer.parseInt(status)));
            int flag = this.answerService.updateSkxdAnswer(skxdAnswer);
            String title = leaderUser.getUserName() + "于" + DateUtils.format(new Date()) + "审核了工单";
            String content = skxdAnswer.getTitle();
            if (EmptyUtils.isEmpty(skxdAnswer.getTitle())) {
                content = "未知标题";
            } else if (skxdAnswer.getTitle().length() > 20) {
                content = content.substring(0, 20);
            }
            PushUtil.sendPush(title,content,Arrays.asList(receiptentUser.getUserEmail()));
            return flag == 0 ? ReturnResultUtil.returnFail() : ReturnResultUtil.returnSuccess();
        }
    }

    /**
     * 查询统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    public ReturnResult queryStatics(HttpServletRequest request) throws Exception {
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        String customId = request.getParameter("customId");
        Calendar  c=new  GregorianCalendar();//新建日期对象
        int  year=c.get(Calendar.YEAR);//获取年份
        List<SkxdQuarter> quarterVoList = this.customService.queryStatics(customId, year);
        returnResult.setData(quarterVoList);
        return returnResult;
    }

    public ReturnResult queryAnswer(HttpServletRequest request) throws Exception {
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        String customId = request.getParameter("customId");
        SkxdDeviceExample skxdDeviceExample=new SkxdDeviceExample();
        skxdDeviceExample.createCriteria().andCustomIdEqualTo(customId);
        List<SkxdDevice> skxdDeviceList=deviceService.querySkxdDeviceList(skxdDeviceExample);
        List<String> answers=new ArrayList<>();
        List<String> deviceIds=new ArrayList<>();
        List<String> deviceNames=new ArrayList<>();
        for(SkxdDevice skxdDevice:skxdDeviceList){
            deviceIds.add(skxdDevice.getId());
        }
        SkxdAnswerExample skxdAnswerExample=new SkxdAnswerExample();
        skxdAnswerExample.createCriteria().andDeviceIdIn(deviceIds);
        List<SkxdAnswer> skxdAnswerList=answerService.querySkxdAnswer(skxdAnswerExample);
        for(SkxdAnswer answer:skxdAnswerList){
            for(SkxdDevice skxdDevice:skxdDeviceList){
                if(answer.getDeviceId().equals(skxdDevice.getId())){
                    answers.add(skxdDevice.getDeviceNo()+" 于 "+DateUtil.dateToStr(answer.getCreatedDate()) + " 进行 " + answer.getTitle());break;
                }
            }
        }
        returnResult.setData(answers);
        return returnResult;
    }


    /**
     * 工单签名
     * @return
     */
    public ReturnResult signUpload(HttpServletRequest request) {

        String answerId = request.getParameter("answerId");
        String sign = request.getParameter("sign");

        try{
            SkxdAnswer skxdAnswer = answerService.querySkxdAnswerById(answerId);
            skxdAnswer.setSign(sign);
            answerService.updateSkxdAnswer(skxdAnswer);
        }catch (Exception e) {
            e.printStackTrace();
            return ReturnResultUtil.returnFail();

        }
        return ReturnResultUtil.returnSuccess();
    }

    public ReturnResult findCustomInfo(HttpServletRequest request) throws Exception {


        String customId = request.getParameter("customId");

        SkxdCustom skxdCustom = customService.queryCustomById(customId);

        return ReturnResultExt.returnSuccess(skxdCustom);

    }

    public void removeSkxdMessageByIds(String ids) throws Exception {
        messageService.removeSkxdMessageByIds(ids);
    }
}
