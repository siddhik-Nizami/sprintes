/**
 * 
 */
package com.website.App;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.website.App.bean.ProductDetails;
import com.website.App.bean.Role;
import com.website.App.bean.User;
import com.website.App.repository.ProductJPA;
import com.website.App.repository.RoleJPA;
import com.website.App.repository.UserJpa;

/**
 * @author 10698333
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepository {
	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	ProductJPA productDao;
	@Test
	public void testPRoduct() {
		ProductDetails product  = new ProductDetails();
		product.setId(1);
		product.setProductName("Rose");
		product.setQuantity(2);
		product.setDescripation("Rose of the product");
		product.setPrice(12121);
		productDao.save(product);
		
	}
	
	

	@Autowired
	UserJpa userrepo;

	/*
	 * @Test public void testForRole() { Role roleAdmin =
	 * rolerepo.findByName("Admin"); User user = new User();
	 * user.setName("siddhik"); user.setAddress("Nagri");
	 * user.setEmail("sdk@gmail.com"); user.setCountry("indian");
	 * user.addRole(roleAdmin); User useradd = userrepo.save(user);
	 * assertThat(useradd.getRoles().size()).isEqualTo(1);
	 * 
	 * }
	 */
	/*
	 * @Test public void testRole() { Role role = new Role("Admin"); Role normal =
	 * new Role("Normal"); Role customer = new Role("Customer");
	 * rolerepo.saveAll(List.of(role, normal, customer)); List<Role> listofRole =
	 * rolerepo.findAll(); assertThat(listofRole.size()).isEqualTo(3);
	 * 
	 * }
	 */

}
