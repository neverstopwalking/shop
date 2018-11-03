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
	
	//������Ʒid��ѯ��Ʒ
	public String findByPid()
	{
		produt=productService.findByPid(produt.getPid());
		return "findByPid";
	}
	//����һ�������id��ѯ���ж�������
	   public String findByCid()
	   {
		   
		   PageBean <Product>pageBean= productService.findByPageCid(cid,page);//����һ�������ҳ��ѯ��Ʒ
		   //��pagebean�ŵ�ֵջ��
		   ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		   return "findByCid";
	   }
	   
	   //���ݶ��������ѯ��Ʒ
	   public String findByCsid()
	   {
		   //���ݶ��������ҳ��ѯ��Ʒ
		   PageBean<Product> pageBean=productService.findByPageCsid(page,csid);
		   //��pagebean�ŵ�ֵջ��
		   ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		   
		   return "findByCsid";
	   }

}
