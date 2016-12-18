package com.sample.product.controller;

//import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.entity.Account;
import com.sample.product.entity.Customer;
import com.sample.product.entity.Product;
import com.sample.product.entity.ShoppingCart;
import com.sample.product.entity.ShoppingCart2;
import com.sample.product.dao.CustomerDAO;
import com.sample.product.dao.ProductDAO;
import com.sample.product.dao.ProductDAODB;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("product");
		return model;
	}//getProductList
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ModelAndView shoppingcart(){
		ModelAndView model = new ModelAndView("shoppingcart");
		ShoppingCart dao = (ShoppingCart) context.getBean("shoppingCart");
		List<Product> list = dao.getCart();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProductList(){
		ModelAndView model = new ModelAndView("product");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		
		model.addObject(list);
		return model;
	}//getProductList
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		return getProductList();
	}//getProductList
	//list all products	
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView manager(){
		ModelAndView model = new ModelAndView("manager");
		return model;
	}//getProductList
	
	@RequestMapping(value = "/productcon", method = RequestMethod.POST)
	public ModelAndView productcon(){
		ModelAndView model = new ModelAndView("productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/productcon", method = RequestMethod.GET)
	public ModelAndView productconUser(){
		ModelAndView model = new ModelAndView("productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/productcus", method = RequestMethod.POST)
	public ModelAndView productcus(){
		ModelAndView model = new ModelAndView("productcus");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}//getProductList
	
	@RequestMapping(value = "/productcus", method = RequestMethod.GET)
	public ModelAndView productcusUser(){
		ModelAndView model = new ModelAndView("productcus");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}//getProductList
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage(){
		ModelAndView model = new ModelAndView("insertProduct");
		return model;
	}//insertProductPage
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/productcon");	
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product.setId(dao.count());
		dao.insert(product);
		return model;
	}//insertProduct
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute Product product, long id){
		ModelAndView model = new ModelAndView("redirect:/productcon");	
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product.setId(dao.count());
		dao.delete(id);
		return model;
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public ModelAndView updateproductpage(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("updateproduct");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product = dao.get(product.getId());
		model.addObject("product", product);
		return model;
	}//insertProductPage

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView modify(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/productcon");	
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		//product.setId(dao.count());
		dao.update(product);
		
		return model;
	}//insertProduct
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute Account account, Customer man) {
		ModelAndView model = new ModelAndView("redirect:/product");	
		Account account_session = (Account)context.getBean("account");
		CustomerDAO dao = (CustomerDAO)context.getBean("managerDAO");
		if(account.getName().equals("sa") && account.getPassword().equals("12345")){
			System.out.println("SuccessManager");
			model = new ModelAndView("redirect:/manager");
		}else{
			if(account.getName().equals(dao.get(account.getName()).getAccount()) && account.getPassword().equals(dao.get(account.getName()).getPassword())){
				account_session.setName(account.getName());
				System.out.println("SuccessCustomer");
				model = new ModelAndView("redirect:/productcus");
			}
			else{
				account_session.setName("");
				System.out.println("failed");
				model = new ModelAndView("redirect:/product");
				
				}	
		}
		//System.out.println("model:"+account.getUsername());
		//System.out.println("session:"+account_session.getName());
		
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute Product product, Account account){
		ModelAndView model = new ModelAndView("redirect:/productcus");	
		
		ShoppingCart shoppingcart = (ShoppingCart)context.getBean("shoppingCart");
		ShoppingCart2 shoppingcart2 = (ShoppingCart2)context.getBean("shoppingCart2");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		shoppingcart.add(dao.get(product.getId()));
		shoppingcart2.add(dao.get(product.getId()));
		return model;
	}//insertProduct

	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public ModelAndView uploadFile(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product = dao.get(product.getId());
		long id = product.getId();
		System.out.println(id);
		model.addObject("product", product);
		return model;
	}
	
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadFileHandler(@ModelAttribute("file") MultipartFile file, HttpServletRequest request, Product product,long id) {
    	ModelAndView model = new ModelAndView("redirect:/productcon");
    	ProductDAO dao = (ProductDAO) context.getBean("productDAO");
    	//save it as the file name submitted 
    	//String name = file.getOriginalFilename();
    	product = dao.get(product.getId());
		id = product.getId();
    	//System.out.println();
    	String name = Long.toString(id);
        String filePath = request.getSession().getServletContext().getRealPath("/") + "resources\\fileUpload\\";  
    	//
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        try {
            file.transferTo(new File(filePath+name+".jpg"));
            System.out.println("Server File Location="+ filePath+name+product.getReorderPoint());
            model.addObject("message",product.getId());
        } catch (IOException e) {
        	model.addObject("message","You failed to upload:" + file.getOriginalFilename() + " => " + e.getMessage());
            e.printStackTrace();
        }
        return model;
    }
	
    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView newuser(){
		ModelAndView model = new ModelAndView("newuser");
		return model;
	}
    
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public ModelAndView newuser(@ModelAttribute Customer manager){
		ModelAndView model = new ModelAndView("redirect:productcus");	
		CustomerDAO dao = (CustomerDAO) context.getBean("managerDAO");
		manager.setId(dao.count());
		dao.insert(manager);
		return model;
	}
    
	@RequestMapping(value = "/deleteShoppingcart", method = RequestMethod.GET)
	public ModelAndView deleteShoppingcart(@ModelAttribute Product product, long id){
		ModelAndView model = new ModelAndView("redirect:/shoppingcart");	
		ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product.setId(dao.count());
		dao.delete(id);
		return model;
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(){
		ModelAndView model = new ModelAndView("redirect:/search");
		return model;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute ("search") String str,@ModelAttribute("searchmethod") String searchmethod){
		ModelAndView model = new ModelAndView("product");
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		String sql = "SELECT * FROM product WHERE " + searchmethod + " LIKE '%"+str+"%'";
		List<Product> sqllist = dao.getList(sql);
		model.addObject(("productList"),sqllist);
		return model;
	}
	
	@RequestMapping(value = "/see", method = RequestMethod.GET)
	public ModelAndView see(@ModelAttribute ("class") String str){
		ModelAndView model = new ModelAndView("product");
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		String sql = "SELECT * FROM product WHERE Category LIKE '%"+str+"%'";
		List<Product> sqllist = dao.getList(sql);
		model.addObject(("productList"),sqllist);
		return model;
	}
	
	@RequestMapping(value = "/seepub", method = RequestMethod.GET)
	public ModelAndView seepub(@ModelAttribute ("class2") String str){
		ModelAndView model = new ModelAndView("product");
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		String sql = "SELECT * FROM product WHERE publisher LIKE '%"+str+"%'";
		List<Product> sqllist = dao.getList(sql);
		model.addObject(("productList"),sqllist);
		return model;
	}//ProductController


}
