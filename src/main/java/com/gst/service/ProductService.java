package com.gst.service;

import java.util.List;

import com.gst.model.ProductRequest;

public interface ProductService {
	
	public void registerInfo(ProductRequest request);

	public List<ProductRequest> getProducts();

	public ProductRequest getProduct(Integer id);

	public void deleteProduct(Integer id);

}
