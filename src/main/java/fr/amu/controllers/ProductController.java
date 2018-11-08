package fr.amu.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.amu.Application;
import fr.amu.beans.Product;
import fr.amu.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest req, Map<String,Object> model) {
		

		Product produit = new Product();
		produit.setCategory(req.getParameter("cat"));
		produit.setDescription(req.getParameter("desc"));
		produit.setTitle(req.getParameter("tit"));
		
		ps.addProduct(produit);
		model.put("products", ps.getProducts());	
		return"homepage";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam(value="productId") int id,Map<String,Object> model) {
		
		ps.removeProduct(id);
		model.put("products", ps.getProducts());
		return"homepage";		
	}
	
	@RequestMapping("/category")
	public String category(@RequestParam(value ="name") String category, Map<String, Object> model)
	
	{
		if (category.equals("all"))
		{
			model.put("products", ps.getProducts());
		}
		else
		{
			model.put("products", ps.getCategoryProducts(category));
		}
		
		return "homepage";
	}
}

