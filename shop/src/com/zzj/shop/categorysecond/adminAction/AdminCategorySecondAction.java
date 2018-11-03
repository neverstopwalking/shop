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
 * 后台二级分类管理的action
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
	//注入二级分类的service
	
    private  CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	//注入一级分类service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	//查询二级分类的方法
	public String findAll()
	{
		PageBean<CategorySecond>pageBean=categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	
	//二级分类添加页面
  public String addPage()
  {
	  //查询所有的一级分类
	  List<Category> cList=categoryService.findAll();
	  //存放到值栈中
	  ActionContext.getContext().getValueStack().set("cList", cList);
	  
	  return "addPageSuccess";
	  
	  
	  
  }
  
  
 //保存二级分类的方法
  public String save()
  {
	  categorySecondService.save(categorySecond);
	  return "saveSuccess";
  }
  
  //删除二级分类的方法
  public String delete()
  {
	  categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
	  categorySecondService.delete(categorySecond);
	  return "deleteSuccess";
  }
  
  //编辑二级分类的页面
  public String edit()
  {
	  //根据二级分类id查询二级分类
	  categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
	  //查询所有一级分类
	  List<Category> cList=categoryService.findAll();
	  ActionContext.getContext().getValueStack().set("cList", cList);
	  return "editSuccess";
  }
  
  //修改二级分类的方法
  public String update()
  {
	  categorySecondService.update(categorySecond);
	  return "updateSuccess";
  }
	
}
