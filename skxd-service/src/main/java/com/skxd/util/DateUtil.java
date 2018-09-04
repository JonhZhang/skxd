package com.skxd.util;
import com.zxs.utils.lang.EmptyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shang-pc on 2016/5/28.
 */
public class DateUtil {

    public static Date strToDate(String str)throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(EmptyUtils.isEmpty(str)){
            return null;
        }
        Date date = format.parse(str);
        return date;
    }

    public static Date strToDate(String str,String formatStr)throws Exception{
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        if(EmptyUtils.isEmpty(str)){
            return null;
        }
        Date date = format.parse(str);
        return date;
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    public static String dateToStr(Date date,String pattern) {
        if(EmptyUtils.isEmpty(date)){
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String str = format.format(date);
        return str;
    }
}
