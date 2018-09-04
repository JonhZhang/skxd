package com.skxd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/12.
 */
public class Table implements Serializable{

    List<Cloumn> cloumns=new ArrayList<Cloumn>();

    String tableName="";
    //类名
    String lowerClassName="";

    String className;

    String noPreTableName;

    String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNoPreTableName() {
        return noPreTableName;
    }

    public void setNoPreTableName(String noPreTableName) {
        this.noPreTableName = noPreTableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Cloumn> getCloumns() {
        return cloumns;
    }

    public void setCloumns(List<Cloumn> cloumns) {
        this.cloumns = cloumns;
    }

    public String getLowerClassName() {
        return lowerClassName;
    }

    public void setLowerClassName(String lowerClassName) {
        this.lowerClassName = lowerClassName;
    }



}
