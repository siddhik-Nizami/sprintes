/**
 * 
 */
package com.website.App.service;

import java.util.List;

import com.website.App.bean.ProductDetails;

/**
 * @author 10698333
 *
 *         Product interface class its contained the Product information and the
 *         method of signature type and we are following the design pattern here
 */
public interface ProductInterface {

	/**
	 * @param product
	 * @return Save the Product details into the database
	 */
	ProductDetails save(ProductDetails product);

	/**
	 * @return List of the Product
	 */
	List<ProductDetails> listOfProduct();

}
