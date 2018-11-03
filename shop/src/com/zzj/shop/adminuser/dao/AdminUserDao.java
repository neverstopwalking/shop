package com.zzj.shop.adminuser.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzj.shop.adminuser.vo.AdminUser;

/**
 * 后台管理员dao层代码
 * @author zhouz
 *
 */
public class AdminUserDao {

	
	//注入sessionfatory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
  //后台管理员登录的方法
	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		
		String hql="from AdminUser ad where ad.username=? and ad.password=?";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setString(0, adminUser.getUsername());
		query.setString(1, adminUser.getPassword());
		List<AdminUser> list=query.list();
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
	
}
