package com.zzj.shop.product.adminAction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.categorysecond.service.CategorySecondService;
import com.zzj.shop.categorysecond.vo.CategorySecond;
import com.zzj.shop.product.service.ProductService;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

/**
 * 后台商品管理的action
 * @author zhouz
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
  private Product product=new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注入二级分类的service
	private CategorySecondService categorySecondService;
   
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	//注入page参数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//文件上传需要的参数
	private File upload;//上传的文件
	private String uploadFileName;//上传文件名
	private String uploadContextType;//上传文件类型
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	//查询商品的方法
	public String findAll()
	{
		PageBean<Product> pageBean=productService.findByPage(page);
		
		//放入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//跳转到添加页面的方法
	public String addPage()
	{
		//查询所有二级分类
		List<CategorySecond> csList=categorySecondService.findAll();
		//通过值栈保存数据
		ActionContext.getContext().getValueStack().set("csList", csList);
		//页面跳转
		return "addPageSuccess";
	}
	//保存商品的方法
	public String save() throws IOException
	{
		product.setPdate(new Date());
		if(upload!=null)
		{
			
			String realPath=ServletActionContext.getServletContext().getRealPath("/products");//获得绝对路径
			File diskFile=new File(realPath+"//"+uploadFileName);//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
			
			
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//删除商品的方法
	public String delete()
	{
		//先查询再删除
		product=productService.findByPid(product.getPid());
		//删除图片
		String path=product.getImage();
		if(path!=null)
		{
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
			File file=new File(realPath);
			file.delete();
		}
		//删除商品
		productService.delete(product);
		
		return "deleteSuccess";
	}
	
	//跳转到编辑页面
	public String edit()
	{
		//根据pid查询商品
		product=productService.findByPid(product.getPid());
		//查询二级分类的集合
		List<CategorySecond> csList=categorySecondService.findAll();
		//放到值栈中
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editSuccess";
	}
	
   //更新商品信息的方法
	public String update() throws IOException
	{
		product.setPdate(new Date());
		if(upload!=null)
		{
			String path=product.getImage();
			File file=new File(ServletActionContext.getServletContext().getRealPath("/"+path));
			file.delete();
			String realPath=ServletActionContext.getServletContext().getRealPath("/products");
			File diskfile=new File(realPath+"//"+uploadFileName);
			FileUtils.copyFile(upload, diskfile);
			product.setImage("products/"+uploadFileName);
			
		}
		productService.update(product);
		return "updateSuccess";
	}
}
