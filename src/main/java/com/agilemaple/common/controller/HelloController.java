package com.agilemaple.common.controller;

//import javax.servlet.http.HttpServletRequest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.agilemaple.common.Constants;
import com.agilemaple.common.controller.form.PortfolioBean;
import com.agilemaple.common.dto.UserInformationVO;
import com.agilemaple.common.dto.userDetails;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.entity.UserDetails;
import com.agilemaple.common.services.CapchaService;
import com.agilemaple.common.services.ContactService;
import com.agilemaple.common.services.Register;
import com.agilemaple.common.services.UserDetailsService;
import com.agilemaple.common.services.UserInformationService;
import com.google.gson.Gson;




@Controller
@RequestMapping("/account")
public class HelloController {	
	// get log4j handler
	private static final Logger logger = Logger
			.getLogger(HelloController.class);
	final DefaultResourceLoader loader = new DefaultResourceLoader();

	@RequestMapping(method = RequestMethod.GET)
	public String getRegisterpage(ModelMap model) {
		
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getRegisterpage");
		return "home";
	}

	@Autowired
	Register register;
	@Autowired
	ContactService contactService;
	@Autowired
	UserInformationService userService;
	@Autowired
	UserDetailsService userDetails;
	@Autowired
	CapchaService capchaService;
	@Autowired
	RestTemplate restTemplate;
	
	
	//web Services
	
	@RequestMapping(value = "/movedPermanently", method = RequestMethod.GET)
	public @ResponseBody HttpStatus getMovedPermanently(ModelMap model) {
		String result = "OK";
		//.MOVED_PERMANENTLY
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getAuthors");
		return HttpStatus.MOVED_PERMANENTLY;
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public @ResponseBody String getAuthors(ModelMap model) {
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getAuthors");
		
		
		JSONArray jarray = new JSONArray();
		//contactService.listContact()
	      try {
	    	
	    	for(Contact contact: contactService.listContact()){
	    	//	JSONObject objMain = new JSONObject();
	    		JSONObject obj = new JSONObject();
	    		obj.put("FirstName",contact.getFirstname());
	    		obj.put("LastName",contact.getLastname());
	    		obj.put("Email",contact.getEmail());
	    		//objMain.put(contact.getFirstname(),contact);	
	    		jarray.put(obj);
	    	}
	    	
			/*obj.put("name", "foo");
			obj.put("num", new Integer(100));
		    obj.put("balance", new Double(1000.21));
		    obj.put("is_vip", new Boolean(true));*/
		} catch (JSONException e) {
			logger.error(Constants.METHOD_INSIDE_MESSAGE +"getAuthors",e);
		}		
		return jarray.toString();
	}
	
	@RequestMapping(value = "/contactsusingGson", method = RequestMethod.GET)
	public @ResponseBody String getContactsusingGson(ModelMap model) {
		Gson gson = new Gson();
		String json = null;
		try{
		
			json = gson.toJson(contactService.listContact());
		
		}catch(Exception e){
			logger.error(Constants.METHOD_INSIDE_MESSAGE +"getAuthors",e);
			
		}
		return json;
	}
	
	    //Desirealization//
	@RequestMapping(value = "/deserialization", method = RequestMethod.GET)
	public @ResponseBody String consumingWebServices(ModelMap model) {
	
	String contacts =restTemplate.getForObject("http://localhost:8080/AgilemapleTraining/tutor/open/account/contactsusingGson", String.class);
	logger.debug(contacts);
	return contacts;
	
	}
	
	
	
	
	
	///***********************************************///
	
	/***********************************************************************************
	    CAPCHA
	************************************************************************************/
	
	/*@RequestMapping(value = "/capcha", method = RequestMethod.GET)
	public @ResponseBody Byte[] CapchaGson(ModelMap model) {
		Gson gson = new Gson();
		String json = null;
		try{
			
			json = gson.toJson(capchaService.CapchaString("hgsyg"));
		
		}catch(Exception e){
			logger.error(Constants.METHOD_INSIDE_MESSAGE +"getAuthors",e);
			
		}
		return json;
	}*/

	
	@RequestMapping(value = "/photo2", method = RequestMethod.GET)
	public String returningPage(ModelMap model){
		return "Capchalogin";
	}
	
    @ResponseBody
	@RequestMapping(value="/capcha", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphoto(ModelMap model) throws IOException {
    	//InputStream in = servletContext.getResourceAsStream("/resources/Modi.jpg");
		//Resource resource = loader.getResource("new.png");
		//ImageInputStream watermarkImage = ImageIO.createImageInputStream(resource.getFile());
	    // InputStream is = new BufferedInputStream(new FileInputStream(resource.getFile()));
		//InputStream is = new BufferedInputStream(new FileInputStream(image));
	    //return IOUtils.toByteArray(is);
        /*FileOutputStream fos = new FileOutputStream("C:/Users/Saurabh/Documents/Agile maple code/JavaJ2eeTraining/src/main/webapp/resources/image.jpg");
          try {
                fos.write(image);
                 }
                finally {
                       fos.close();
                  }*/

         //Resource resource = loader.getResource("image.jpg");
         //ImageInputStream watermarkImage = ImageIO.createImageInputStream(resource.getFile());
		byte[] image =capchaService.CapchaString();
	    return image;    
	}
    
	@RequestMapping(value = "/returnPage") 
	public  String returningPag(ModelMap model,@RequestParam("capcha") String capcha){
		byte[] originalCapchaInByteArray=capchaService.ReturnedCapchaString();
		byte[] returnedCapchaInByteArray = capcha.getBytes();
		if(Arrays.equals(returnedCapchaInByteArray, originalCapchaInByteArray)){
			return "CapchaSubmit";
		}
		return "403";
		
	}
	
	
	/*     try {
             BufferedImage bi=new BufferedImage(300, 100, BufferedImage.TYPE_INT_RGB);
             Graphics g = bi.getGraphics();
             g.drawString(capcha, 50, 50);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ImageIO.write( bi, "png", baos );
             baos.flush();
             //ImageOutputStream out = new FileImageOutputStream(new File("C:/Users/Saurabh/Documents/Agile maple code/JavaJ2eeTraining/src/main/resources/new.png")); 
             //ImageIO.write(bi, "png", out);
             byte[] savedArray =  baos.toByteArray();
             return savedArray;
         } catch (IOException e) {
             throw new RuntimeException(e);
         }*/

	
	
	
	
	
	
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String userdata(ModelMap model){
		model.addAttribute("userDetails", userDetails);
		return "Signup";
	}
	
	@RequestMapping(value = "/userInformation", method = RequestMethod.POST)
	public String userInf(ModelMap model,@RequestParam("username") String username,@RequestParam("password") String password){
		UserDetails user = userDetails.readUsers(username, password);
		List<UserDetails> listOfUsers = userDetails.listUsers();
		UserDetails firstUser = listOfUsers.get(0);
		String firstUserName=firstUser.getFirstname();
		String  firstUserPassword= firstUser.getPassword();
		if((firstUserName.equals(username))&&( firstUserPassword.equals(password))){
			model.addAttribute("user", user);
			return "HomePage";
		}else{
	        model.addAttribute("message", "Problems signing in to your account");
			return "err";
	}
	}
	@RequestMapping(value = "/userSignup", method = RequestMethod.POST)
	public String userSignup(ModelMap model, @RequestParam("firstname") String firstname ,@RequestParam("lastname") String lastname, 
			@RequestParam("email") String email,@RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("country") String country,
			@RequestParam("postalcode") String postalcode,
			@RequestParam("birthday") String birthday,
			@RequestParam("gender") String gender){
		UserDetails user = new UserDetails();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setCountry(country);
		user.setPostalcode(postalcode);
		user.setBirthday(birthday);
		user.setGender(gender);
		userDetails.addUser(user);
	  return "Register";
	}
		
	@RequestMapping(value = "/userdata", method = RequestMethod.GET)
	public String users(ModelMap model, @RequestParam("page") Integer page ){
	//int pageInt=Integer.parseInt("page"); 
	page=page+1;
    int nextPageid=page+1;
    
    UserInformationVO  userInform= userService.readUsers(page);
	model.addAttribute("nextPageid",nextPageid);
	model.addAttribute("userInform",userInform);
	return "userInformation";
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
	
	@RequestMapping(value = "/contactform", method = RequestMethod.GET)
	public String contactform(ModelMap model){
	return "ContactForm";
	}
	
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
	
	
	/********************************************************************************
	 *                                       AJAX
	 ************************************************************************************/
	@RequestMapping(value = "/ajaxForm", method = RequestMethod.GET)
	public String contactformAjax(ModelMap model){
	return "ajaxPage";
	}
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	public @ResponseBody String getContactsThroughAjax(ModelMap model,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("telephone") String telephone,@RequestParam("email") String email){
		logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getContacts");
		Contact contact = new Contact();
		contact.setEmail(email);
		contact.setFirstname(firstName);
		contact.setLastname(lastName);
		contact.setTelephone(telephone);
		contactService.addContact(contact);
		List<Contact> contactList = contactService.listContact();
		model.addAttribute("contactList", contactList);
		String successMessage = "New Contact Is Added";
		
		Gson gson = new Gson();
		String json = null;
		try{
		
			json = gson.toJson(contactService.listContact());
		
		}catch(Exception e){
			logger.error(Constants.METHOD_INSIDE_MESSAGE +"getAuthors",e);
			
		}
		return json;
}
	
	
	
	
	
	/*******************************************************************/
	
	
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
	
	@RequestMapping("/populateForm")
	
	    public String populateForm(ModelMap model){	
	        String view = "portfolioview";
	
	        PortfolioBean portfolio = new PortfolioBean();
	        
	        portfolio.setName("Full name");
	
	        portfolio.setMobNum("0123456789");
	
	        model.addAttribute("portfolio", portfolio);

	        System.out.println("portfolio set. returning to " + view);
	
	        return "Portfolio";
	
	    }


/********************************************************************************
 *                                       AJAX-Response-Type 2 Method
 ************************************************************************************/
	@RequestMapping(value = "/ajaxFormTwo", method = RequestMethod.GET)
	public String contactformAjaxTwo(ModelMap model){
	return "IncludeContactsAjax";
	}

@RequestMapping(value = "/ajaxFormResponseType2Method", method = RequestMethod.POST)
public String ajaxFormResponseType2Method(ModelMap model,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
		@RequestParam("telephone") String telephone,@RequestParam("email") String email){
	logger.debug(Constants.METHOD_INSIDE_MESSAGE +"getContacts");
	Contact contact = new Contact();
	contact.setEmail(email);
	contact.setFirstname(firstName);
	contact.setLastname(lastName);
	contact.setTelephone(telephone);
	contactService.addContact(contact);
	List<Contact> contactList = contactService.listContact();
	model.addAttribute("contactList", contactList);
	return "IncludeContactsAjaxTwo";
	
}
}

	
