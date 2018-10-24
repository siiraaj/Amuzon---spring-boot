package fr.amu.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.amu.beans.Product;
import fr.amu.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest req, Map<String,Object> model) {
		
		Product produit = new Product();
		produit.setCategory(req.getParameter("Category"));
		produit.setDescription(req.getParameter("description"));
		produit.setTitle(req.getParameter("title"));
		
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
	
	@PostMapping("/category")
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

