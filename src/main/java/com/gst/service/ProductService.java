package com.gst.service;

import java.util.List;

import com.gst.model.ProductRequest;

public interface ProductService {
	
	public ProductRequest registerInfo(ProductRequest request);

	public List<ProductRequest> getProducts();

	public ProductRequest getProduct(Integer id);

	public List<ProductRequest> deleteProduct(Integer id);

}
