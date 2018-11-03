package com.zzj.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.order.dao.OrderDao;
import com.zzj.shop.order.vo.Order;
import com.zzj.shop.order.vo.OrderItem;
import com.zzj.shop.utils.PageBean;

/**
 * 订单业务处代码
 * @author zhouz
 *
 */
@Transactional
public class OrderService {

	
	//注入orderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean=new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		Integer limit=2;
		pageBean.setLimit(limit);
		Integer totalCount=0;
		totalCount=orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		
		Integer totalPage=0;
		totalPage=(int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		
		Integer begin=(page-1)*limit;
		List<Order> list=orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findByOid(oid);
	}

	public PageBean<Order> findByPage(Integer page) {
		// TODO Auto-generated method stub
		
		PageBean<Order> pageBean=new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		Integer limit=4;
		pageBean.setLimit(limit);
		Integer totalCount=0;
		totalCount=orderDao.findByCount();
		pageBean.setTotalCount(totalCount);
		
		Integer totalPage=0;
		totalPage=(int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		
		Integer begin=(page-1)*limit;
		List<Order> list=orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItem(oid);
		
	}

	public void update(Order currentOrder) {
		// TODO Auto-generated method stub
		orderDao.update(currentOrder);
	}
	
}
