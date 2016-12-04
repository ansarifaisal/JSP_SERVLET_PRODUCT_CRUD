package com.niit.crud.product.dao;

import java.util.List;

import com.niit.crud.product.entity.Product;

public interface ProductDAO {
	
	Product getId(int id);
	List<Product> prodcuts();
	boolean deleteProduct(int id);
	boolean addProdcut(Product product);
	boolean updateProduct(Product product);
}
