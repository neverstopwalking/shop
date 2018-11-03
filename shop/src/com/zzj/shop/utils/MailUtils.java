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
	 * �����ʼ�����
	 * @param to  �ռ���
	 * @param code  ������
	 */
		public static void sendMail(String to,String code)
	{
			
			//������Ӷ���
			Properties props=new Properties();
			props.setProperty("mail.host", "localhost");
	    Session session=Session.getInstance(props,new Authenticator() {
	    			@Override
	    			protected PasswordAuthentication getPasswordAuthentication() {
	    				// TODO Auto-generated method stub
	    				return  new PasswordAuthentication("service@shop.com","111");
	    			}
		});
	    
	    //�����ʼ�����
	    Message message=new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress("service@shop.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//���ñ���
			message.setSubject("���Թٷ��̳ǵļ����ʼ�");
			//�����ʼ�����
			message.setContent("<h1>�ٷ��̳Ǽ����ʼ������������ӽ��м���</h1><h3><a href='http://218.192.168.143:8080/shop/user_active.action?code="+code+"'>http://218.192.168.143:8080/shop/user_active.action?code="+code+"</a></h3>","text/html;charset=UTF-8");
			//�����ʼ�
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
