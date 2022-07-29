/**
 * 
 */
package com.website.App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.website.App.bean.Role;
import com.website.App.bean.User;

/**
 * @author 10698333 This is the Role service class contained the application of
 *         Role based authentication
 */
@Service
public interface RoleServiceInterface {

	/**
	 * @param id
	 * @return This method get Role from the database by id and return to user
	 */
	//public User getRole(Long id);

	/**
	 * @return This method return the GetList of Role from the database send the
	 *         list to user with help of the controller this is the signature type
	 *         of the method implementation is not provide here
	 */
	public List<Role> getListOfRole();

}
