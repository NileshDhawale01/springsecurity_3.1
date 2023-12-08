package com.nsd.datasource.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.nsd.datasource.dto.ProductsDto;

@Transactional(readOnly = false)
public interface ProductService {

	Optional<ProductsDto> saveProduct(ProductsDto productsDto);
	
	Optional<ProductsDto> getProductById(Integer id);
	
	List<ProductsDto> getAllProducts();
}
