package com.zzj.shop.categorysecond.adminAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.category.service.CategoryService;
import com.zzj.shop.category.vo.Category;
import com.zzj.shop.categorysecond.service.CategorySecondService;
import com.zzj.shop.categorysecond.vo.CategorySecond;
import com.zzj.shop.utils.PageBean;

/**
 * ��̨������������action
 * @author zhouz
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{

	
	private CategorySecond categorySecond=new CategorySecond();
	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	//ע����������service
	
    private  CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//ע��һ������service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	//��ѯ��������ķ���
	public String findAll()
	{
		PageBean<CategorySecond>pageBean=categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	
	//�����������ҳ��
  public String addPage()
  {
	  //��ѯ���е�һ������
	  List<Category> cList=categoryService.findAll();
	  //��ŵ�ֵջ��
	  ActionContext.getContext().getValueStack().set("cList", cList);
	  
	  return "addPageSuccess";
	  
	  
	  
  }
  
  
 //�����������ķ���
  public String save()
  {
	  categorySecondService.save(categorySecond);
	  return "saveSuccess";
  }
  
  //ɾ����������ķ���
  public String delete()
  {
	  categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
	  categorySecondService.delete(categorySecond);
	  return "deleteSuccess";
  }
  
  //�༭���������ҳ��
  public String edit()
  {
	  //���ݶ�������id��ѯ��������
	  categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
	  //��ѯ����һ������
	  List<Category> cList=categoryService.findAll();
	  ActionContext.getContext().getValueStack().set("cList", cList);
	  return "editSuccess";
  }
  
  //�޸Ķ�������ķ���
  public String update()
  {
	  categorySecondService.update(categorySecond);
	  return "updateSuccess";
  }
	
}
