package com.gst.dao;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.SellerRequest;


public interface SellerDao extends CrudRepository<SellerRequest, Integer> {

}
