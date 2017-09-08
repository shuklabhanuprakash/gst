package com.gst.dao;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.BuyerRequest;

public interface BuyerDao extends CrudRepository<BuyerRequest, Integer>{

}
