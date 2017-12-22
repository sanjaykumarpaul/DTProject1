package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ProductDao;
import com.niit.model.ProductModel;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	
	SessionFactory sessionFactory = null;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProductmodel(ProductModel productmodel) {
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.persist(productmodel);
		session.getTransaction().commit();

		
	}

	public List<ProductModel> getproducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductModel>ProductModelList = session.createQuery("from ProductModel").list();
		session.getTransaction().commit();
		session.close();
		return ProductModelList;
	
	
	}

	public void delete(ProductModel productmodel) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(productmodel);
		session.getTransaction().commit();
		session.close();

		
	}

	public ProductModel getProductDetail(int pid) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductModel product = (ProductModel) session.get(ProductModel.class, pid);
		
	
		session.getTransaction().commit();
		session.close();
		return product;
	}

	public List<ProductModel> getproductsbycategoryid(int categoryid) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ProductModel> categorylistid = session.createQuery("from ProductModel where categoryid = "+categoryid).list();
		session.getTransaction().commit();
	
		return categorylistid;

	}

}
