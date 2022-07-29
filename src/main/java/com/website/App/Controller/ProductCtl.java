/**
 * 
 */
package com.website.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.website.App.bean.ProductDetails;
import com.website.App.exception.ProductDataNotFounkd;
import com.website.App.service.ProductInterface;

/**
 * @author 10698333 This is controller class and communicate with interface and
 *         perfomed the bussiness operation for the class
 */
@Controller
@RequestMapping(value="/product")
public class ProductCtl {
	
	
	/**
	 *  This is class Autowired with Product Interface and 
	 *  calling the method  
	 */
	@Autowired
	ProductInterface productInterface;
	
	@RequestMapping(value="/productlist",method=RequestMethod.GET)
	public String getList(Model model) throws ProductDataNotFounkd {
		List<ProductDetails> product  = productInterface.listOfProduct();
		if(product.isEmpty()) {
			throw new ProductDataNotFounkd("");
		}
		model.addAttribute("product", product);
		return "ProductList";
	}
	
	@GetMapping("/productpage")
	public String showProductPage() {
		return "AddProduct";
	}
	
	@RequestMapping(value = "/productSaved",method = RequestMethod.POST)
	public String ProductSaved(@ModelAttribute("product") ProductDetails product,Model model) {
		product= productInterface.save(product);
		model.addAttribute("product", product);
		model.addAttribute("productMessage","successFullySaved the product");
		
		return"AddProduct";
	}

}
