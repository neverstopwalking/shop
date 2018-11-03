package com.zzj.shop.category.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzj.shop.category.vo.Category;

/**
 * 一级分类的持久层对象
 * @author zhouz
 *
 */
public class CategoryDao {
     private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Category> findAll() {
		// TODO Auto-generated method stub
	    String hql="from Category";
	    Session session=sessionFactory.getCurrentSession();
	    Query query=  session.createQuery(hql);
	     List<Category>categories=query.list();
	    
		return categories;
	}
	
	public void save(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
	}
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		String hql="from Category where cid=?";
	    Session session=sessionFactory.getCurrentSession();
	    Query query=  session.createQuery(hql);
	    query.setString(0, cid+"");
	    List<Category> list=query.list();
	    if(list!=null&&list.size()>0)
	    {
	    	return list.get(0);
	    }
		return null;
	}
	
	//删除一级分类的方法
	public void delete(Category existCategory) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.getCurrentSession();
		 session.delete(existCategory);
		
	}
	public void update(Category category) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.getCurrentSession();
		 session.update(category);
		
	}

}
