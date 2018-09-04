package com.skxd.controller;

import com.skxd.service.impl.ClientService;
import com.zxs.common.BaseException;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.io.PrintUtil;
import com.zxs.utils.io.PropCache;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * <p>
 * Created by zzshang on 2015/8/18.
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {

    static Logger logger = Logger.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    /**
     * 1:成功 0：失败
     * @return
     */

    @RequestMapping
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getParameter("method");
        String userId = request.getParameter("userId");
        String version = request.getParameter("version");
        String productType = request.getParameter("productType");
        PrintUtil printUtil = new PrintUtil(response, "text/html; charset=utf-8");
        Class clazz = ClientService.class;
        Method method1 = null;
        ReturnResult respResult = null;
        try {
            int flag=0;
//            if(!method.equals("userRegister") && !method.equals("generateValidateCode") &&  !method.equals("userLogin") && !method.equals("loginOut")){
//                flag=setUserLogin(userId);
//                if(flag==1){
//                    method1 = clazz.getDeclaredMethod(method, HttpServletRequest.class);
//                    respResult = (ReturnResult) method1.invoke(clientService, request);
//                }else{a'd
//                    respResult= ReturnResultExt.returnLogin();
//                }
//            }else{
                method1 = clazz.getDeclaredMethod(method, HttpServletRequest.class);
                respResult = (ReturnResult) method1.invoke(clientService, request);
//            }
        } catch (Exception ex) {
            if (EmptyUtils.isNotEmpty(ex.getCause()) && ex.getCause() instanceof BaseException) {
                BaseException se = (BaseException) ex.getCause();
                String status = se.getExceptionCode();
                String message = PropCache.getValue("prop/exception", status);
                respResult = ReturnResultUtil.returnFail(message);
                respResult.setMessage(message);
            } else if (ex instanceof NoSuchMethodException) {
                respResult = ReturnResultUtil.returnFail(PropCache.getValue("prop/exception", "METHOD_NAME_ERROR"));
            } else {
                ex.printStackTrace();
                String message = PropCache.getValue("prop/exception", "COMMON_EXCEPTION");
                respResult = ReturnResultUtil.returnFail(message);
            }
        } finally {
            printUtil.write(respResult);
        }
    }
}
