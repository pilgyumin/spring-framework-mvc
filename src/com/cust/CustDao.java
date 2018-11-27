package com.cust;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CustMapper;
import com.vo.Cust;
@Repository("cdao")
public class CustDao 
    implements Dao<String, Cust> {

	@Autowired
	CustMapper cm;
	
	@Override
	public void insert(Cust v) {
		cm.insert(v);
	}

	@Override
	public void delete(String k) {
		cm.delete(k);		
	}

	@Override
	public void update(Cust v) {
		cm.update(v);
	}

	@Override
	public Cust select(String k) {
		return (Cust) cm.select(k);
	}

	@Override
	public ArrayList<Cust> select() {
		return cm.selectall();
	}

	

}
