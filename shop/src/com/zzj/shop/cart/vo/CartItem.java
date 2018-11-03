package com.zzj.shop.cart.vo;
/**
 * 购物项
 * @author zhouz
 *
 */

import com.zzj.shop.product.vo.Product;

public class CartItem {
  private Product product;
  private Integer count;//购物商品数目
  private double subTotal;//购物小计价格
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public double getSubTotal() {
	return count*product.getShop_price();
}

}
