package com.gst.service;

import java.util.List;

import com.gst.model.BuyerRequest;

public interface BuyerService {
	
	public void registerInfo(BuyerRequest request);

	public List<BuyerRequest> getCustomer();

	public BuyerRequest getEditCustomer(Integer id);

	public void deleteCustomer(Integer id);

	public BuyerRequest getCustomerById(Integer id);

}
