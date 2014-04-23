package com.agilemaple.common.controller;

//import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.agilemaple.common.dto.userDetails;
import com.agilemaple.common.services.Register;
import com.agilemaple.common.services.impl.RegisterImpl;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	@RequestMapping(/*value="/registerpage",*/  method = RequestMethod.GET)
	public String getRegisterpage(ModelMap model){
         
         return "home";
         }
/*	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}
	*/
	@RequestMapping(value="/login",  method = RequestMethod.POST)
	public String welcome(ModelMap model,@RequestParam("username") String username,@RequestParam("password") int password) {
         System.out.println("inside console"); 
		if((username.equals("gunny")) && (password == 123)){
        	model.addAttribute("message","Welcome Sir");
        	return "home";
        }else{
        	model.addAttribute("message","WRONG USERNAME @ PASSWORD");
        	return "err";
        }		
 
}
	@RequestMapping(value="/register",  method = RequestMethod.POST)
	public String register(ModelMap model,@RequestParam("firstName") String firstName ,
			                @RequestParam("lastName") String lastName ,
			                /*@RequestParam("sex") String sex*/ 
			                @RequestParam("address") String address ,
			                @RequestParam("province") String province ,
			                @RequestParam("country") String country ,
			                @RequestParam("postalCode") String postalCode ,
			                @RequestParam("phoneNumber") String phoneNumber ,
			                @RequestParam("email") String email ){
         System.out.println("inside console"); 
         List<String> lister = new ArrayList<String>();
         lister.add(firstName);
         //lister.add(sex);
         lister.add(address);
         lister.add(province);
         lister.add(country);
         lister.add(postalCode);
         lister.add(phoneNumber);
         lister.add(email);
         RegisterImpl registral = new RegisterImpl();
         boolean registerationStatus = registral.register(lister);
         if(registerationStatus){
        	 model.addAttribute("userDetails",lister);
         }
         
         return "home";
       	
 
}
	@RequestMapping(value="/myaccount",  method = RequestMethod.GET)
	public String myaccount(ModelMap model,@RequestParam("id") Integer id) {
Register myacc = new RegisterImpl();
Map<String,String> myAccountDetails = myacc.getUserDetails(id);
model.addAttribute("myAccountDetails", myAccountDetails);
System.out.println("hello");
return "MyAccount";		
 
}
	
	
	@RequestMapping(value="/myacc",  method = RequestMethod.GET)
	public String myacc(ModelMap model,@RequestParam("id") Integer id) {
		Register myacc = new RegisterImpl();
userDetails userDetail = myacc.getAccountDetails(id);
System.out.println(userDetail.getAddress());
model.addAttribute("userDetailObj",userDetail );
return "MyAccount";		
 
}
	
	
/*@RequestMapping(value="/registerpage",  method = RequestMethod.GET)
	public String getRegisterpage(ModelMap model){
         
         return "Register";
       	
 
}*/

	} 
	
	
