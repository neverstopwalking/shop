package com.zzj.shop.category.service;
/**
 * 一级分类的服务层对象
 * @author zhouz
 *
 */

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.category.dao.CategoryDao;
import com.zzj.shop.category.vo.Category;


@Transactional
public class CategoryService {
  private CategoryDao  categoryDao;

public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
}

public List<Category> findAll() {
	// TODO Auto-generated method stub
	return categoryDao.findAll();
}


//保存一级分类的方法
public void save(Category category) {
	// TODO Auto-generated method stub
	 categoryDao.save(category);
}

//根据一级分类id查询一级分类
public Category findByCid(Integer cid) {
	// TODO Auto-generated method stub
	return categoryDao.findByCid(cid);
}

//删除一级分类的方法
public void delete(Category existCategory) {
	// TODO Auto-generated method stub
	categoryDao.delete(existCategory);
}

//修改一级分类的方法
public void update(Category category) {
	// TODO Auto-generated method stub
	categoryDao.update(category);
}
}
