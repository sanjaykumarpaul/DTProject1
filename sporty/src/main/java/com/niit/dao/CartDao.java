package com.niit.dao;

import java.util.List;

import com.niit.model.CartModel;

public interface CartDao {
	public void addToCart(CartModel cart);
	public boolean updateCart(CartModel cart);
	public boolean deleteCart(CartModel cart);
	public CartModel getCartItem(int cartItemId);
	public List<CartModel>getCartItems(String email);
	public List<CartModel> checkExistance(int id);
	public void save(CartModel g);
	public CartModel findById(int cartItemId);
	public List<CartModel> getAll();
	public CartModel getId(int cid);
	public CartModel getCartItem(int pid, String userId);
	public Object getCartById(String userId);
	
	

}
