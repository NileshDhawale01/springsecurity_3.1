package com.nsd.datasource.services.impl;


import static com.nsd.datasource.mappers.ProductMapper.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.datasource.dto.ProductsDto;
import com.nsd.datasource.entities.Products;
import com.nsd.datasource.repositoryes.ProductRepo;
import com.nsd.datasource.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Optional<ProductsDto> saveProduct(ProductsDto productsDto) {
		Products products = toProduct.apply(productsDto).get();
		return toProductDTO.apply(productRepo.save(products));
		
	}

	@Override
	public Optional<ProductsDto> getProductById(Integer id) {
		return toProductDTO.apply(productRepo.findById(id).get());
	}

	@Override
	public List<ProductsDto> getAllProducts() {
		return toProductDTOs.apply(productRepo.findAll());
	}

}
