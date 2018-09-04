package com.skxd.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("mailUtil")
public class MailUtil {
    @Autowired
    JavaMailSender mailSender;
    @Value("${mail.from}")
    private String SEND_FROM;
    @Value("${mail.from.nick}")
    private String SEND_FROM_PERSONAL;

    public  boolean sslSend(MessageInfo msg1)
            throws AddressException, MessagingException, IOException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        final String username = "sinwonderful@163.com";
        final String password = "59966340";
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});
        Message msg = new MimeMessage(session);

        // 设置发件人和收件人
        msg.setFrom(new InternetAddress(username));
        List<String> tos = msg1.getTo();
        Address to[] = new InternetAddress[tos.size()];
        for(int i=0;i<tos.size();i++){
            to[i] = new InternetAddress(tos.get(i));
        }
        // 多个收件人地址
        msg.setRecipients(Message.RecipientType.TO, to);
        msg.setSubject(msg1.getSubject()); // 标题
        msg.setText(msg1.getMsg());// 内容
        msg.setSentDate(new Date());
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText("赛科希德");
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setFrom(new InternetAddress(nick+" <"+username+">"));
        Transport.send(msg);
        System.out.println("EmailUtil ssl协议邮件发送打印" +msg.toString());
        return true;
    }


    public void simpleSend(String to, String subject, String text) {
        SimpleMailMessage mail = new SimpleMailMessage(); // 注意SimpleMailMessage只能用来发送text格式的邮件

        mail.setTo(to);// 接受者
        mail.setFrom(SEND_FROM_PERSONAL + "<" + SEND_FROM + ">");// 发送者,这里还可以另起Email别名，不用和xml里的username一致
        mail.setSubject(subject);// 主题
        mail.setText(text);// 邮件内容
        mailSender.send(mail);
    }

    public void sendWithHtml(String to, String subject, String html) throws Exception {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

        messageHelper.setTo(to);// 接受者
        messageHelper.setFrom(SEND_FROM, SEND_FROM_PERSONAL);// 发送者
        messageHelper.setSubject(subject);// 主题
        // 邮件内容，注意加参数true，表示启用html格式
        messageHelper.setText(html, true);
        mailSender.send(mailMessage);
    }

    public void sendWithAttach(String to, String subject, String html, List<File> attachments, Map<String, File> cidMap) throws Exception {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        //设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

        messageHelper.setTo(to);//接受者
        messageHelper.setFrom(SEND_FROM, SEND_FROM_PERSONAL);// 发送者
        messageHelper.setSubject(subject);//主题
        //邮件内容，注意加参数true
        messageHelper.setText(html, true);
        //添加cid
        if (cidMap != null && cidMap.size() > 0) {
            Set<String> set = cidMap.keySet();
            for (String cid : set) {
                messageHelper.addInline(cid, cidMap.get(cid));
            }
        }
        //附件内容
        if (attachments != null && attachments.size() > 0) {
            for (File file : attachments) {
                // 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
                messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
            }
        }
        mailSender.send(mailMessage);
    }

    /**
     * 检测邮箱地址是否合法
     *
     * @param email
     * @return true合法 false不合法
     */
    public boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
//        Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }



}
