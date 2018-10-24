package fr.amu.controllers;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.amu.services.ProductService;

// à remplir
// aura l'annotation @Controller
@Controller
public class IndexController{
	
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homepage() {
		return"homepage";
	}
	
	public String index(Map<String, Object> model) {
		String sessionUser= (String) httpSession.getAttribute("user");
		model.put("products", ps.getProducts() );
		System.out.println("session user = " + sessionUser);
		return "homepage";
		}
	
	
	
}