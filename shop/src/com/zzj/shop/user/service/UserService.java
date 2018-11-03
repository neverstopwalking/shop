package com.zzj.shop.user.service;
/**
 * �û�serviceģ��
 * @author zhouz
 *
 */

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.user.dao.UserDao;
import com.zzj.shop.user.vo.User;
import com.zzj.shop.utils.MailUtils;
import com.zzj.shop.utils.UUIDUtils;
@Transactional
public class UserService {
     private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username);
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		user.setState(0);//0��ʾ�û�δ���1��ʾ����
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		
	  //���� �����ʼ�
		MailUtils.sendMail(user.getEmail(), user.getCode());
		
	}

	public User findByCode(String code) {
		// TODO Auto-generated method stub
		return userDao.findByCode(code);
	}

	public void update(User existUser) {
		// TODO Auto-generated method stub
		userDao.update(existUser);
	}

	public User login(User user) {
		// TODO Auto-generated method stub
	 return  userDao.login(user);
		
	}
	
	
}
