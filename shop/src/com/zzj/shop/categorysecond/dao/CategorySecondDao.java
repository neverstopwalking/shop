package com.zzj.shop.categorysecond.dao;
/**
 * ������������dao��
 * @author zhouz
 *
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzj.shop.categorysecond.vo.CategorySecond;

public class CategorySecondDao {
	
	//ע��SessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    //��ѯ��������ĸ���
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
	//�����������ķ���
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(categorySecond);
	}
	
	//���ݶ�������id��ѯ��������
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
	//ɾ����������ķ���
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(categorySecond);
	}
	
	//�޸Ķ�������ķ���
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
