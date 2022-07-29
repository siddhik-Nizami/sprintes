/**
 * 
 */
package com.website.App.serviceImplementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.website.App.bean.Role;
import com.website.App.bean.User;
import com.website.App.exception.EmailIDOrMatached;
import com.website.App.exception.EmailIdOrPasswordNotMatched;
import com.website.App.exception.UserNotFoundTheException;
import com.website.App.repository.RoleJPA;
import com.website.App.repository.UserJpa;
import com.website.App.service.UserServiceInterface;

/**
 * @author 10698333 UserServiceImplemenation class for the implement the all
 *         user details
 * 
 */
@Service
public class UserServiceImple implements UserServiceInterface {

	/**
	 * This is the JPA repository interface bean we have Autowired for the object
	 * and calling the predifined the method
	 */
	@Autowired
	UserJpa userDao;

	/**
	 * 
	 */
	@Autowired
	RoleJPA roleDao;

	/**
	 * This method Saved the All User into database
	 * 
	 * @throws Exception
	 */
	@Override
	public User registerUser(User user) throws Exception {
		return userDao.save(user);
	}

	/**
	 * This method contained the forgetpassword information
	 */
	@Override
	public ResponseEntity<User> forgetPassword() {
		return null;
	}

	/**
	 * This Method find the All User from the Database
	 */
	@Override
	public List<User> getAllUserList() {
		return userDao.findAll();
	}

	/**
	 * findByLogin method are create for the user email id will find from database
	 */
	@Override
	public List<User> findByLogin(String email, String password) throws Exception {

		List<User> usr = userDao.findByEmail(email, password);
		for (User user : usr) {
			if (user == null) {
				throw new UserNotFoundTheException("User Not found Exception");
			}
		}
		return usr;
	}

	/**
	 * User the findById throw
	 */
	@Override
	public Optional<User> findById(int id) {
		Optional<User> user = userDao.findById(id);
		return user;
	}

	/**
	 * Get List Role from the Role Table specified
	 */
	@Override
	public List<Role> getListOfRole() {

		return roleDao.findAll();
	}

	/**
	 * This function Update Reset Password Token
	 */
	@Override
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundTheException {
		User user = userDao.findByEmail(email);
		if (user != null) {
			user.setResetPasswordToken(token);
			userDao.save(user);
		} else {
			throw new UserNotFoundTheException(email + "User Not Found Exception");
		}

	}

	/**
	 * Generate the Token for the User forget password functionality
	 */
	@Override
	public User getByResetPasswordToken(String token) {

		return userDao.findByToken(token);
	}

	/**
	 * Update Password functionality
	 */
	@Override
	public void updatePassword(User user, String newPassword) {
		user.setPassword(newPassword);
		user.setResetPasswordToken(null);
		userDao.save(user);

	}

	/**
	 * This is the FindByEmail for Checking the duplicacy for the application and
	 * the check the Authentication for the email
	 * 
	 * @throws EmailIdOrPasswordNotMatched
	 */

	public User findByEmailNameForDuplicay(String email) throws EmailIdOrPasswordNotMatched {
		return userDao.findByEmail(email);

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(Optional<User> user, int id) {
		user = userDao.findById(id);
		if (user.isPresent()) {
			User userAgain = new User();
			userAgain.setId(id);
			userDao.save(userAgain);
		}
	}

	@Override
	public void findByName(String name) throws Exception {
		List<User> list = userDao.findAll();
		List<String> findName = list.stream().map(user -> user.getName()).collect(Collectors.toList());
		HashSet<String> set = new HashSet();
		List<String> NamOFduplicate = findName.stream().filter(name1 -> !set.add(name1)).collect(Collectors.toList());
		if (name.equals(NamOFduplicate)) {
			throw new Exception();
		}
		
	}
}