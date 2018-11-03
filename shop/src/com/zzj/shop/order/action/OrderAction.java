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
 * ���������action
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
	//ע��page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	//ע��orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	//���ɶ����ķ���
	public String save()
	{
//		//�������ݵ����ݿ�
		order.setOrdertime(new Date());
		order.setState(1);//1��ʾδ���2��ʾ�Ѹ��δ������3��ʾ�ѷ�������δ�ջ�4��ʾ�������
		//�ܼƵ������ǹ��ﳵ�е���Ϣ
		//��ù��ﳵ
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null)
		{
			this.addActionError("�ף�����û�й������ȥ����");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		
		//���ö����еĶ�����
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubTotal(cartItem.getSubTotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		//���ö��������û�
		User existUser=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser==null)
		{
			this.addActionError("������û�е�¼������ȥ��¼");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		
		//������������ʾ��ҳ����
        //��չ��ﳵ
		cart.clearCart();
		
		return "saveSuccess";
	}
	//�ҵĶ�����ѯ
	public String findByUid()
	{
		//�����û���id��ѯ
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//����service
		PageBean<Order>pageBean=orderService.findByPageUid(user.getUid(),page);
		
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
	}
	
	//���ݶ�����id��ѯ����
	public String findByOid()
	{
		
		order=orderService.findByOid(order.getOid());
		
		return "findByOidSuccess";
		
	}
	
	//���¶���״̬
	public String updateState()
	{

		Order currentOrder=orderService.findByOid(order.getOid());
		currentOrder.setState(4);
		orderService.update(currentOrder);
		return "updateSuccess";
	}

}
