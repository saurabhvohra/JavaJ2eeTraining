package com.agilemaple.common.controller;

//import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.agilemaple.common.dto.userDetails;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.services.ContactService;
import com.agilemaple.common.services.Register;
import com.agilemaple.common.Constants;




@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	
	// get log4j handler
	private static final Logger logger = Logger
			.getLogger(HelloController.class);

	@Autowired
	Register register;
	@Autowired
	ContactService contactService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegisterpage(ModelMap model) {
		
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getRegisterpage");
		return "home";
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public String
	 * printWelcome(ModelMap model) {
	 * 
	 * model.addAttribute("message", "Spring 3 MVC Hello World"); return
	 * "index";
	 * 
	 * }
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String getContacts(ModelMap model,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("telephone") String telephone,@RequestParam("email") String email){
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getContacts");
		Contact contact = new Contact();
		contact.setEmail(email);
		contact.setFirstname(firstName);
		contact.setLastname(lastName);
		contact.setTelephone(telephone);
		contactService.addContact(contact);
		return"ContactForm";
}
	@RequestMapping(value = "/getcontactform", method = RequestMethod.GET)
	public String getForm(ModelMap model){
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getForm");
		return"ContactForm";
}
	
	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public String getContacts(ModelMap model){
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getContacts");
		List<Contact> contactList = contactService.listContact();
		model.addAttribute("contactList", contactList);
		return"ListContacts";
}
	
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcome(ModelMap model,
			@RequestParam("username") String username,
			@RequestParam("password") int password) {
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"welcome");
		if ((username.equals("gunny")) && (password == 123)) {
			model.addAttribute("message", "Welcome Sir");
			return "home";
		} else {
			model.addAttribute("message", "WRONG USERNAME @ PASSWORD");
			return "err";
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(ModelMap model,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			/* @RequestParam("sex") String sex */
			@RequestParam("address") String address,
			@RequestParam("province") String province,
			@RequestParam("country") String country,
			@RequestParam("postalCode") String postalCode,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("email") String email) {
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"register");
		List<String> lister = new ArrayList<String>();
		lister.add(firstName);
		// lister.add(sex);
		lister.add(address);
		lister.add(province);
		lister.add(country);
		lister.add(postalCode);
		lister.add(phoneNumber);
		lister.add(email);
		// RegisterImpl registral = new RegisterImpl();
		boolean registerationStatus = register.register(lister);
		if (registerationStatus) {
			model.addAttribute("userDetails", lister);
		}

		return "home";

	}

	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String myaccount(ModelMap model, @RequestParam("id") Integer id) {
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"myaccount");
		Map<String, String> myAccountDetails = register.getUserDetails(id);
		model.addAttribute("myAccountDetails", myAccountDetails);
		System.out.println("hello");
		return "MyAccount";

	}

	@RequestMapping(value = "/myacc", method = RequestMethod.GET)
	public String myacc(ModelMap model, @RequestParam("id") Integer id) {
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"myacc");
		userDetails userDetail = register.getAccountDetails(id);
		System.out.println(userDetail.getAddress());
		model.addAttribute("userDetailObj", userDetail);
		return "MyAccount";

	}

	/*
	 * @RequestMapping(value="/registerpage", method = RequestMethod.GET) public
	 * String getRegisterpage(ModelMap model){
	 * 
	 * return "Register";
	 * 
	 * 
	 * }
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContact(ModelMap model, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName){
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getContact");
		Contact contact = contactService.findContact(firstName, lastName);
		model.addAttribute("contact",contact);
		return"DisplayContact";
}
} 
	
	
