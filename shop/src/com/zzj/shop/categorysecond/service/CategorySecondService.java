package com.zzj.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.categorysecond.dao.CategorySecondDao;
import com.zzj.shop.categorysecond.vo.CategorySecond;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

/**
 * 二级分类管理的业务层
 * @author zhouz
 *
 */

@Transactional
public class CategorySecondService {

	
	//注入二级分类管理的dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit=5;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount=0;
		totalCount=categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage=0;
		totalPage=(int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪开始
		int begin=(page-1)*limit;
		List<CategorySecond> list=categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
		
	}

	
	  //保存二级分类
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}
   //根据二级分类查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}
  
	//删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}
  //业务处修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	
	}
}
