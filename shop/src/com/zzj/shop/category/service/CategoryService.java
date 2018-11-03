package com.zzj.shop.category.service;
/**
 * һ������ķ�������
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


//����һ������ķ���
public void save(Category category) {
	// TODO Auto-generated method stub
	 categoryDao.save(category);
}

//����һ������id��ѯһ������
public Category findByCid(Integer cid) {
	// TODO Auto-generated method stub
	return categoryDao.findByCid(cid);
}

//ɾ��һ������ķ���
public void delete(Category existCategory) {
	// TODO Auto-generated method stub
	categoryDao.delete(existCategory);
}

//�޸�һ������ķ���
public void update(Category category) {
	// TODO Auto-generated method stub
	categoryDao.update(category);
}
}
