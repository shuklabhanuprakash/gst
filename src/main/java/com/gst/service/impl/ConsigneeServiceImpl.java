package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gst.dao.ConsigneeDao;
import com.gst.model.BuyerRequest;
import com.gst.model.ConsigneeRequest;
import com.gst.service.BuyerService;
import com.gst.service.ConsigneeService;



@Component("consigneeService")
public class ConsigneeServiceImpl implements ConsigneeService {
	@Autowired
	ConsigneeDao consigneeDao;
	@Autowired
	BuyerService buyerService;
	@Autowired
	ConsigneeService consigneeService;

	@Override
	public List<ConsigneeRequest> getAllConsignee() {
		return (List<ConsigneeRequest>) consigneeDao.findAll();
	}

	@Override
	public ConsigneeRequest getEditConsignee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteConsignee(Integer id) {
		consigneeDao.delete(id);

	}

	@Override
	public List<ConsigneeRequest> getConsigneeByBuyerId(Integer buyereId) {

		BuyerRequest buyerRequest = buyerService.getEditCustomer(buyereId);
		if(null != buyerRequest){
			return consigneeDao.findByBuyerRequest(buyerRequest);
		}
		
		return null ;
	}

	@Override
	public ConsigneeRequest getConsigneeById(Integer id) {
		return consigneeDao.findOne(id);
	}

	@Override
	public void saveConsignee(ConsigneeRequest requestObj) {
		ConsigneeRequest consignee = consigneeDao.save(requestObj);
		System.out.println(consignee);
	}
}
