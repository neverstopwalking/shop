package com.zzj.shop.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.zzj.shop.product.vo.Product;

/**
 * ���ﳵ����
 * @author zhouz
 *
 */
public class Cart {
	//���ﳵ����
	//������ļ��ϣ�key����Ʒ��pid��value�ǹ�����
	  private Map<Integer, CartItem> map=new LinkedHashMap<Integer,CartItem>();
	  //�����ܼ�
	  private double total;
	  
	  public Collection<CartItem> getCartItems()
	  {
		  return map.values();
	  }
	public double getTotal() {
		return total;
	}
	//���ﳵ�Ĺ��ܣ�
	  //����������ӵ����ﳵ
	  public void addCartItem(CartItem cartItem)
	  {
		  //�жϹ��ﳵ���Ƿ���ڹ�����
		  //���ڣ��ı��������ӣ��ܼ�����
		  int pid=cartItem.getProduct().getPid();
		  if(map.containsKey(pid))
		  {
			  map.get(pid).setCount(map.get(pid).getCount()+cartItem.getCount());
		  }
		  
		  
		  //�����ڣ���ӹ�����ı��������ܼ�����
		  else {
			  map.put(pid, cartItem);
		  }
		  
		  total+=cartItem.getSubTotal(); 
	  }
	  //��������ӹ��ﳵ���Ƴ�
	  public void removeItem(Integer pid)
	  {
		  //��������ӹ��ﳵ���Ƴ�
		 CartItem cartItem= map.remove(pid);
		  //�ܼƼ�ȥ�Ƴ��Ĺ�����С��
		 total-=cartItem.getSubTotal();
		  
	  }
	  //��չ��ﳵ
	  public void clearCart()
	  {
		  //��չ�����
		  map.clear();
		  //�ܼƱ�Ϊ0
		  total=0;
	  }

}
