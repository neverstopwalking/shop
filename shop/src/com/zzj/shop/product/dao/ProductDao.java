package com.zzj.shop.product.dao;
/**
 * 商品持久层代码
 * @author zhouz
 *
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.zzj.shop.product.vo.Product;

public class ProductDao {
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
        //首页上热门商品查询
		public List<Product> findHot() {
			// TODO Auto-generated method stub
			String hql="from Product p where p.is_hot=? order by p.pdate desc";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setString(0, 1+"");
			//分页
			query.setFirstResult(0);
			query.setMaxResults(10);
			
			List<Product> hList=query.list();
			
			return hList;
			
			
		}
		
		//查询最新商品
		public List<Product> findNew() {
			// TODO Auto-generated method stub
			String hql="from Product  order by pdate desc";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			//分页
			query.setFirstResult(0);
			query.setMaxResults(10);
			
			List<Product> nList=query.list();
			return nList;
		}
		
		//根据商品id查询商品
		public Product findByPid(Integer pid) {
			// TODO Auto-generated method stub
			String hql="from Product  where pid=?";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			query.setString(0, pid+"");
			
			List<Product> pList=query.list();
			if(pList.size()>0)
				return pList.get(0);
			else {
				return null;
			}
		}
		
		//根据分类的id查询商品的数目
		public int findCountCid(Integer cid) {
			// TODO Auto-generated method stub
			String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			query.setString(0, cid+"");
			List<Long> list=query.list();
			if(list!=null&&list.size()>0)
				return list.get(0).intValue();
			return 0;
		}
		
		//根据分类的id查询商品集合
		public List<Product> findByPageCid(Integer cid, int begin, int limit) {
			// TODO Auto-generated method stub
			String hql="select  p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setString(0, cid+"");
			query.setFirstResult(begin);
			query.setMaxResults(limit);
			
			List<Product> list=query.list();
			return list;
		}
		
		//根据二级分类查询商品个数
		public int findCountCsid(Integer csid) {
			// TODO Auto-generated method stub
			String hql="select count(*) from Product p where p.categorySecond.csid=?";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setString(0, csid+"");
			List<Long> list=query.list();
			if(list!=null&&list.size()>0)
				return list.get(0).intValue();
			return 0;
			
		}
		
		//根据二级分类id查询商品集合
		public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
			// TODO Auto-generated method stub
			String hql="select  p from Product p join p.categorySecond cs  where cs.csid=?";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setString(0, csid+"");
			query.setFirstResult(begin);
			query.setMaxResults(limit);
			
			List<Product> list=query.list();
			return list;
		}
		
		//查询商品的数目
		public int findCount() {
			// TODO Auto-generated method stub
			String hql="select count(*) from Product";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
		
			List<Long> list=query.list();
			if(list!=null&&list.size()>0)
				return list.get(0).intValue();
			return 0;
		
		}
		
		//分页查询商品集合
		public List<Product> findByPage(int begin, int limit) {
			// TODO Auto-generated method stub
			String hql=" from Product order by pdate desc ";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			query.setFirstResult(begin);
			query.setMaxResults(limit);
			
			List<Product> list=query.list();
			return list;
		}
		//保存商品的方法
		public void save(Product product) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			session.save(product);
		}
		public void delete(Product product) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			session.delete(product);
		}
		public void update(Product product) {
			// TODO Auto-generated method stub
			
			Session session=sessionFactory.getCurrentSession();
			session.update(product);
		}
		
}
