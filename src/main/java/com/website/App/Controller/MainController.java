package com.website.App.Controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10698333
 *
 */
@Controller
public class MainController {


	/**
	 * @return when we hit the url on browser first this method will be called
	 */
	@GetMapping("/")
	public String index() {
		return "Login";

	}
	
	@GetMapping("/withoutLoginHomePage")
	public String homePage() {
		
		return "MainHomePage";
	}

	/**
	 * @return This is the return Login Page of the Application
	 */
	@PostMapping("/login")
	public String login() {
		return "Login";
	}

	/**
	 * @return Return the Registration of Page
	 */
	@GetMapping("/registration")
	public String registration() {
		return "Registration";
	}
	/**
	 * @return 
	 *   Go to Home Functionality
	 */
	@GetMapping("/home")
	public String homePageFirst() {
		return "index";
	}
	/**
	 * @return
	 * Forget Password functionality
	 */
	@GetMapping("/forget_password")
	public String showForgetPasswordForm() {
		return "ForgetPasswordForm";
	}
	
	
	

	
}
