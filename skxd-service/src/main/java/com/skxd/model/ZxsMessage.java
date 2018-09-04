package com.skxd.model;

import java.util.Date;

public class ZxsMessage {

    private String id;

   
    private String title;

  
    private String content;


    private String recipient;

  
    private String senderId;

   
    private String createdUserId;

  
    private String senderName;

  
    private Date createdDate;

  
    private ZxsMessageType messageType;
   
    private Date updatedDate;
    
    private String sendTypes;

   
    private static final long serialVersionUID = 1L;

  
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

   
    public String getTitle() {
        return title;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }

   
    public String getContent() {
        return content;
    }

   
    public void setContent(String content) {
        this.content = content;
    }

  
    public String getRecipient() {
        return recipient;
    }

    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

   
    public String getSenderId() {
        return senderId;
    }

    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

 
    public String getCreatedUserId() {
        return createdUserId;
    }

 
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

   
    public String getSenderName() {
        return senderName;
    }

  
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

   
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    

  
    public ZxsMessageType getMessageType() {
		return messageType;
	}


	public void setMessageType(ZxsMessageType messageType) {
		this.messageType = messageType;
	}


	public Date getUpdatedDate() {
        return updatedDate;
    }

 
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


	public String getSendTypes() {
		return sendTypes;
	}


	public void setSendTypes(String sendTypes) {
		this.sendTypes = sendTypes;
	}
    
}
