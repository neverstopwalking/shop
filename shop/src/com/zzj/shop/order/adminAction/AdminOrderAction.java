package com.zzj.shop.order.adminAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.order.service.OrderService;
import com.zzj.shop.order.vo.Order;
import com.zzj.shop.order.vo.OrderItem;
import com.zzj.shop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
		private Order order=new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	//ע��page����
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//ע��orderService
	private OrderService orderService;
	
	
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}



	//��ҳ��ѯ�����ķ���
	public String findAll()
	{
		PageBean<Order> pageBean=orderService.findByPage(page);
		
		//���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//���ݶ���id��ѯ������
	public String findOrderItem()
	{
		List<OrderItem> list=orderService.findOrderItem(order.getOid());
		
		//��ŵ�ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	//���¶���״̬�ķ���
	public String updateState()
	{
		Order currentOrder=orderService.findByOid(order.getOid());
		currentOrder.setState(3);
		orderService.update(currentOrder);
		return "updateSuccess";
	}

}
