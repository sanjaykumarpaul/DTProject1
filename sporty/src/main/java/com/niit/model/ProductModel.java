package com.niit.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductModel {
@Id
	
	private int id;
	private String name;
    private String description;
    private double price;
    private int quantity;
    private String pImage;
    @ManyToOne
    @JoinColumn(name = "categoryId")
	private CategoryModel prodCategory;
    
	@ManyToOne
    @JoinColumn(name = "supplierId")
	private SupplierModel prodSupplier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public CategoryModel getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(CategoryModel prodCategory) {
		this.prodCategory = prodCategory;
	}

	public SupplierModel getProdSupplier() {
		return prodSupplier;
	}

	public void setProdSupplier(SupplierModel prodSupplier) {
		this.prodSupplier = prodSupplier;
	}


   
    
}
