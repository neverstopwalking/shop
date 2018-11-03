package com.zzj.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzj.shop.categorysecond.dao.CategorySecondDao;
import com.zzj.shop.categorysecond.vo.CategorySecond;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

/**
 * ������������ҵ���
 * @author zhouz
 *
 */

@Transactional
public class CategorySecondService {

	
	//ע�������������dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit=5;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount=0;
		totalCount=categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage=0;
		totalPage=(int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//���Ŀ�ʼ
		int begin=(page-1)*limit;
		List<CategorySecond> list=categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
		
	}

	
	  //�����������
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}
   //���ݶ��������ѯ��������ķ���
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}
  
	//ɾ����������ķ���
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}
  //ҵ���޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	
	}
}
