package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ProductMapper;
import com.vo.Product;

@Repository("pdao")
public class ProductDao implements Dao<Integer, Product> {
	
	@Autowired
	ProductMapper pm;

	@Override
	public void insert(Product v){
		pm.insert(v);
	}

	@Override
	public void delete(Integer k) {
		pm.delete(k);

	}

	@Override
	public void update(Product v) {
		pm.update(v);

	}

	@Override
	public Product select(Integer k) {
		
		return pm.select(k);
	}

	@Override
	public ArrayList<Product> select(){
		
		return pm.selectall();
	}

}
