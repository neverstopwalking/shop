package com.zzj.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zzj.shop.cart.vo.Cart;
import com.zzj.shop.cart.vo.CartItem;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;


/**
 * 购物车action
 * @author zhouz
 *
 */
public class CartAction extends ActionSupport{
	
	//注入productService
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

	//接受产品pid
	  private Integer pid;
	  //接受数量count
	  private Integer count;
	
	  //将购物项添加到item
	    public String addCart()
	    {
	    	
	    	CartItem cartItem=new CartItem();
	    	//设置购物项数量
	    	cartItem.setCount(count);
	    	
	      //根据商品id查询到商品
	    	Product product=productService.findByPid(pid);
	    	cartItem.setProduct(product);
	    	//获得购物车
	    	Cart cart=getCart();
	    	//把购物项添加到购物车中
	    	cart.addCartItem(cartItem);
	    	return "addCart";
	    }
   //从session中获得购物车
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
	
	//清空购物车
	public String clearCart()
	{
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	
	//从购物车中移除商品
	public String  removeCart()
	{
		
		//获取购物车对象
		Cart cart=getCart();
		//删除购物车商品
		cart.removeItem(pid);
		return "removeCart";
	}
	
	//我的购物车
	public String mycart()
	{
		return "mycart";
	}
}
