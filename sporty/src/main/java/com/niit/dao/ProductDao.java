package com.niit.dao;

import java.util.List;

import com.niit.model.ProductModel;

public interface ProductDao {
	public void saveProductmodel(ProductModel productmodel);
	public List<ProductModel>getproducts();
	public void delete(ProductModel productmodel);

	public ProductModel getProductDetail(int pid);
	public List<ProductModel> getproductsbycategoryid(int categoryid);

}



