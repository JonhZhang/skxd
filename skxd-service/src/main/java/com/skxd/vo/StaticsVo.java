package com.skxd.vo;

import java.io.Serializable;

/**
 * 统计的方法
 * <p>
 * Created by shang-pc on 2016/5/7.
 */
public class StaticsVo implements Serializable {

    private String name;

    private Double total;

    private Integer month;

    private String customId;

    private String staticType;

    private Integer year;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStaticType() {
        return staticType;
    }

    public void setStaticType(String staticType) {
        this.staticType = staticType;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}


