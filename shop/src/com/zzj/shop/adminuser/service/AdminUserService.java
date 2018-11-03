package com.zzj.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.adminuser.dao.AdminUserDao;
import com.zzj.shop.adminuser.vo.AdminUser;

/**
 * ��̨����Աҵ������
 * @author zhouz
 *
 */
@Transactional
public class AdminUserService {

  //ע��dao��
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
		
	}
	
}
