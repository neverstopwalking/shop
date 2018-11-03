package com.zzj.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.zzj.shop.product.dao.ProductDao;
import com.zzj.shop.product.vo.Product;
import com.zzj.shop.utils.PageBean;

/**
 * 商品的业务层
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
			//根据id查询商品
		public Product findByPid(Integer pid) {
			// TODO Auto-generated method stub
			return productDao.findByPid(pid);
		}

		public PageBean<Product> findByPageCid(Integer cid, int page) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			//设置当前页数
			pageBean.setPage(page);
			//设置每页显示的记录数
			int limit=8;
			pageBean.setLimit(limit);
			//设置总的记录数
			int totalCount=0;
			totalCount=productDao.findCountCid(cid);
			pageBean.setTotalCount(totalCount);
			//设置总的页数
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//每页显示的数据集合
			//从哪开始
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPageCid(cid,begin,limit);
			pageBean.setList(list);
			return pageBean;
			
			
			
		}
			//根据二级分类查询商品信息
		public PageBean<Product> findByPageCsid(int page, Integer csid) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			//设置当前页数
			pageBean.setPage(page);
			//设置每页显示的记录数
			int limit=8;
			pageBean.setLimit(limit);
			//设置总的记录数
			int totalCount=0;
			totalCount=productDao.findCountCsid(csid);
			pageBean.setTotalCount(totalCount);
			//设置总的页数
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//每页显示的数据集合
			//从哪开始
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPageCsid(csid,begin,limit);
			pageBean.setList(list);
			return pageBean;
		}

		public PageBean<Product> findByPage(Integer page) {
			// TODO Auto-generated method stub
			PageBean<Product> pageBean=new PageBean<Product>();
			
			//设置当前页数
			pageBean.setPage(page);
			//设置每页显示的记录数
			int limit=8;
			pageBean.setLimit(limit);
			//设置总的记录数
			int totalCount=0;
			totalCount=productDao.findCount();
			pageBean.setTotalCount(totalCount);
			//设置总的页数
			int totalPage=0;
			totalPage=(int) Math.ceil(totalCount/limit);
			pageBean.setTotalPage(totalPage);
			//每页显示的数据集合
			//从哪开始
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
			
		}
		//保存商品
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
