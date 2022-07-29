/**
 * 
 */
package com.website.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.App.bean.Employee;



/**
 * @author 10698333
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
