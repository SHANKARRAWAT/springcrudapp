package springcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springcrudapp.dao.ProductDao;
import springcrudapp.model.Product;

@Controller
@ComponentScan(basePackages ="springcrudapp.dao")
//@RequestMapping("/**")
public class HomeController {

@Autowired
private ProductDao productDao;


@RequestMapping("/")
 public String home(Model m) {
	System.out.println("helloo its index");
	List<Product> products=productDao.getProducts();
	System.out.println(products);
	m.addAttribute("products", products);
	 return "index";
 }
 
 @RequestMapping("/addproduct")
 public String addproduct() {
	 
	 return "add_product_form";
	 
 }
 
 @RequestMapping(path="/handleproject",method=RequestMethod.POST)
 
 public RedirectView handleProject(@ModelAttribute("Product") Product product,HttpServletRequest request) {
	 RedirectView rv=new RedirectView();
	 System.out.println(product);
	 
	 productDao.createProduct(product);
	 rv.setUrl(request.getContextPath()+"/");
	 return rv;
 }
 
@RequestMapping(path="/handleupdateproject",method=RequestMethod.POST)
 public RedirectView handleUpdateProject(@ModelAttribute("Product") Product product,HttpServletRequest request) {
	 RedirectView rv=new RedirectView();
	 System.out.println(product);
	 
	 productDao.updateProject(product);
	 
	 rv.setUrl(request.getContextPath()+"/");
	 return rv;
 }
 
 @RequestMapping("/delete/{id}")
 public RedirectView delete(@PathVariable("id") int id,HttpServletRequest request) {
	 productDao.delete(id);
	 RedirectView rv=new RedirectView();
	 rv.setUrl(request.getContextPath()+"/");
	 System.out.println("deleted");
	 return rv;
	 
 }
 
 @RequestMapping("/update/{id}")
  public String update(@PathVariable("id") int id,Model model) {

	 Product p= productDao.getProduct(id);
	 
	 System.out.println("update"+p);
	 model.addAttribute("product", p);
	 return "update_form";
  }
 
}
