package com.ync365.seed.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		 
		System.out.println("进入登陆页面");
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			response.setStatus(901);
			return "login";
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
    public String index(){
    	return "index";
    }
}
