package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Product;

@Service("pbiz")
public class ProductBiz implements Biz<Integer, Product> {
	
	@Resource(name="pdao")
	Dao dao;

	@Override
	public void register(Product v) {
		dao.insert(v);
		System.out.println("register ok...");
	}

	@Override
	public void remove(Integer k) {
		dao.delete(k);
		System.out.println("delete ok...");
	}

	@Override
	public void modify(Product v) {
		dao.update(v);
		System.out.println("modify ok...");
	}

	@Override
	public Product get(Integer k) {
		System.out.println("select ok...");
		return (Product) dao.select(k);
	}

	@Override
	public ArrayList<Product> get() {
		System.out.println("selectall ok...");
		return dao.select();
	}

}
