/**
 * 
 */
package com.website.App.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.website.App.bean.Role;
import com.website.App.bean.User;
import com.website.App.repository.RoleJPA;
import com.website.App.repository.UserJpa;
import com.website.App.service.RoleServiceInterface;

/**
 * @author 10698333
 *
 */
public class RoleServiceImplementation implements RoleServiceInterface {

	/**
	 * This is the roleRepository inteface and contained the predefined the method
	 * in JPA
	 */
	@Autowired
	RoleJPA roleRepository;

	/**
	 * This is the UserRepository contained the user information 
	 */
	@Autowired
	UserJpa userRepository;
	/**
	 * This method contained the Role id
	 */
	
	/**
	 * This method contained the List of Role from the database in the Application
	 */
	@Override
	public List<Role> getListOfRole() {
	
		return roleRepository.findAll();
	}

}
