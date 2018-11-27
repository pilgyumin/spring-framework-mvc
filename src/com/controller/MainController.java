package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Cust;

@Controller
public class MainController {
	
	@Resource(name="cbiz")
	Biz<String, Cust> biz;

	@RequestMapping("/main.mc")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "login");
		mv.addObject("navi", Navi.login);
		return mv;
	}
	
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Cust dbcust = null;
		try {
			dbcust = biz.get(id);
			if(dbcust.getPwd().equals(pwd)) {
				HttpSession session = 
						request.getSession();
				session.setAttribute("login_cust", dbcust);
				mv.addObject("center", "loginok");
			}else {
				mv.addObject("center", "loginfail");
			}
		} catch (Exception e) {
			mv.addObject("center", "loginfail");
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.login);
		return mv;
	}
	
	@RequestMapping("/logout.mc")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		return "main";
	}
	@RequestMapping("/register.mc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "register");
		mv.addObject("navi", Navi.cregister);
		return mv;
	}
	
	@RequestMapping("/registerimpl.mc")
	public ModelAndView registerimpl(Cust cust) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("navi", Navi.cregister);
		try {
			biz.register(cust);
			mv.addObject("rid", cust.getId());
			mv.addObject("center", "registerok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("center", "registerfail");
			e.printStackTrace();
		}
		return mv;
	}
}





