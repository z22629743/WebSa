package com.sample.product.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.dao.SalesOrderDAO;
import com.sample.product.dao.ProductDAO;
import com.sample.product.dao.PurchaseOrderDAO;
import com.sample.product.entity.Product;
import com.sample.product.entity.Salesout;
import com.sample.product.entity.ShoppingCart;
import com.sample.product.entity.ShoppingCart2;


@Controller
public class SalesOrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	
	
	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public ModelAndView showShoppingCart(){
		ModelAndView model = new ModelAndView("shoppingcart");
		ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		List<Product> content =  shoppingCart.getCart();
		System.out.println("products in cart:"+content.size());
		model.addObject("shoppingCart",content);
		return model;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(){
		
		ModelAndView model = new ModelAndView("redirect:/productcus");
		ShoppingCart shoppingCart = (ShoppingCart)context.getBean("shoppingCart");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<Product> pList =  shoppingCart.getCart();
		System.out.println("plist:"+pList.size());
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getId());
			System.out.println("id:"+pList.get(i).getId());
			model.addObject("purchase",pList);
		}
		int result = 0;
		try {
			result = salesOrderDAO.sellProduct(pList2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			
			shoppingCart.cleanup();
		}
		return model;
	}
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(){
		ModelAndView model = new ModelAndView("salesout");
		ShoppingCart2 shoppingCart2 = (ShoppingCart2)context.getBean("shoppingCart2");
		List<Product> content =  shoppingCart2.getCart();
		System.out.println("products in cart:"+content.size());
		model.addObject("shoppingCart",content);
		return model;
	}
	@RequestMapping(value = "/salesout", method = RequestMethod.GET)
	public ModelAndView salesout(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/show");
		ShoppingCart2 shoppingCart2 = (ShoppingCart2)context.getBean("shoppingCart2");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<Product> pList =  shoppingCart2.getCart();
		System.out.println("plist:"+pList.size());
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getId());
			System.out.println("id:"+pList.get(i).getId());
			model.addObject("purchase",pList);
		}
		int result = 0;
		try {
			result = salesOrderDAO.sellout(pList2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			shoppingCart2.cleanup();
		}
		return model;
	}
}
