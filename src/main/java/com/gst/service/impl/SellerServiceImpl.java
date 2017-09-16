package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dao.SellerDao;
import com.gst.model.SellerRequest;
import com.gst.service.SellerService;

@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	@Autowired
	SellerDao crudDao;

	@Override
	public SellerRequest registerInfo(SellerRequest request) {
		return crudDao.save(request);
	}

	@Override
	public List<SellerRequest> getSellers() {
		return (List<SellerRequest>) crudDao.findAll();
	}

	@Override
	public SellerRequest getSeller(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public List<SellerRequest> deleteSeller(Integer id) {
		crudDao.delete(id);
		return (List<SellerRequest>) crudDao.findAll();
	}

}
