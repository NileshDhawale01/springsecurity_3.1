package com.nsd.datasource.services;

import java.util.List;

import com.nsd.datasource.dto.Catagory;

public interface CatagoryService {

	List<Catagory> getAllCatagorys();
	
	Catagory getCatagoryById(Integer id);
	
	Catagory saveCatagory(Catagory catagory);
}
