package com.myblog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest){
		String header=httpServletRequest.getHeader("User-Agent");
		System.out.println("Header  :"+header);
		
		return "login";
		   
	}
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("home pringt");
		return "home";
	}
}
