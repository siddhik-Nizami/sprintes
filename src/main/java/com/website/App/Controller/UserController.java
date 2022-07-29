/**
 * 
 */
package com.website.App.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.website.App.Utility.Utility;
import com.website.App.bean.Role;
import com.website.App.bean.User;
import com.website.App.exception.EmailIDOrMatached;
import com.website.App.exception.EmailIdOrPasswordNotMatched;
import com.website.App.exception.UserNotFoundTheException;
import com.website.App.service.UserServiceInterface;

import net.bytebuddy.utility.RandomString;

/**
 * @author 10698333 (Siddhik-Nizami)
 * 
 *         This is the UserController send to request service class and
 *         performed the business operation
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	/**
	 * This is interface class Autowired
	 * 
	 */
	/**
	 * Mail send class for send the mail to user
	 */
	@Autowired
	private JavaMailSender javaMailSend;
	@Autowired
	UserServiceInterface userService;

	@RequestMapping(value = "/AddUser",method = RequestMethod.GET)
	public String addUser() {
		return "AddUser";
	}
	@RequestMapping(value = "/savedtheUser",method = RequestMethod.POST)
	public String UserRegistration(@ModelAttribute("user") User user,Model model) throws Exception {
		user=userService.registerUser(user);
		if(user != null) {
			model.addAttribute("messageregister", "successfully saved the user details");
		}
		return"AddUser";
	}
	/**
	 * @param model
	 * @param user
	 * @return we have saved the data and the traving the data from the ui to
	 *         controller and return the response the data to View
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/saveUserInformation", method = RequestMethod.POST)
	public String saveUserInformation(Model model, @ModelAttribute("user") User user,String name) throws Throwable {
		User use = userService.findByEmailNameForDuplicay(user.getEmail());
	  userService.findByName(name);
		model.addAttribute("use", use);
		
		if (use == null) {
			user = userService.registerUser(user);
			model.addAttribute("messageforRegistration", "SuccessFully saved the User Details");
			return "Login";
		} else {
			model.addAttribute("error", "please filed the Valid details");
		}
		return "Registration";
	}

	/**
	 * @param model
	 * @return
	 * @throws UserNotFoundTheException This Method contained the infomation of the
	 *                                  User list of User and return the list to UI
	 *                                  and Record not found than throws the Custome
	 *                                  Exception
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getListOfAllUser(Model model) throws UserNotFoundTheException {
		List<User> list = userService.getAllUserList();
	
	//	System.out.println(list);
	   //list.stream().collect(Collectors.toList()).forEach(System.out::println);
		if (list.isEmpty()) {
			throw new UserNotFoundTheException("Record not Found");
		}
		System.out.println(list + "userList");
		model.addAttribute("list", list);
		return "UserList";
	}

	/**
	 * @param email
	 * @param password
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception This method Perfomed the Login Operation with the data and
	 *                   find the Email and Password from the database and the
	 *                   return to controller and ctl send to View
	 * 
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginPage(@Param("email") String email, @Param("password") String password,
			@ModelAttribute("user") User user, Model model) throws Exception {
		List<User> authentication = userService.findByLogin(email, password);
		for (User u : authentication)
			if (u.getEmail().equals(email) || u.getPassword().equals(u.getPassword())) {
				return "index";

			}
		model.addAttribute("wrongPassword", "please Enter the Valide Email and PAssword");
		return "Login";
	}

	/**
	 * @return This Api Update the user Details by their id and changed the also
	 *         Role of the user
	 * @throws EmailIDOrMatached
	 * @throws EmailIdOrPasswordNotMatched
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id, Model model, @ModelAttribute("user") User user)
			throws EmailIdOrPasswordNotMatched {
		Optional<User> user2 = userService.findById(id);
		System.out.println(user2 + "find By id ===");
		if (user2 == null) {
			throw new EmailIdOrPasswordNotMatched("Id not Found");
		}
		//userService.update(user2, id);
		model.addAttribute("user2", user2);
		return "updatePage";
	}

	@RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
	public String updateUser(Model model, @ModelAttribute("user2") User user2)
			throws Exception {
			User user = new User();
			
		  user.setId(user2.getId());
		  
		  user.setEmail(user2.getEmail()); 
		  user.setName(user2.getName());
		  user.setPassword(user2.getPassword());
		  user.setAddress(user2.getAddress());
		  user.setCountry(user2.getCountry());
		  user.setState(user2.getState()); 
		  user.setDistrict(user2.getDistrict());
		  user.setGender(user2.getGender());
		  user.setPhoneNumber(user2.getPhoneNumber());
		  user.setPincode(user2.getPincode());
		  user.setRoles(user2.getRoles());
		 
		userService.registerUser(user);
		model.addAttribute("user2", user2);
		model.addAttribute("userUpdate", "User successFully updated");
		return "updatePage";
	}

	/**
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception Forget password functionality
	 */
	@RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
	public String forgetPasswordProcess(Model model, HttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		try {
			userService.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

		} catch (UserNotFoundTheException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error while sending email");
		}

		return "ForgetPasswordForm";
	}

	/**
	 * @return Reset Password functionality
	 */
	@GetMapping("/reset_password")
	public String reserPasswordForm(@Param(value = "token") String token, Model model) {
		User user = userService.getByResetPasswordToken(token);
		model.addAttribute("token", token);
		if (user == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}
		return "ResetPasswordForm";
	}

	/**
	 * @return Reset Password Process By this function
	 */
	@RequestMapping(value = "/reset_password", method = RequestMethod.POST)
	public String ProcessresetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");

		User user = userService.getByResetPasswordToken(token);
		model.addAttribute("title", "Reset your password");
		if (user == null) {
			model.addAttribute("message", "Invalide token");
			return "message";
		} else {
			userService.updatePassword(user, password);
			model.addAttribute("message", "Yo have SuccessFully changed the Password");
		}
		return "message";
	}

	/**
	 * @param recipientEmail
	 * @param link
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	public void sendEmail(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = javaMailSend.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("siddhiknizami00@gmail.com", "Online support Emial");
		helper.setTo(recipientEmail);
		String subject = "This link throw you can reset the password";
		String content = "<p>Hello,</p>" + "<p>You have request the reset the Password .</p>"
				+ "<p>please click the link below for change the password:</p>" + "<p> <a href=\"" + link
				+ "\"> Change my password</a></p>" + "<br>/<br>"
				+ "<p>Ignor this email if you do remember the password or you have not made the request for the forget of password</p>";
		helper.setSubject(subject);
		helper.setText(content, true);
		javaMailSend.send(message);
	}

	/**
	 * @param id
	 * @param user
	 * @param model
	 * @param message
	 * @return Delete method to perfomed the delete operation for the Application
	 *         Delete functionality first find the id than delete the id
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteRecord(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model,
			String message) {
		Optional<User> deletedId = userService.findById(id);
		if (deletedId.isPresent()) {
			userService.delete(user);
			model.addAttribute("user", user);
			model.addAttribute("message", "Success Fully Deleted the Record	");
		}
		return "UserList";
	}

}
