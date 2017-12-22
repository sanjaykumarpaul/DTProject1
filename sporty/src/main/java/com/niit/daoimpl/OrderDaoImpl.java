package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.OrderDao;
import com.niit.model.CategoryModel;
import com.niit.model.OrderModel;


public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory = null;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(OrderModel o) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(o);
		session.getTransaction().commit();

		
	}

	public void update(OrderModel o) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();

		
	}

	public CategoryModel findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CategoryModel Category = session.find(CategoryModel.class,id);
		session.getTransaction().commit();
		return Category;
	}
		
	

	public void delete(OrderModel o) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
		session.close();sessionFactory.openSession().delete(o);
		
		
		
	}

	public List<OrderModel> getAllOrders() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<OrderModel> orderList = session.createQuery("from OrderModel").list();
		session.getTransaction().commit();
		
		return orderList;

		
	}

	
		
		
		
	

}
