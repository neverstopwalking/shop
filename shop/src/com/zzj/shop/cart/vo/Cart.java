package com.zzj.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.zzj.shop.product.vo.Product;

/**
 * 购物车对象
 * @author zhouz
 *
 */
public class Cart {
	//购物车属性
	//购物项的集合，key是商品的pid，value是购物项
	  private Map<Integer, CartItem> map=new LinkedHashMap<Integer,CartItem>();
	  //购物总计
	  private double total;
	  
	  public Collection<CartItem> getCartItems()
	  {
		  return map.values();
	  }
	public double getTotal() {
		return total;
	}
	//购物车的功能：
	  //将购物项添加到购物车
	  public void addCartItem(CartItem cartItem)
	  {
		  //判断购物车中是否存在购物项
		  //存在，改变数量增加，总计增加
		  int pid=cartItem.getProduct().getPid();
		  if(map.containsKey(pid))
		  {
			  map.get(pid).setCount(map.get(pid).getCount()+cartItem.getCount());
		  }
		  
		  
		  //不存在，添加购物项，改变数量，总计增加
		  else {
			  map.put(pid, cartItem);
		  }
		  
		  total+=cartItem.getSubTotal(); 
	  }
	  //将购物项从购物车中移除
	  public void removeItem(Integer pid)
	  {
		  //将购物项从购物车中移除
		 CartItem cartItem= map.remove(pid);
		  //总计减去移除的购物项小计
		 total-=cartItem.getSubTotal();
		  
	  }
	  //清空购物车
	  public void clearCart()
	  {
		  //清空购物项
		  map.clear();
		  //总计变为0
		  total=0;
	  }

}
