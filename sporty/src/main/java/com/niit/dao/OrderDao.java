package com.niit.dao;

import java.util.List;

import com.niit.model.CategoryModel;
import com.niit.model.OrderModel;

public interface OrderDao {
	 public void persist(OrderModel o);
		
		public void update(OrderModel o);
		
		public CategoryModel  findById(int id);
		
		public void delete(OrderModel o);
		
		public List<OrderModel> getAllOrders();
		
		
	

}
