package fr.amu.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.amu.beans.Product;

// à remplir
// implémente l'interface ProductDAO
// aura les annotations @Transactional et @Repository
// Jdbctemplate sera injecté en @Autowired

@Transactional // évite d'avoir àgérer les transactions
@Repository // indique àspring qu'il s'agit d'un accès BDD
public class ProductDAOImpl implements ProductDAO{

	
	
	@Autowired // injection de dépendance pour un jdbctemplate global récupérant ses paramètres dans src/main/resources/application.properties
	JdbcTemplate jbdc;
	
	@Override
	public void add(Product product) {

		String sql = "INSERT INTO products(category,productTitle,description) values(?,?,?)";
		jbdc.update(sql, product.getCategory(), product.getTitle(), product.getDescription());
	}

	@Override
	public void update(Product product) {
		String sql = "UPDATE products SET category = ?, productTitle = ?, description = ?";
		jbdc.update(sql,product.getCategory(), product.getTitle(), product.getDescription());	
	}

	@Override
	public void delete(Product product) {
		String sql = "DELETE FROM products where id = ?";
		jbdc.update(sql,product.getId());
	}

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM products";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.query(sql, rowMapper);
	}

	@Override
	public Product findById(Integer id) {
		String sql = "SELECT * FROM products where id = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.queryForObject(sql, rowMapper,id); //queryForObject pour un seul objet
	}

	@Override
	public List<Product> findByCategory(String category) {
		String sql = "SELECT * FROM products where category = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.query(sql, rowMapper,category); //queryForObject pour une liste des  objet
	}

	
	
	
}