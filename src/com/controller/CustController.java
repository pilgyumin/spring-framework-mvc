package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Cust;

@Controller
public class CustController {

	@Resource(name = "cbiz")
	Biz<String, Cust> biz;

	@RequestMapping("/cadd.mc")
	public ModelAndView cadd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Cust cust = null;
		mv.setViewName("main");
		try {
			mv.setViewName("main");
			mv.addObject("center", "cust/cadd");
			mv.addObject("navi", Navi.cadd);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/caddimpl.mc")
	public ModelAndView caddimpl(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Cust cust = null;
		mv.setViewName("main");
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			cust = biz.get(id);
			if (cust == null) {
				cust = new Cust(id, pwd, name, age);
				biz.register(cust);
				mv.addObject("rcust", cust);
				mv.addObject("center", "cust/addok");
			} else {
				mv.addObject("center", "cust/addfail");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/clist.mc")
	public ModelAndView clist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;
		mv.setViewName("main");
		try {
			list = biz.get();
			mv.addObject("clist", list);
			mv.addObject("center", "cust/clist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/cupdate.mc")
	public ModelAndView cupdate(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			mv.setViewName("main");
			String id = request.getParameter("id");
			mv.addObject("cid", id);
			mv.addObject("center", "cust/cupdate");
			mv.addObject("navi", Navi.cupdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/cupdateimpl.mc")
	public ModelAndView cupdateimpl(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Cust cust = null;
		mv.setViewName("main");
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			cust = biz.get(id);
			cust = new Cust(id, pwd, name, age);
			biz.modify(cust);
			mv.addObject("rcust", cust);
			mv.addObject("center", "cust/updateok");
			
		} catch (Exception e) {
			mv.addObject("center", "cust/updatefail");
			e.printStackTrace();
		}
		return mv;
	}

}
