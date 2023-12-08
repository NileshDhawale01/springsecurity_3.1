package com.nsd.datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {

	private Integer productId;
	
	private String productName;
	
	private String productDesc;
	
	private Float productPrice;
}
