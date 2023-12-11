package com.nsd.datasource.mappers;

import static com.nsd.datasource.mappers.CatagoryMapper.toCatagory;
import static com.nsd.datasource.mappers.CatagoryMapper.toCatatoryMaster;
import static com.nsd.datasource.util.FunctionUtil.evalMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nsd.datasource.dto.ProductsDto;
import com.nsd.datasource.entities.Products;

public class ProductMapper {

	private ProductMapper() {}
	
	public static final Function<ProductsDto, Optional<Products>> toProduct = e->{
		Optional<Products> pro = evalMapper(e,Products.class);
		pro.ifPresent(p->{
			p.setCatagoryMaster(toCatatoryMaster.apply(e.getCatagory()).get());
		});
		return pro;
	};
	
	public static final Function<Products, Optional<ProductsDto>> toProductDTO = e->{
		Optional<ProductsDto> proDto = evalMapper(e, ProductsDto.class);
		
		proDto.ifPresent(p->{
			p.setCatagory(toCatagory.apply(e.getCatagoryMaster()).get());
		});
		return proDto;
	};

	public static final Function<Collection<ProductsDto>, List<Products>> toProducts =e->{
		return e.stream().map(pro->toProduct.apply(pro).get()).collect(Collectors.toList());
	};
	
	public static final Function<Collection<Products>, List<ProductsDto>> toProductDTOs = e->{
		return e.stream().map(p->toProductDTO.apply(p).get()).collect(Collectors.toList());
	};
}
