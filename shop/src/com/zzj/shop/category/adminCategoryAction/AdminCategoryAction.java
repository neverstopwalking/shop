package com.zzj.shop.category.adminCategoryAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.category.service.CategoryService;
import com.zzj.shop.category.vo.Category;


/**
 * ��̨һ����������action
 * @author zhouz
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category=new Category();
    
    //ע��categoryService
    private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	
	//��ѯ����һ������ķ���
	public String findAll()
	{
		List<Category> cList=categoryService.findAll();
		
		//���ҵ������ݷ���ֵջ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//����һ������ķ���
	public String save()
	{
		categoryService.save(category);
		//ҳ����ת
		return "saveSuccess";
	}
	
	//ɾ��һ������ķ���
	public String delete()
	{
		 category=categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		
		return "deleteSuccess";
	}
	
	//��̨�༭һ������ķ���
	public String edit()
	{
		category=categoryService.findByCid(category.getCid());
		
		//ҳ����ת
		return "editSuccess";
	}
	
	//��̨�޸�һ������ķ���
	public String update()
	{
		categoryService.update(category);
		
		return "updateSuccess";
	}

}
