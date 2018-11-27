package com.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;

@Controller
public class ProductController {

	@Resource(name="pbiz")
	Biz<Integer, Product> biz;
	
	@RequestMapping("/padd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "product/register");
		mv.addObject("navi", Navi.Padd);
		return mv;
	}
	
	@RequestMapping("/paddimpl.mc")
	public ModelAndView paddimpl(Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		
		MultipartFile mf = product.getMf();
		String img = mf.getOriginalFilename();
		product.setImgname(img);
		byte[] data;
		
		try {
			data = mf.getBytes();
			FileOutputStream out = 
            new FileOutputStream(
		     "c:/spring/smvc3/WebContent/img/"+img);
			out.write(data);
			out.close();

			System.out.println("Asdasd");
			biz.register(product);
			mv.addObject("pname", img);
			mv.addObject("center", "product/registerok");

		} catch (Exception e) {
			mv.addObject("center", "product/registerfail");
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.Padd);
		return mv;
	}
	
	@RequestMapping("/plist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> ar = null;
		mv.setViewName("main");
		
		try {
			ar=biz.get();
			mv.addObject("plist", ar);
			mv.addObject("center", "product/plist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.Padd);
		return mv;
	}
	
	@RequestMapping("/pdetail.mc")
	public ModelAndView pdetail(HttpServletRequest request) {
		System.out.println("Asd");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = null;
		try {
			product = biz.get(id);
			mv.addObject("dp",product);
			mv.addObject("center", "product/pdetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.pdetail);
		return mv;
	}
	
	@RequestMapping("/pupdate.mc")
	public ModelAndView pupdate(HttpServletRequest request) {
		System.out.println("Asd");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = null;
		try {
			product = biz.get(id);
			mv.addObject("up",product);
			mv.addObject("center", "product/pupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.pdetail);
		return mv;
	}
	
	@RequestMapping("/pupdateimpl.mc")
	public ModelAndView pupdateimpl(Product p) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		Product input = new Product(p.getId(),p.getName(),p.getPrice(),p.getRegdate(),p.getImgname());
		try {
			biz.modify(input);
			mv.addObject("rproduct", input);
			mv.addObject("center", "product/updateok");
		} catch (Exception e) {
			mv.addObject("center", "product/updatefail");
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.pdetail);
		return mv;
	}
	
	@RequestMapping("/pdelete.mc")
	public ModelAndView pdelete(Product p) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			biz.remove(p.getId());
			mv.addObject("rproduct",p);
			mv.addObject("center", "product/deleteok");
		} catch (Exception e) {
			mv.addObject("center", "product/deletefail");
			e.printStackTrace();
		}
		mv.addObject("navi", Navi.pdetail);
		return mv;
	}
	
}
