/**
 * 
 */
package com.website.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.website.App.bean.Employee;
import com.website.App.service.EmployeeInterface;

import javax.validation.Valid;



/**
 * @author 10698333
 *
 */
@Controller
public class EmployeeCtl {
	
	@Autowired
	EmployeeInterface empServices;

	@GetMapping("/Employee")
	public String Home() {
		return "EmployeeRegistration";
	}
	@RequestMapping(value="/processRegistration",method = RequestMethod.POST)
	public String processRegistration( Employee emp,Errors errors, Model model) {
		empServices.save(emp);
		model.addAttribute("user", emp);
		return "EmployeeRegistration";
	}
	
}
