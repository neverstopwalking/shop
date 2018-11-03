package com.zzj.shop.order.vo;

import com.zzj.shop.product.vo.Product;

/**
 * 订单项的实体类
 * @author zhouz
 *
 */
public class OrderItem {
		private Integer itemid;
		private Integer count;
		private Double subTotal;
		private Product product;
		private Order order;
		public Integer getItemid() {
			return itemid;
		}
		public void setItemid(Integer itemid) {
			this.itemid = itemid;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Double getSubTotal() {
			return subTotal;
		}
		public void setSubTotal(Double subTotal) {
			this.subTotal = subTotal;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
}
