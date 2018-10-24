package fr.amu.services;

import java.util.List;

import fr.amu.beans.Product;

public interface ProductService {

	void addProduct(Product product);
	Product getProduct(int id);
	void removeProduct(int id);
	List<Product> getProducts();
	List<Product> getCategoryProducts(String category);	
}
