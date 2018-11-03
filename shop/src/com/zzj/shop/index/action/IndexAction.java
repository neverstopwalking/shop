package com.zzj.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zzj.shop.category.service.CategoryService;
import com.zzj.shop.category.vo.Category;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;


/**
 * ִ����ҳ���ʵ�action
 * @author zhouz
 *
 */

public class IndexAction extends ActionSupport {
	
	private CategoryService categoryService;
		public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
		
		private ProductService productService;
		
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}

		/**
		 * ִ����ҳ���ʵķ���
		 */
	  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		  
		  //��ѯ����һ������ļ���
		  List<Category>categories=categoryService.findAll();
		  
		  //�Ѳ鵽�Ľ���ŵ�session��
		  ActionContext.getContext().getSession().put("categories", categories);
		  
		  //��ѯ������Ʒ
		  List<Product> hList=productService.findHot();
		  
		  //���浽ֵջ��
		  ActionContext.getContext().getValueStack().set("hList", hList);
		  
		  //��ѯ������Ʒ
		  List<Product> nList=productService.findNew();
		  
		  //���浽ֵջ��
		  ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	  
}
