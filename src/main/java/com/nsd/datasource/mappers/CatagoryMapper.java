package com.nsd.datasource.mappers;

import static com.nsd.datasource.util.CollectionUtil.newList;
import static com.nsd.datasource.util.FunctionUtil.evalMapper;
import static com.nsd.datasource.util.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.datasource.dto.Catagory;
import com.nsd.datasource.entities.CatagoryMaster;
public class CatagoryMapper {

	private CatagoryMapper() {}
	
	public static final Function<CatagoryMaster, Optional<Catagory>> toCatagory = e->evalMapper(e, Catagory.class);
	
	public static final Function<Catagory, Optional<CatagoryMaster>> toCatatoryMaster = e-> evalMapper(e, CatagoryMaster.class);
	
	public static final Function<Collection<CatagoryMaster>, List<Catagory>> toCatagorys = e->newList(evalMapperCollection(e, Catagory.class));
	
	public static final Function<Collection<Catagory>, List<CatagoryMaster>> toCatagoryMasters = e-> newList(evalMapperCollection(e, CatagoryMaster.class));
}