package com.zzj.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zzj.shop.category.service.CategoryService;
import com.zzj.shop.category.vo.Category;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;


/**
 * 执行首页访问的action
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
		 * 执行首页访问的方法
		 */
	  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		  
		  //查询所有一级分类的集合
		  List<Category>categories=categoryService.findAll();
		  
		  //把查到的结果放到session中
		  ActionContext.getContext().getSession().put("categories", categories);
		  
		  //查询热门商品
		  List<Product> hList=productService.findHot();
		  
		  //保存到值栈中
		  ActionContext.getContext().getValueStack().set("hList", hList);
		  
		  //查询最新商品
		  List<Product> nList=productService.findNew();
		  
		  //保存到值栈中
		  ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	  
}
