package com.niit.dao;

import java.util.List;

import com.niit.model.SupplierModel;


public interface SupplierDao {
	public void savesupplier(SupplierModel supplier);
	public void delete(SupplierModel supplier);
	public SupplierModel getsupplierbyid(int id);
	public List<SupplierModel> getSupplier();


}
