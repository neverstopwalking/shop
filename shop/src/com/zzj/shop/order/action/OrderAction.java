package com.zzj.shop.order.action;





import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.cart.vo.Cart;
import com.zzj.shop.cart.vo.CartItem;
import com.zzj.shop.order.service.OrderService;
import com.zzj.shop.order.vo.Order;
import com.zzj.shop.order.vo.OrderItem;
import com.zzj.shop.user.vo.User;
import com.zzj.shop.utils.PageBean;

/**
 * 订单管理的action
 * @author zhouz
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
   private Order order=new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	//注入page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	//注入orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	//生成订单的方法
	public String save()
	{
//		//保存数据到数据库
		order.setOrdertime(new Date());
		order.setState(1);//1表示未付款，2表示已付款，未发货，3表示已发货，还未收货4表示交易完成
		//总计的数据是购物车中的信息
		//获得购物车
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null)
		{
			this.addActionError("亲，您还没有购物，请先去购物");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		
		//设置订单中的订单项
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubTotal(cartItem.getSubTotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		//设置订单所属用户
		User existUser=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser==null)
		{
			this.addActionError("请您还没有登录，请先去登录");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		
		//将订单数据显示到页面上
        //清空购物车
		cart.clearCart();
		
		return "saveSuccess";
	}
	//我的订单查询
	public String findByUid()
	{
		//根据用户的id查询
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//调用service
		PageBean<Order>pageBean=orderService.findByPageUid(user.getUid(),page);
		
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
	}
	
	//根据订单的id查询订单
	public String findByOid()
	{
		
		order=orderService.findByOid(order.getOid());
		
		return "findByOidSuccess";
		
	}
	
	//更新订单状态
	public String updateState()
	{

		Order currentOrder=orderService.findByOid(order.getOid());
		currentOrder.setState(4);
		orderService.update(currentOrder);
		return "updateSuccess";
	}

}
