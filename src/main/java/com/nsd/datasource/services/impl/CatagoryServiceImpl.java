package com.nsd.datasource.services.impl;

import static com.nsd.datasource.mappers.CatagoryMapper.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.datasource.dto.Catagory;
import com.nsd.datasource.entities.CatagoryMaster;
import com.nsd.datasource.repositoryes.CatagoryMasterRepo;
import com.nsd.datasource.services.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService{

	@Autowired
	private CatagoryMasterRepo catagoryMasterRepo;
	
	@Override
	public List<Catagory> getAllCatagorys() {
		return toCatagorys.apply(catagoryMasterRepo.findAll());
	}

	@Override
	public Catagory getCatagoryById(Integer id) {
		return toCatagory.apply(catagoryMasterRepo.findById(id).get()).orElseThrow(()->new RuntimeException());
	}

	@Override
	public Catagory saveCatagory(Catagory catagory) {
		CatagoryMaster catagoryMaster = toCatatoryMaster.apply(catagory).get();
		return toCatagory.apply(catagoryMasterRepo.save(catagoryMaster)).get();
	}

}
