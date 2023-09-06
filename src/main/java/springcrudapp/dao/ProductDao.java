package springcrudapp.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	 private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product) {
		 System.out.println("product"+product);
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	public List<Product> getProducts() {
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void delete(int id) {
		Product p=this.hibernateTemplate.load(Product.class,id);
		System.out.println("delet"+p);
		this.hibernateTemplate.delete(p);
	}
	
	@Transactional
	public Product getProduct(int id) {
		 Product p=this.hibernateTemplate.load(Product.class,id);
		  
		 System.out.println("Getting product"+p);
		return p;
	}


	@Transactional
	public void updateProject(Product p) {
		  hibernateTemplate.update(p);
		 System.out.println("Getting product"+p);

	}

	
	 
}
