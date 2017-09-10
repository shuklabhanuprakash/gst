package com.gst.service;

import java.util.List;

import com.gst.model.BuyerRequest;

public interface BuyerService {
	
	public BuyerRequest registerInfo(BuyerRequest request);

	public List<BuyerRequest> getBuyers();

	public BuyerRequest getEditCustomer(Integer id);

	public void deleteCustomer(Integer id);

	public BuyerRequest getCustomerById(Integer id);

}
