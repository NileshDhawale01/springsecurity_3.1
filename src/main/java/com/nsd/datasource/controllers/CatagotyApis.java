package com.nsd.datasource.controllers;

import static com.nsd.datasource.contants.ProductConstants.ADMIN_AUTHORITY;
import static com.nsd.datasource.contants.ProductConstants.ALLCATAGORY;
import static com.nsd.datasource.contants.ProductConstants.CATAGORY;
import static com.nsd.datasource.contants.ProductConstants.DATA;
import static com.nsd.datasource.contants.ProductConstants.ID;
import static com.nsd.datasource.contants.ProductConstants.SAVE;
import static com.nsd.datasource.contants.ProductConstants.SUCCESS;
import static com.nsd.datasource.contants.ProductConstants.USER_ADMIN_AUTHORITY;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.datasource.dto.Catagory;
import com.nsd.datasource.services.CatagoryService;

@RestController
@RequestMapping(CATAGORY)
public class CatagotyApis {

	@Autowired
	private CatagoryService catagoryService;

	@GetMapping(ALLCATAGORY)
	@PreAuthorize(USER_ADMIN_AUTHORITY)
	public ResponseEntity<Map<Object, Object>> getAllCatagorys() {
		Map<Object, Object> map = new HashMap<>();
		map.put(DATA, catagoryService.getAllCatagorys());
		map.put(SUCCESS, true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping(ID)
	@PreAuthorize(USER_ADMIN_AUTHORITY)
	public ResponseEntity<Map<Object, Object>> getChatagoryById(@PathVariable Integer id) {
		Map<Object, Object> map = new HashMap<>();
		map.put(DATA, catagoryService.getCatagoryById(id));
		map.put(SUCCESS, true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping(SAVE)
	@PreAuthorize(ADMIN_AUTHORITY)
	public ResponseEntity<Map<Object, Object>> saveChatagory(@RequestBody Catagory catagory) {
		Map<Object, Object> map = new HashMap<>();
		map.put(DATA, catagoryService.saveCatagory(catagory));
		map.put(SUCCESS, true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
