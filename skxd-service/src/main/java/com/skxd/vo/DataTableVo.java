package com.skxd.vo;

import com.zxs.common.Constant;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/27.
 */
public class DataTableVo implements Serializable{

    private Long sEcho;
    private List aaData;
    private Long iTotalRecords;
    private Long iTotalDisplayRecords;
    private Long iDisplayStart;
    private Long iDisplayLength;
    private String sSearch;

    private String sSearch_1;
    private String sSearch_2;
    private String sSearch_3;
    private String sSearch_4;
    private String sSearch_5;
    private String sSearch_6;
    private String sSearch_7;
    private String sSearch_8;
    private String sSearch_9;
    private String sSearch_10;

    public String getsSearch_1() {
        return sSearch_1;
    }

    public void setsSearch_1(String sSearch_1) {
        this.sSearch_1 = sSearch_1;
    }

    public String getsSearch_2() {
        return sSearch_2;
    }

    public void setsSearch_2(String sSearch_2) {
        this.sSearch_2 = sSearch_2;
    }

    public String getsSearch_3() {
        return sSearch_3;
    }

    public void setsSearch_3(String sSearch_3) {
        this.sSearch_3 = sSearch_3;
    }

    public String getsSearch_4() {
        return sSearch_4;
    }

    public void setsSearch_4(String sSearch_4) {
        this.sSearch_4 = sSearch_4;
    }

    public String getsSearch_5() {
        return sSearch_5;
    }

    public void setsSearch_5(String sSearch_5) {
        this.sSearch_5 = sSearch_5;
    }

    public String getsSearch_6() {
        return sSearch_6;
    }

    public void setsSearch_6(String sSearch_6) {
        this.sSearch_6 = sSearch_6;
    }

    public String getsSearch_7() {
        return sSearch_7;
    }

    public void setsSearch_7(String sSearch_7) {
        this.sSearch_7 = sSearch_7;
    }

    public String getsSearch_8() {
        return sSearch_8;
    }

    public void setsSearch_8(String sSearch_8) {
        this.sSearch_8 = sSearch_8;
    }

    public String getsSearch_9() {
        return sSearch_9;
    }

    public void setsSearch_9(String sSearch_9) {
        this.sSearch_9 = sSearch_9;
    }

    public String getsSearch_10() {
        return sSearch_10;
    }

    public void setsSearch_10(String sSearch_10) {
        this.sSearch_10 = sSearch_10;
    }

    public String getsSearch() {
        return sSearch;
    }

    public void setsSearch(String sSearch) {
        this.sSearch = sSearch;
    }

    public Long getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(Long iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public Long getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(Long iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public Long getsEcho() {
        return sEcho;
    }

    public void setsEcho(Long sEcho) {
        this.sEcho = sEcho;
    }

    public List getAaData() {
        return aaData;
    }

    public void setAaData(List aaData) {
        this.aaData = aaData;
    }

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public static Map cpoyDataTableToMap(DataTableVo dataTableVo){
        Map params=new HashMap();
        //当前页数
        if(EmptyUtils.isNotEmpty(dataTableVo)){
            params.put("page",EmptyUtils.isEmpty(dataTableVo.getsEcho())? Constant.PAGE_DEFAULT_PAGE_NO-1:(dataTableVo.getiDisplayStart()/ dataTableVo.getiDisplayLength())+1);
        }else{
            params.put("page",Constant.PAGE_DEFAULT_PAGE_NO);
        }
        //页大小
        params.put("rows", dataTableVo.getiDisplayLength());
        params.put("search", dataTableVo.getsSearch());
        params.put("search_1", dataTableVo.getsSearch_1());
        params.put("search_2", dataTableVo.getsSearch_2());
        params.put("search_3", dataTableVo.getsSearch_3());
        params.put("search_4", dataTableVo.getsSearch_4());
        params.put("search_5", dataTableVo.getsSearch_5());
        params.put("search_6", dataTableVo.getsSearch_6());
        params.put("search_7", dataTableVo.getsSearch_7());
        params.put("search_8", dataTableVo.getsSearch_8());
        params.put("search_9", dataTableVo.getsSearch_9());
        return  params;
    }

    public static DataTableVo cpoyPageToDataTable(Page page){
        DataTableVo dataTableVo =new DataTableVo();
        if(EmptyUtils.isNotEmpty(page)){
            dataTableVo.setAaData(page.getRows());
            dataTableVo.setiTotalDisplayRecords(page.getTotal());
            dataTableVo.setiTotalRecords(page.getTotal());
            dataTableVo.setsEcho(page.getCurPage());
        }
        return dataTableVo;
    }


}
