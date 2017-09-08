package com.gst.dao;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.ProductRequest;


public interface ProductDao extends CrudRepository<ProductRequest, Integer> {

}
