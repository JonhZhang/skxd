package com.skxd.service.impl;
import com.alibaba.fastjson.JSON;
import com.skxd.dao.SkxdMessageMapper;
import com.skxd.model.SkxdMessage;
import com.skxd.model.SkxdMessageExample;
import com.skxd.model.ZxsMessage;
import com.skxd.model.ZxsMessageType;
import com.skxd.service.ISkxdMessageService;
import com.skxd.service.common.SelectService;
import com.skxd.util.MailUtil;
import com.skxd.util.MessageInfo;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkxdMessageServiceImpl implements ISkxdMessageService {

    @Autowired
    private SkxdMessageMapper skxdMessageMapper;



    @Autowired
    private SelectService<SkxdMessage> selectService;
    @Autowired
    private MailUtil mailUtil;

    public void sendEmail(String recipient,String title,String content) {

        try {
          //  mailUtil.sendWithAttach(recipient, title, content,null,null);
            MessageInfo info = new MessageInfo();
            info.setTo(Arrays.asList(recipient));
            info.setMsg(content);
            info.setFrom("赛科希德");
            info.setSubject(title);
            mailUtil.sslSend(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int saveOrUpdateSkxdMessage(SkxdMessage skxdMessage) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdMessage.getId())){
            skxdMessage.setUpdatedDate(new Date());
            flag=skxdMessageMapper.updateByPrimaryKeySelective(skxdMessage);
        }else{
            skxdMessage.setId(StringUtils.randomUUID());
            skxdMessage.setCreatedDate(new Date());
            flag=skxdMessageMapper.insert(skxdMessage);
        }
        return flag;
    }

    public SkxdMessage querySkxdMessageById(String id) throws Exception{
        return skxdMessageMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdMessageByIds(String ids)throws Exception{
        SkxdMessageExample skxdMessageExample=new SkxdMessageExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdMessageExample.createCriteria().andIdIn(idsList);
        int flag=skxdMessageMapper.deleteByExample(skxdMessageExample);
        return flag;
    }

    public List<SkxdMessage> querySkxdMessageList(SkxdMessageExample example)throws Exception{
        return skxdMessageMapper.selectByExample(example);
    }

    public Page<SkxdMessage> querySkxdMessagePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdMessage.getSkxdMessageCount";
        String listSqlId = "SkxdMessage.getSkxdMessagePage";
        Page<SkxdMessage> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
