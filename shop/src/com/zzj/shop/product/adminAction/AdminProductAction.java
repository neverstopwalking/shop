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
 * ��̨��Ʒ�����action
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
	//ע����������service
	private CategorySecondService categorySecondService;
   
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	//ע��page����
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//�ļ��ϴ���Ҫ�Ĳ���
	private File upload;//�ϴ����ļ�
	private String uploadFileName;//�ϴ��ļ���
	private String uploadContextType;//�ϴ��ļ�����
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	//��ѯ��Ʒ�ķ���
	public String findAll()
	{
		PageBean<Product> pageBean=productService.findByPage(page);
		
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��ת�����ҳ��ķ���
	public String addPage()
	{
		//��ѯ���ж�������
		List<CategorySecond> csList=categorySecondService.findAll();
		//ͨ��ֵջ��������
		ActionContext.getContext().getValueStack().set("csList", csList);
		//ҳ����ת
		return "addPageSuccess";
	}
	//������Ʒ�ķ���
	public String save() throws IOException
	{
		product.setPdate(new Date());
		if(upload!=null)
		{
			
			String realPath=ServletActionContext.getServletContext().getRealPath("/products");//��þ���·��
			File diskFile=new File(realPath+"//"+uploadFileName);//�ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
			
			
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//ɾ����Ʒ�ķ���
	public String delete()
	{
		//�Ȳ�ѯ��ɾ��
		product=productService.findByPid(product.getPid());
		//ɾ��ͼƬ
		String path=product.getImage();
		if(path!=null)
		{
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
			File file=new File(realPath);
			file.delete();
		}
		//ɾ����Ʒ
		productService.delete(product);
		
		return "deleteSuccess";
	}
	
	//��ת���༭ҳ��
	public String edit()
	{
		//����pid��ѯ��Ʒ
		product=productService.findByPid(product.getPid());
		//��ѯ��������ļ���
		List<CategorySecond> csList=categorySecondService.findAll();
		//�ŵ�ֵջ��
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editSuccess";
	}
	
   //������Ʒ��Ϣ�ķ���
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
