package com.skxd.service.common;

import com.zxs.busidao.GenericDAO;
import com.zxs.common.Constant;
import com.zxs.common.Page;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectService<T> {

    @Autowired
    private GenericDAO selectDao;

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, int curPage) {
        return selectDao.getPage(countStatement, dataStatement, parameter, curPage);
    }

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, int curPage, int pageSize) {

        return selectDao.getPage(countStatement, dataStatement, parameter, curPage, pageSize);
    }

    public Page<T> getPage(String countStatement, String dataStatement, Object parameter, Page page) {
        return selectDao.getPage(countStatement, dataStatement, parameter, page);
    }

    public Page<T> getPage(Class clazz, Object parameter, int curPage) {
        return selectDao.getPage(clazz, parameter, curPage);
    }

    public Page<T> getPage(Class clazz, Object parameter, int curPage, int pageSize) {
        return selectDao.getPage(clazz, parameter, curPage, pageSize);
    }

    public Page<T> getPage(Class clazz, Object parameter, Page page) {
        return selectDao.getPage(clazz, parameter, page);
    }

    public Object list(String string, Map<String, Object> map) {
        Object obj = selectDao.list(string, map);
        return obj;
    }

    public Object object(String string, Object parameter) {
        Object obj = selectDao.object(string, parameter);
        return obj;
    }

    /***
     * add by zzshang 专门用于easy ui 的分页
     *
     * @param countStatement
     * @param dataStatement
     * @param parameter
     * @return
     */
    public Page<T> getPage(String countStatement, String dataStatement, Object parameter) {
        Map params = null;
        if (parameter instanceof Map) {
            params = (Map) parameter;
        }
        Integer page = ((params.get("page") == null || params.get("page") == "") ? Constant.PAGE_DEFAULT_PAGE_NO : Integer.valueOf((ObjectUtils.toString(params.get("page")))));
        Integer rows = ((params.get("rows") == null || params.get("rows") == "") ? Constant.PAGE_DEFAULT_SIZE : Integer.valueOf((ObjectUtils.toString(params.get("rows")))));
        return selectDao.getPage(countStatement, dataStatement, parameter, page, rows);
    }

    public Page<T> getPageByLimit(String countStatement,String queryStatement,Map params) {
        Page<T> page = new Page<>();
        Integer pageNo = ((params.get("page") == null || params.get("page") == "") ? Constant.PAGE_DEFAULT_PAGE_NO : Integer.valueOf((ObjectUtils.toString(params.get("page")))));
        Integer rows = ((params.get("rows") == null || params.get("rows") == "") ? Constant.PAGE_DEFAULT_SIZE : Integer.valueOf((ObjectUtils.toString(params.get("rows")))));
        //计算数目
        Integer total = selectDao.count(countStatement, params);
        int start = (pageNo-1)*rows;
        params.put("beginPos", start);
        params.put("rows", rows);
        List<T> list = selectDao.list(queryStatement, params);
        page.setRows(list);
        page.setTotal(total);
        return page;
    }
}
