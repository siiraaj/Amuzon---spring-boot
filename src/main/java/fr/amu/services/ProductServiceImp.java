package fr.amu.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.Application;
import fr.amu.beans.Product;
import fr.amu.models.ProductDAO;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductDAO dao;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Override
	public void addProduct(Product product) {
		dao.add(product);
	}

	@Override
	public Product getProduct(int id) {
		return dao.findById(id);
	}

	@Override
	public void removeProduct(int id) {
		dao.delete(dao.findById(id));
	}

	@Override
	public List<Product> getProducts() {
		return dao.findAll();
	}

	@Override
	public List<Product> getCategoryProducts(String category) {
		return dao.findByCategory(category);
	}

}
