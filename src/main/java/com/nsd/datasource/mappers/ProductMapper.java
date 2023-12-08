package com.nsd.datasource.mappers;

import static com.nsd.datasource.util.CollectionUtil.newList;
import static com.nsd.datasource.util.FunctionUtil.evalMapper;
import static com.nsd.datasource.util.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.datasource.dto.ProductsDto;
import com.nsd.datasource.entities.Products;

public class ProductMapper {

	private ProductMapper() {}
	
	public static final Function<ProductsDto, Optional<Products>> toProduct = e->evalMapper(e,Products.class);
	
	public static final Function<Products, Optional<ProductsDto>> toProductDTO = e->evalMapper(e, ProductsDto.class);
	
	public static final Function<Collection<ProductsDto>, List<Products>> toProducts =e-> newList(evalMapperCollection(e, Products.class));
	
	public static final Function<Collection<Products>, List<ProductsDto>> toProductDTOs = e->newList(evalMapperCollection(e, ProductsDto.class));
}
