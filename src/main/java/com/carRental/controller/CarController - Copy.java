package com.carRental.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.carRental.service.registerService;

import jakarta.servlet.http.HttpSession;

import com.carRental.service.adminloginService;
import com.carRental.service.carbookingService;
import com.carRental.service.carsService;
import com.carRental.service.loginService;
import com.carRental.entity.carbooking;
import com.carRental.entity.cars;
import com.carRental.entity.login;
import com.carRental.entity.adminlogin;
import com.carRental.entity.register;
import com.carRental.repository.carsRepository;

@Controller
public class CarController {
	
	@Autowired
	private registerService service;
	@Autowired
	private loginService userService;
	@Autowired
	private adminloginService adminService;
	@Autowired
	private carsService carrsService;
	@Autowired
	private carbookingService cbservice;
	@Autowired
	private carsRepository carrepository;
	

	@GetMapping("/")
	public String index() {
		return "home";
	}
	@GetMapping("about.html")
	public String about() {
		return "about";
	}
	@GetMapping("contact.html")
	public String contact() {
		return "contact.html";
	}
	@GetMapping("/home.html")
	public String home() {
		return "home";
	}
	@GetMapping("/register.html")
	public String register() {
		return "register";
	}
	@GetMapping("/admin.html")
	public String admin() {
		return "admin";
	}
	@GetMapping("/admincar.html")
	public String admincar() {
		return "admincar";
	}
	@GetMapping("/adminview.html")
	public ModelAndView adminview() {
		List<carbooking>list=cbservice.getAllcarbookings();
	   // ModelAndView m=new ModelAndView();
		//m.setViewName("admin");
		//m.addObject("register",list);
		return new ModelAndView("adminview","carbooking",list);
		
	}
	@GetMapping("/admincarslist.html")
	public ModelAndView admincarslist() {
		List<cars>list=carrsService.getAllCars();
		// ModelAndView m=new ModelAndView();
		//m.setViewName("admin");
		//m.addObject("register",list);
		return new ModelAndView("admincarslist","cars",list);
		
	}
	


	
	@GetMapping("/login.html")
	public String login(@RequestParam(value = "username", required = false) String username) {
		// Do something with the retrieved 'carsId' and 'username' values
	    System.out.println("Username: " + username);

		return "login";
	}
	@GetMapping("/adminlogin.html")
	public String adminlogin() {
		// Do something with the retrieved 'carsId' and 'username' values
		
		
		return "adminlogin";
	} 
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
	  @GetMapping("/adminlogout")
      public String adminlogout(HttpSession session) {
          session.invalidate();
          return "redirect:/adminlogin.html";
      }
	@GetMapping("/Front.html")
	public String front() {
		return "Front";
	}
	
	@GetMapping("/safetyguide.html")
	public String safetyguide() {
		return "safetyguide";
	}
	
	
	@GetMapping("/rent.html")
	public String rent(
	    @RequestParam(name = "priceperday", required = false) String pricePerDay,
	    @RequestParam("carnumber") String carNumber,
	    @RequestParam("status") String status,
	    HttpSession session,
	    Model model
	) {
	    // Retrieving the username from the session
	    String username = (String) session.getAttribute("username");

	    // Printing the username value
	    System.out.println("Username: " + username);

	    // Adding 'username' to the model to be used in rent.html
	    model.addAttribute("username", username);
	    System.out.println("carNumber: " + carNumber);
	    
	    // Print the pricePerDay value
	    System.out.println("pricePerday: " + pricePerDay);

	    // Your remaining logic here...

	    return "rent"; // Return the appropriate page or value
	}

	
	@GetMapping("/mybookings.html")
	public ModelAndView mybooking(HttpSession session) {
		String uname = (String) session.getAttribute("username");
	    List<carbooking> allbooking = cbservice.getAllcarbookings();
	    List<carbooking> userBooking = new ArrayList<>();
	    for (carbooking task : allbooking) {
	        if (task.getUsername() != null && task.getUsername().equals(uname)) {
	        	userBooking.add(task); // Add tasks that match the session's username
	        }
	    }
	    ModelAndView modelAndView = new ModelAndView("mybookings");
	    modelAndView.addObject("carbooking", userBooking);
	    return modelAndView;
	}
	
	
	@GetMapping("/viewbookings.html")
	public ModelAndView viewbookings(HttpSession session) {
		String username = (String) session.getAttribute("username");
	    List<carbooking> allrents = cbservice.getAllcarbookings();
	    List<carbooking> userrents = new ArrayList<>();
	    for (carbooking task : allrents) {
	        if (task.getUsername() != null && task.getUsername().equals(username)) {
	        	userrents.add(task); // Add tasks that match the session's username
	        }
	    }
	    ModelAndView modelAndView = new ModelAndView("viewbookings");
	    modelAndView.addObject("carbooking", userrents);
	    return modelAndView;
	}

	
	
	
	
	
	 @GetMapping("/availablecars.html")
	 public String availableCars( Model model) {
 {
	        // Here, you should populate the "cars" model attribute with the list of available cars
	        // This data should be retrieved from your car repository or service
	        List<cars> availableCars = carrsService.getAllCars(); // Replace with your actual data retrieval method
	        model.addAttribute("cars", availableCars);
	        return "availablecars";
 }// This should match the name of your Thymeleaf template (availablecars.html)
	        
	        
	    }
	
	 @GetMapping("/allbookings.html")
	 public String allbookings( Model model) {
		 {
			 // Here, you should populate the "cars" model attribute with the list of available cars
			 // This data should be retrieved from your car repository or service
			 List<carbooking> allbookings = cbservice.getAllcarbookings(); // Replace with your actual data retrieval method
			 model.addAttribute("carbooking", allbookings);
			 return "allbookings";
		 }// This should match the name of your Thymeleaf template (availablecars.html)
		 
		 
	 }
	 

	@PostMapping("/login")
    public String login(@ModelAttribute("user") login user,HttpSession session ) {
        
        login oauthUser = userService.login(user.getUsername(), user.getPassword());
        

   
        if(Objects.nonNull(oauthUser)) 
        {    
        	session.setAttribute("username", user.getUsername());
        	session.setAttribute("role", "patient");
        	System.out.println("user" +user.getUsername());
            return "redirect:/Front.html";
        
            
        } else {
        	System.out.println("no");
            return "redirect:/login.html";
            
        
        }
	}
	
	@PostMapping("/adminlogin")
	public String adminlogin(@ModelAttribute("user") adminlogin admin, HttpSession session) {
	    adminlogin oauthUser = adminService.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());

	    if (Objects.nonNull(oauthUser)) {
	        session.setAttribute("username", admin.getUsername());
	        adminlogin user1 = adminService.getRoleByUsername(admin.getUsername());

	        if (user1 != null) {
	            String role = user1.getRole();

	            if ("admin".equals(role)) {
	                session.setAttribute("role", "adminlogin");
	                return "redirect:/admin.html"; // Redirect to the admin panel because the role is "admin"
	            } else {
	                return "redirect:/login.html"; // For non-admin users, redirect to another page
	            }
	        }
	    }

	    return "redirect:/adminlogin.html"; // Handle cases where either oauthUser is null or user1 is null
	}

	@PostMapping("/save")
	public String adduser(@ModelAttribute register r) {
	    try {
	        service.save(r);
	    } catch (Exception e) {
	        System.out.printf("Error saving user: " + e.getMessage(), e);
	    }
	    return "redirect:/login.html";
	}
	
	
	@PostMapping("/car")
	public String handleFileUpload(@RequestParam("carimage") MultipartFile file,@RequestParam("carmodel") String carmodel,
            @RequestParam("carnumber") String carnumber,
            @RequestParam("priceperday") String priceperday,@RequestParam("status") String status) {
	    if (!file.isEmpty()) {
	        try {
	            // Define your file storage directory
	            String uploadDir = "src/main/resources/upload";
	            File uploadPath = new File(uploadDir);

	            if (!uploadPath.exists()) {
	                uploadPath.mkdirs();
	            }

	            // Save the file to the server's file system
	            String fileName = file.getOriginalFilename();
	            java.nio.file.Path filePath = Paths.get(uploadDir, fileName);
	            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	            // Save the file path or filename to the database
	            cars car = new cars();
	            car.setCarimage(fileName);
	            car.setCarmodel(carmodel);
	            car.setCarnumber(carnumber);
	            car.setPriceperday(priceperday);
	            car.setStatus(status);
	            // Set other car details
	            carrepository.save(car);

	            return "redirect:/admincar.html";
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle the error
	        }
	    }
	    // Handle the case when no file is uploaded
	    return "redirect:/error";
	}
	 @PostMapping("/book")
	    public String bookCar(@ModelAttribute carbooking form) {
		 cbservice.bookCarAndUpdateStatus(form);
	        return "redirect:/safetyguide.html"; // Redirect to a success page or another appropriate location
	    }
}