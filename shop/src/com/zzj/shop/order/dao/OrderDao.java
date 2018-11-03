package com.zzj.shop.order.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzj.shop.order.vo.Order;
import com.zzj.shop.order.vo.OrderItem;

/**
 * 订单dao层代码
 * @author zhouz
 *
 */
public class OrderDao {

	//注入sessionFactory
	   private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Order order) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(order);
		
	}

	public Integer findByCountUid(Integer uid) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
	   String hql="select count(*) from Order o where o.user.uid=?";
	   Query query=session.createQuery(hql);
	   query.setString(0, uid+"");
	   List<Long> list=query.list();
	   if(list!=null&&list.size()>0)
	   {
		   return list.get(0).intValue();
	   }
	   
		return null;
	}

	

	

	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		String hql= "from Order o where o.user.uid=? order by ordertime desc";
		 Query query=session.createQuery(hql);
		   query.setString(0, uid+"");
		   query.setFirstResult(begin);
		   query.setMaxResults(limit);
		   
		   List<Order> list=query.list();
		  return list;
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql= "from Order o where o.oid=?";
		 Query query=session.createQuery(hql);
		  query.setString(0, oid+"");
	  List<Order> list=query.list();
	  if(list!=null&&list.size()>0)
	  {
		  return list.get(0);
	  }
	  return null;
	}

	public Integer findByCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Order";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		List<Long> list=query.list();
		return list.get(0).intValue();
	}

	public List<Order> findByPage(Integer begin, Integer limit) {
		// TODO Auto-generated method stub
		String hql="from Order order by ordertime desc ";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		return query.list();
	}
  //根据订单id查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		String hql="from OrderItem oi where oi.order.oid=? ";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setString(0, oid+"");
		
		return query.list();
	}

	public void update(Order currentOrder) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(currentOrder);
	}

	
	   
}
