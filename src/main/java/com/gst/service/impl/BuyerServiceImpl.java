package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dao.BuyerDao;
import com.gst.model.BuyerRequest;
import com.gst.service.BuyerService;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	BuyerDao crudDao;

	@Override
	public BuyerRequest registerInfo(BuyerRequest request) {

		return crudDao.save(request);
	}

	@Override
	public List<BuyerRequest> getBuyers() {
		return (List<BuyerRequest>) crudDao.findAll();
	}

	@Override
	public BuyerRequest getEditCustomer(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public void deleteCustomer(Integer id) {
		crudDao.delete(id);
		
	}

	@Override
	public BuyerRequest getCustomerById(Integer id) {
		return crudDao.findOne(id);
	}
	

}
