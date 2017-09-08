package com.gst.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.BuyerRequest;
import com.gst.model.ConsigneeRequest;

public interface ConsigneeDao extends CrudRepository<ConsigneeRequest, Integer>{
	
	public List<ConsigneeRequest> findByBuyerRequest(BuyerRequest request);
	 
	//public ConsigneeRequest findOneConsigneeRequest(Integer id);

}
