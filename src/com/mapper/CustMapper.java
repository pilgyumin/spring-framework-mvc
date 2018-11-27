package com.mapper;

import java.util.ArrayList;

import com.vo.Cust;

public interface CustMapper {
	public void insert(Cust obj);
	public void delete(String obj);
	public void update(Cust obj);
	public Object select(String obj);
	public ArrayList<Cust> selectall();
}



