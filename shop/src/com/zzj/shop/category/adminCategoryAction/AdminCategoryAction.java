package com.zzj.shop.category.adminCategoryAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.category.service.CategoryService;
import com.zzj.shop.category.vo.Category;


/**
 * 后台一级分类管理的action
 * @author zhouz
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
    private Category category=new Category();
    
    //注入categoryService
    private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	
	//查询所有一级分类的方法
	public String findAll()
	{
		List<Category> cList=categoryService.findAll();
		
		//将找到的数据放入值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//保存一级分类的方法
	public String save()
	{
		categoryService.save(category);
		//页面跳转
		return "saveSuccess";
	}
	
	//删除一级分类的方法
	public String delete()
	{
		 category=categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		
		return "deleteSuccess";
	}
	
	//后台编辑一级分类的方法
	public String edit()
	{
		category=categoryService.findByCid(category.getCid());
		
		//页面跳转
		return "editSuccess";
	}
	
	//后台修改一级分类的方法
	public String update()
	{
		categoryService.update(category);
		
		return "updateSuccess";
	}

}
