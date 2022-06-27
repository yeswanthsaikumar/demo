package com.nagarro.javaassignment4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.javaassignment4.model.Tshirt;
import com.nagarro.javaassignment4.service.HomeService;
import com.nagarro.javaassignment4.service.UserPreferencesInput;

@Controller
@RequestMapping(path="api/v1/home")
public class HomeController {

	private final HomeService homeService;
	
	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping()
	public String gethome(HttpServletRequest request){
		
		List<Tshirt> tshirts = homeService.getTshirtData();

		HttpSession session = request.getSession();
		session.setAttribute("tshirts", tshirts);

		return "home";
	}
	
	@GetMapping("/getTshirts")
	@ResponseBody
	public List<Tshirt> getTshirts(){
		
		List<Tshirt> tshirts = homeService.getTshirtData();
		
		return tshirts;
	}
	
	
	@PostMapping()
	public String filterTshirts(UserPreferencesInput userPref,HttpServletRequest request) {
		
		
		List<Tshirt> tshirts = homeService.getTshirtData(userPref);
		
		
		for(Tshirt t : tshirts) System.out.println(t);
		
		HttpSession session = request.getSession();
		session.setAttribute("tshirts", tshirts);
		
		return "home";
	}
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		return "redirect:/api/v1/Auth";
	}
	
	
}
