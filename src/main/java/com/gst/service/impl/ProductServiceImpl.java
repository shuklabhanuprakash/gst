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
	public ProductRequest registerInfo(ProductRequest request) {

		return crudDao.save(request);
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
	public List<ProductRequest> deleteProduct(Integer id) {
		 crudDao.delete(id);
		 return (List<ProductRequest>) crudDao.findAll();
	}

}
