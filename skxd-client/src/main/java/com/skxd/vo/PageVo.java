package com.skxd.vo;

import java.io.Serializable;
import java.util.List;

import com.zxs.common.Page;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/21.
 */
public class PageVo<T> implements Serializable{

    private long total;

    private int curPage = 1;

    private long pageSize;

    private long pageCount;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    
    public  PageVo<T> toPageVo(Page<T> page) {
    	this.rows = page.getRows();
    	this.curPage = (int) page.getCurPage();
    	this.pageCount = page.getPageCount();
    	this.total = page.getTotal();
    	return this;
    }
}
