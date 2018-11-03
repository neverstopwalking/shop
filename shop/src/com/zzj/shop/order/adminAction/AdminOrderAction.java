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
	//注入page参数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//注入orderService
	private OrderService orderService;
	
	
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}



	//分页查询订单的方法
	public String findAll()
	{
		PageBean<Order> pageBean=orderService.findByPage(page);
		
		//放入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//根据订单id查询订单项
	public String findOrderItem()
	{
		List<OrderItem> list=orderService.findOrderItem(order.getOid());
		
		//存放到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	//更新订单状态的方法
	public String updateState()
	{
		Order currentOrder=orderService.findByOid(order.getOid());
		currentOrder.setState(3);
		orderService.update(currentOrder);
		return "updateSuccess";
	}

}
