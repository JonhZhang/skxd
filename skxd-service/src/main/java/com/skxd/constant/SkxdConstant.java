package com.skxd.constant;
/**
 * <p></p>
 * <p/>
 * Created by john on 2015/8/18.
 */
public class SkxdConstant {

    public static interface RespStatus{
        //成功
        public static String SUCCESS="1";
        //失败
        public static String FAIL="0";
        //
        public static String LOGIN="-2";
    }

    public static interface RespMessage{
        //成功
        public static String SUCCESS="操作成功";
        //失败
        public static String FAIL="操作失败";
    }
    /**
     * 短信类型
     */
    public static interface MessageType{

        public static String REGISTER="1";

        public static String MODIFY_PASSWORD="2";
    }
    /**
     * 内容介绍类型
     */
    public static interface InstructionType{
        //保密协议
        public static Integer PROTOCOL=1;
    }
    /**
     * 测量温度的设备类型
     */
    public static interface ProductType{
        //一次性测量
        public static Integer MOMENT_MEASURE=0;
        //持续监测
        public static Integer CONTINUE_MEASURE=1;
    }
    /**
     * 病历提交状态
     */
    public static interface SkxdCase{
        public static interface status{
            //初始提交
            public static String APPLY="0";
            //需要补充
            public static String REPLENISH="1";
            //驳回
            public static String REFUSE="-1";
            //提交成功
            public static String SUCCESS="2";
        }
    }
}
