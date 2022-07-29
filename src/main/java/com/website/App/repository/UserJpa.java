/**
 * 
 */
package com.website.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.website.App.bean.User;

/**
 * @author 10698333 This is the userJpa class and that class connect with the
 *         database and store the value in the database
 */
@Repository
@EnableJpaRepositories
public interface UserJpa extends JpaRepository<User, Integer> {

	/**
	 * @param email
	 * @param password
	 * @return This is the Custom method in the JPA i have create the query for the
	 *         find email and password from the DataBase
	 */
	@Query("select u from User u where u.email=:email and u.password=:password")
	public List<User> findByEmail(@Param("email") String email, @Param("password") String password);

	/**
	 * @param id
	 * @return User is findById its get the User by id
	 */
	
	
	/**
	 * @param token
	 * @return
	 */
    @Query("SELECT c FROM User c WHERE c.resetPasswordToken=:resetPasswordToken")
	User findByToken(@Param("resetPasswordToken") String token);
    
    /**
     * @return findBy Email throw the JPA Repository
     */
    @Query("SELECT c FROM User c WHERE c.email=:email")
    User findByEmail(@Param("email") String email);
    

}
