package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gst.model.ProductRequest;
import com.gst.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	CrudRepository<ProductRequest, Integer> crudDao;

	@Override
	public void registerInfo(ProductRequest request) {

		crudDao.save(request);
	}

	@Override
	public List<ProductRequest> getProducts() {
		return (List<ProductRequest>) crudDao.findAll();
	}

	@Override
	public ProductRequest getProduct(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public void deleteProduct(Integer id) {
		 crudDao.delete(id);
	}

}
