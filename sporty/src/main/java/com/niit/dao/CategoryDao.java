package com.niit.dao;

import java.util.List;

import com.niit.model.CategoryModel;

public interface CategoryDao {
	public void savecategory(CategoryModel category);
	public List<CategoryModel> getCategories();
	public boolean delete(CategoryModel  category);
	public CategoryModel  getcategorybyid(int id);

}



