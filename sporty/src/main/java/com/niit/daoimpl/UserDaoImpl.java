package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	
	

	private static final List<UserModel> UsermodelList = null;
	private SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean addUser(UserModel user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		return false;
	}



	public boolean deleteUser(UserModel user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		
		
		return false;
	}



	public UserModel get(String email) {
		// TODO Auto-generated method stub
		UserModel UserModel= (UserModel) sessionFactory.getCurrentSession().get(UserModel.class, new String(email));
		return UserModel;			
		 
	}

		



	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<UserModel>UserModelList = session.createQuery("from UserModel").list();
		session.getTransaction().commit();
		session.close();
		return UserModelList;
	
	}

		



	public void persist(UserModel user) {
		// TODO Auto-generated method stub
		
	}



	public UserModel getUserDetail(String userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserModel UserModel = (UserModel) session.get(UserModel.class, userId);
		
	
		session.getTransaction().commit();
		session.close();
		return UserModel;
	
	}

	
}

