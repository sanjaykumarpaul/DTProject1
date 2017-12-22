package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.SupplierDao;
import com.niit.model.SupplierModel;

public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	SessionFactory sessionFactory = null;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savesupplier(SupplierModel supplier) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();
		
	}

	public void delete(SupplierModel supplier) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();sessionFactory.openSession().delete(supplier);
		
		
	}

	public SupplierModel getsupplierbyid(int id) {
	
        Session session = sessionFactory.openSession();
 		 session.beginTransaction();
 		SupplierModel supplier = session.get(SupplierModel.class,id);
		session.getTransaction().commit();
		return supplier;

	}

	public List<SupplierModel> getSupplier() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<SupplierModel> supplierList = session.createQuery("from SupplierModel").list();
		session.getTransaction().commit();
		
		return supplierList;

		
	}

}
