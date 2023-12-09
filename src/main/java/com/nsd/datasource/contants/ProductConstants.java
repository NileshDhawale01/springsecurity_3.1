package com.nsd.datasource.contants;

public class ProductConstants {

	private ProductConstants() {
	}

	public static final String SEPARATOR = "/";

	public static final String PRODUCT = SEPARATOR + "product";

	public static final String USERURL = SEPARATOR + "user";

	public static final String ADMINURL = SEPARATOR + "admin";
	
	public static final String SAVEUSER = SEPARATOR + "save";
	
	public static final String ATHENTICATE = SEPARATOR + "authenticate";
	
	public static final String LATEST = SEPARATOR + "latest";
	
	public static final String SAVEPRODUCT = SEPARATOR + "saveproduct";
	
	public static final String ID = SEPARATOR + "{id}";
	
	public static final String ALLPRODUCTS = SEPARATOR + "allproduct";
	
	public static final String DATA = "Data";
	
	public static final String  SUCCESS = "success";
	
	public static final String ADMIN_AUTHORITY = "hasAuthority('ADMIN')";
	
	public static final String USER_AUTHORITY = "hasAuthority('USER')";
	
	public static final String USER_ADMIN_AUTHORITY = "hasAuthority('ADMIN') or hasAuthority('USER')";
}
