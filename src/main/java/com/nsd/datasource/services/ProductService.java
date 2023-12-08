package com.nsd.datasource.services;

import java.util.List;
import java.util.Optional;

import com.nsd.datasource.dto.ProductsDto;

public interface ProductService {

	Optional<ProductsDto> saveProduct(ProductsDto productsDto);
	
	Optional<ProductsDto> getProductById(Integer id);
	
	List<ProductsDto> getAllProducts();
}
