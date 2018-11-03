package com.zzj.shop.categorysecond.vo;

import java.util.Set;

import com.zzj.shop.category.vo.Category;
import com.zzj.shop.product.vo.Product;

public class CategorySecond {
	
	private Integer csid;
	private String csname;
	
	//���һ������Ķ���
	private Category category;
	
	//������Ʒ�ļ���
	private Set<Product> products;
	

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
