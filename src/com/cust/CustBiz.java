package com.cust;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Cust;

@Service("cbiz")
public class CustBiz implements Biz<String, Cust> {
	@Resource(name="cdao")
	Dao dao;
		
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(Cust v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Cust v) {
		dao.update(v);
	}

	@Override
	public Cust get(String k) {
		return (Cust) dao.select(k);
	}

	@Override
	public ArrayList<Cust> get() {
		return dao.select();
	}

}
