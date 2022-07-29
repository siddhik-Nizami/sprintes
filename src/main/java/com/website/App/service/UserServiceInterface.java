/**
 * 
 */
package com.website.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.website.App.bean.Role;
import com.website.App.bean.User;

/**
 * @author 10698333 {@link UserServiceInterface contained the only signature
 *         type of the method only i have declare the method here not
 *         implementation are provide }
 * 
 */
/**
 * @author 10698333
 *
 */
public interface UserServiceInterface {

	/**
	 * @return
	 */
	User registerUser(User user) throws Exception;

	/**
	 * @return
	 */
	ResponseEntity<User> forgetPassword();

	/**
	 * @return
	 */
	List<User> getAllUserList();

	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	List<User> findByLogin(String email, String password) throws Exception;

	/**
	 * @param id
	 * @return Return the id of Role
	 */
	public Optional<User> findById(int id);

	/**
	 * @return This method return the List of the Role
	 */
	public List<Role> getListOfRole();
	
	/**
	 * @param token
	 * @param email
	 */
	public void updateResetPasswordToken(String token, String email) throws Exception;

	/**
	 * @param token
	 * @return
	 */
	public User getByResetPasswordToken(String token);
	
	/**
	 * @param user
	 * @param newPassword
	 */
	public void updatePassword(User user, String newPassword);
	/**
	 * @return'
	 * This Method is create for the Find By email id and check the Duplicacy for the application
	 */
	public User findByEmailNameForDuplicay(String emailName) throws Exception;
	
	/**
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * @param user
	 * @param id
	 */
	public void update(Optional<User> user, int id);
	
	public void findByName(String name) throws Exception;
	
	
}
