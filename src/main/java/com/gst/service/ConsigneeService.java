package com.gst.service;

import java.util.List;

import com.gst.model.ConsigneeRequest;

public interface ConsigneeService {
	
	
	public List<ConsigneeRequest> getAllConsignee();

	public ConsigneeRequest getEditConsignee(Integer id);

	public void deleteConsignee(Integer id);

	public List<ConsigneeRequest> getConsigneeByBuyerId(Integer buyereId);
	
	public ConsigneeRequest getConsigneeById(Integer id);

	public void saveConsignee(ConsigneeRequest requestObj);

}
