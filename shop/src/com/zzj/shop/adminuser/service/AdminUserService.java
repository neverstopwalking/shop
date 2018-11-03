package com.zzj.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.adminuser.dao.AdminUserDao;
import com.zzj.shop.adminuser.vo.AdminUser;

/**
 * 后台管理员业务层代码
 * @author zhouz
 *
 */
@Transactional
public class AdminUserService {

  //注入dao层
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
		
	}
	
}
