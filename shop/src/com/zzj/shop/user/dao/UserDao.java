package com.zzj.shop.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.zzj.shop.user.vo.User;

/**
 * 用户dao模块
 * @author zhouz
 *
 */
public class UserDao   {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User findByName(String username) {
		// TODO Auto-generated method stub
	String hql="from User where username=?";
	Session session=sessionFactory.getCurrentSession();
     Query query=session.createQuery(hql);
     query.setString(0, username);
	
	
	 List<User> userList=query.list();
	 if(userList!=null&&userList.size()>0)
		 return userList.get(0);
	 else 
		 return null;
	}
    //保存用户到数据库中
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}

	public User findByCode(String code) {
		// TODO Auto-generated method stub
		String hql="from User where code=?";
		Session session=sessionFactory.getCurrentSession();
	     Query query=session.createQuery(hql);
	     query.setString(0, code);
		
		
		 List<User> userList=query.list();
		 if(userList!=null&&userList.size()>0)
			 return userList.get(0);
		 else 
			 return null;
		}

	public void update(User existUser) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(existUser);
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		String hql="from User where username=? and password=? and state=?";
		Session session=sessionFactory.getCurrentSession();
	     Query query=session.createQuery(hql);
	     query.setString(0, user.getUsername());
	     query.setString(1, user.getPassword());
	     query.setString(2, 1+"");
		
		
		 List<User> userList=query.list();
		 if(userList!=null&&userList.size()>0)
			 return userList.get(0);
		 else 
			 return null;
	}
	
     
}
