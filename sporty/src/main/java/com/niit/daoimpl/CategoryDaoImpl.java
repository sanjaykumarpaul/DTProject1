package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.CategoryDao;
import com.niit.model.CategoryModel;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory = null;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



public void savecategory(CategoryModel category) {
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.persist(category);
	session.getTransaction().commit();

	
}
public List<CategoryModel> getCategories() {

	Session session = sessionFactory.openSession();
	session.beginTransaction();
	List<CategoryModel> categoryList = session.createQuery("from CategoryModel").list();
	session.getTransaction().commit();
	
	return categoryList;

}
public boolean delete(CategoryModel category) {
	
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.delete(category);
	session.getTransaction().commit();
	session.close();sessionFactory.openSession().delete(category);
	return false;
}
public CategoryModel getcategorybyid(int id) {
	
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	CategoryModel Category = session.get(CategoryModel.class,id);
	session.getTransaction().commit();
	return Category;
}
}