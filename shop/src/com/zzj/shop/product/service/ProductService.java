package com.zzj.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.zzj.shop.product.dao.ProductDao;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

/**
 * ��Ʒ��ҵ���
 * @author zhouz
 *
 */
@Transactional
public class ProductService {
		private ProductDao productDao;

		public void setProductDao(ProductDao productDao) {
			this.productDao = productDao;
		}

		public List<Product> findHot() {
			// TODO Auto-generated method stub
			return productDao.findHot();
		}

		public List<Product> findNew() {
			// TODO Auto-generated method stub
			return productDao.findNew();
		}
			//����id��ѯ��Ʒ
		public Product findByPid(Integer pid) {
			// TODO Auto-generated method stub
			return productDao.findByPid(pid);
		}

		public PageBean<Product> findByPageCid(Integer cid, int page) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			//���õ�ǰҳ��
			pageBean.setPage(page);
			//����ÿҳ��ʾ�ļ�¼��
			int limit=8;
			pageBean.setLimit(limit);
			//�����ܵļ�¼��
			int totalCount=0;
			totalCount=productDao.findCountCid(cid);
			pageBean.setTotalCount(totalCount);
			//�����ܵ�ҳ��
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//ÿҳ��ʾ�����ݼ���
			//���Ŀ�ʼ
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPageCid(cid,begin,limit);
			pageBean.setList(list);
			return pageBean;
			
			
			
		}
			//���ݶ��������ѯ��Ʒ��Ϣ
		public PageBean<Product> findByPageCsid(int page, Integer csid) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			//���õ�ǰҳ��
			pageBean.setPage(page);
			//����ÿҳ��ʾ�ļ�¼��
			int limit=8;
			pageBean.setLimit(limit);
			//�����ܵļ�¼��
			int totalCount=0;
			totalCount=productDao.findCountCsid(csid);
			pageBean.setTotalCount(totalCount);
			//�����ܵ�ҳ��
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//ÿҳ��ʾ�����ݼ���
			//���Ŀ�ʼ
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPageCsid(csid,begin,limit);
			pageBean.setList(list);
			return pageBean;
		}

		public PageBean<Product> findByPage(Integer page) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			
			//���õ�ǰҳ��
			pageBean.setPage(page);
			//����ÿҳ��ʾ�ļ�¼��
			int limit=8;
			pageBean.setLimit(limit);
			//�����ܵļ�¼��
			int totalCount=0;
			totalCount=productDao.findCount();
			pageBean.setTotalCount(totalCount);
			//�����ܵ�ҳ��
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//ÿҳ��ʾ�����ݼ���
			//���Ŀ�ʼ
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
			
		}
		//������Ʒ
		public void save(Product product) {
			// TODO Auto-generated method stub
			productDao.save(product);
		}

		public void delete(Product product) {
			// TODO Auto-generated method stub
			productDao.delete(product);
		}

		public void update(Product product) {
			// TODO Auto-generated method stub
			productDao.update(product);
		}
		
}
