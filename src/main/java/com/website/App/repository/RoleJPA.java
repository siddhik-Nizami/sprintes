/**
 * 
 */
package com.website.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.App.bean.Role;

/**
 * @author 10698333 Role Repository its contained the role of the application we
 *         have created the different role in the application
 */
@Repository
public interface RoleJPA extends JpaRepository<Role, Integer> {

	/**
	 * @param name
	 * @return
	 * 
	 *         This method return the name of the Role from the database and
	 *         internall execute the HQL query for the findByName method
	 */
	//Role findByName(String name);

}
