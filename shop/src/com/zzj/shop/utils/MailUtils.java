package com.zzj.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailUtils {
	/**
	 * 发送邮件方法
	 * @param to  收件人
	 * @param code  激活码
	 */
		public static void sendMail(String to,String code)
	{
			
			//获得连接对象
			Properties props=new Properties();
			props.setProperty("mail.host", "localhost");
	    Session session=Session.getInstance(props,new Authenticator() {
	    			@Override
	    			protected PasswordAuthentication getPasswordAuthentication() {
	    				// TODO Auto-generated method stub
	    				return  new PasswordAuthentication("service@shop.com","111");
	    			}
		});
	    
	    //创建邮件对象
	    Message message=new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress("service@shop.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//设置标题
			message.setSubject("来自官方商城的激活邮件");
			//设置邮件内容
			message.setContent("<h1>官方商城激活邮件！点下面链接进行激活</h1><h3><a href='http://218.192.168.143:8080/shop/user_active.action?code="+code+"'>http://218.192.168.143:8080/shop/user_active.action?code="+code+"</a></h3>","text/html;charset=UTF-8");
			//发送邮件
			Transport.send(message);
			
	    
	    } catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	   
	}
		
		
		public static void main(String []args)
		{
			sendMail("aaa@shop.com", "aaaaaaa");
		}
}
