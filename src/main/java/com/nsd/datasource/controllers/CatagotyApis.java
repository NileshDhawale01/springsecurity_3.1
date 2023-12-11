package com.nsd.datasource.controllers;

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
@RequestMapping("/catagory")
public class CatagotyApis {

	@Autowired
	private CatagoryService catagoryService;
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getAllCatagorys(){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", catagoryService.getAllCatagorys());
		map.put("Success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getChatagoryById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", catagoryService.getCatagoryById(id));
		map.put("success", "");
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> saveChatagory(@RequestBody Catagory catagory){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", catagoryService.saveCatagory(catagory));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
