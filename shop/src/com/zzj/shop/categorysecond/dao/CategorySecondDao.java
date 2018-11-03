package com.zzj.shop.categorysecond.dao;
/**
 * 二级分类管理的dao层
 * @author zhouz
 *
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzj.shop.categorysecond.vo.CategorySecond;

public class CategorySecondDao {
	
	//注入SessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    //查询二级分类的个数
	public int findCount() {
		// TODO Auto-generated method stub
	 String hql="select count(*) from CategorySecond";
	 
	 Session session=sessionFactory.getCurrentSession();
	 Query query=session.createQuery(hql);
	 List<Long> list=query.list();
	 if(list!=null&&list.size()>0)
	 {
		 return list.get(0).intValue();
	 }
		return 0;
	}

	public List<CategorySecond> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from CategorySecond order by csid desc";
		Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery(hql);
		 query.setFirstResult(begin);
		 query.setMaxResults(limit);
		 List<CategorySecond> list=query.list();
		 
		 return list;
		
	}
	//保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(categorySecond);
	}
	
	//根据二级分类id查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		String hql="from CategorySecond where csid=?";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setString(0, csid+"");
		List<CategorySecond> list=query.list();
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
	//删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(categorySecond);
	}
	
	//修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(categorySecond);
	}
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		String hql="from CategorySecond";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		return  query.list();
	}

}
