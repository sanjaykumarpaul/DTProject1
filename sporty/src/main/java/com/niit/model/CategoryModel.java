package com.niit.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoryModel {
	@Id
	private int categoryId;
	private String categoryName;

	@OneToMany(mappedBy = "prodCategory",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<ProductModel> categoryProducts=new HashSet<ProductModel>(0);
	public CategoryModel()
	{
		
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<ProductModel> getCategoryProducts() {
		return categoryProducts;
	}
	public void setCategoryProducts(Set<ProductModel> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}
}
