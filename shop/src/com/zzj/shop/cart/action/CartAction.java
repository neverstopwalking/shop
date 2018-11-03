package com.zzj.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zzj.shop.cart.vo.Cart;
import com.zzj.shop.cart.vo.CartItem;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;


/**
 * ���ﳵaction
 * @author zhouz
 *
 */
public class CartAction extends ActionSupport{
	
	//ע��productService
	private ProductService productService;
		public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
			this.pid = pid;
		}
		public void setCount(Integer count) {
			this.count = count;
		}

	//���ܲ�Ʒpid
	  private Integer pid;
	  //��������count
	  private Integer count;
	
	  //����������ӵ�item
	    public String addCart()
	    {
	    	
	    	CartItem cartItem=new CartItem();
	    	//���ù���������
	    	cartItem.setCount(count);
	    	
	      //������Ʒid��ѯ����Ʒ
	    	Product product=productService.findByPid(pid);
	    	cartItem.setProduct(product);
	    	//��ù��ﳵ
	    	Cart cart=getCart();
	    	//�ѹ�������ӵ����ﳵ��
	    	cart.addCartItem(cartItem);
	    	return "addCart";
	    }
   //��session�л�ù��ﳵ
	private Cart getCart() {
		// TODO Auto-generated method stub
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null)
		{
			cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
	//��չ��ﳵ
	public String clearCart()
	{
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	
	//�ӹ��ﳵ���Ƴ���Ʒ
	public String  removeCart()
	{
		
		//��ȡ���ﳵ����
		Cart cart=getCart();
		//ɾ�����ﳵ��Ʒ
		cart.removeItem(pid);
		return "removeCart";
	}
	
	//�ҵĹ��ﳵ
	public String mycart()
	{
		return "mycart";
	}
}
