package com.zzj.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private Product produt=new Product();
	private ProductService productService;
	private Integer cid;
	private int page;
	private Integer csid;
	 
	 

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return NONE;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return produt;
	}
	
	//根据商品id查询商品
	public String findByPid()
	{
		produt=productService.findByPid(produt.getPid());
		return "findByPid";
	}
	//根据一级分类的id查询所有二级分类
	   public String findByCid()
	   {
		   
		   PageBean <Product>pageBean= productService.findByPageCid(cid,page);//根据一级分类分页查询商品
		   //将pagebean放到值栈中
		   ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		   return "findByCid";
	   }
	   
	   //根据二级分类查询商品
	   public String findByCsid()
	   {
		   //根据二级分类分页查询商品
		   PageBean<Product> pageBean=productService.findByPageCsid(page,csid);
		   //将pagebean放到值栈中
		   ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		   
		   return "findByCsid";
	   }

}
