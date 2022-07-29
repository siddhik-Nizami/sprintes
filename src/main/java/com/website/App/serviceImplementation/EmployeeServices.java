/**
 * 
 */
package com.website.App.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.App.bean.Employee;
import com.website.App.repository.EmployeeRepo;
import com.website.App.service.EmployeeInterface;


/**
 * @author 10698333
 *
 */
@Service
public class EmployeeServices implements EmployeeInterface {

	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

}
