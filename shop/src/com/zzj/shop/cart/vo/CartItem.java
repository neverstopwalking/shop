package com.zzj.shop.cart.vo;
/**
 * ������
 * @author zhouz
 *
 */

import com.zzj.shop.product.vo.Product;

public class CartItem {
  private Product product;
  private Integer count;//������Ʒ��Ŀ
  private double subTotal;//����С�Ƽ۸�
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
