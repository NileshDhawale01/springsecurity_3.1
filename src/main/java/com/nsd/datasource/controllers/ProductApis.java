package com.nsd.datasource.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.datasource.dto.AuthReq;
import com.nsd.datasource.dto.ProductsDto;
import com.nsd.datasource.entities.UserInfo;
import com.nsd.datasource.services.JwtService;
import com.nsd.datasource.services.ProductService;
import com.nsd.datasource.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductApis {

	private final UserService service;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;
	
	private final ProductService productService;

	@GetMapping
	public ResponseEntity<Map<Object, Object>> getData() {
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", "This is the data " + Math.random() * 100 / 100);
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/user")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> userData() {
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", "Sakshi is the simple USER.");
		map.put("success", true);
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.OK);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> adminData() {
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", "Niesh is the ADMIN.");
		map.put("success", true);
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Map<Object, Object>> saveUser(@RequestBody UserInfo userInfo) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", service.saveUser(userInfo));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String authonticateAndToken(@RequestBody AuthReq authReq) {
		Authentication manager = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getName(), authReq.getPassword()));
		if (manager.isAuthenticated()) {
			return jwtService.generateToken(authReq.getName());
		} else {
			throw new UsernameNotFoundException(authReq.getName());
		}
	}
	
	@GetMapping("/latest")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getLetestNews(){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", "this is the common data for ADMIN and USER");
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/saveproduct")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> saveProduct(@RequestBody ProductsDto productsDto){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", productService.saveProduct(productsDto));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getProductById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", productService.getProductById(id));
		map.put("Success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/allproduct")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> getAllProducts(){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", productService.getAllProducts());
		map.put("Success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
