package com.skxd.service;
import com.skxd.model.SkxdMessage;

import java.util.List;
import java.util.Map;

import com.skxd.model.SkxdMessageExample;

import java.util.List;
import java.util.Map;

import com.zxs.common.Page;
/**
 * Created by shang-pc on 2015/11/7.
 */
public interface ISkxdMessageService {

    public int saveOrUpdateSkxdMessage(SkxdMessage obj)throws Exception;

    public SkxdMessage querySkxdMessageById(String id)throws Exception;

    public int removeSkxdMessageByIds(String ids)throws Exception;

    public List<SkxdMessage> querySkxdMessageList(SkxdMessageExample example)throws Exception;

    public Page<SkxdMessage> querySkxdMessagePage(Map params)throws Exception;

    void sendEmail(String recipient,String title,String content);
}
