/**
 * 
 */
package com.website.App.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.App.bean.ProductDetails;
import com.website.App.repository.ProductJPA;
import com.website.App.service.ProductInterface;

/**
 * @author 10698333 This is the ProductSevice Implement class this is the
 *         implement the all method and communicate with the dao
 */
@Service
public class ProductServices implements ProductInterface {
	
	@Autowired
	ProductJPA productDao;

	@Override
	public ProductDetails save(ProductDetails product) {

		return productDao.save(product);
	}

	@Override
	public List<ProductDetails> listOfProduct() {

		return productDao.findAll();
	}

}
