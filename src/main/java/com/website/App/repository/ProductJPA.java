/**
 * 
 */
package com.website.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.App.bean.ProductDetails;

/**
 * @author 10698333
 *
 */
@Repository
public interface ProductJPA extends JpaRepository<ProductDetails, Integer>{

}
