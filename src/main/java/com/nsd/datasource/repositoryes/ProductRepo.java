package com.nsd.datasource.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.datasource.entities.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

}
