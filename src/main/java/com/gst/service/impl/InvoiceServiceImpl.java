package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dao.InvoiceDao;
import com.gst.model.InvoiceDetailsRequest;
import com.gst.service.InvoiceService;


@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDao crudDao;

	@Override
	public void registerInfo(InvoiceDetailsRequest request) {
		crudDao.save(request);
	}

	@Override
	public List<InvoiceDetailsRequest> getInvoiceList() {
		return (List<InvoiceDetailsRequest>) crudDao.findAll();
	}

	@Override
	public InvoiceDetailsRequest getEditInvoiceDetails(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public void deleteInvoiceDetails(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public InvoiceDetailsRequest getInvoiceById(Integer id) {
		return crudDao.findOne(id);
	}

	@Override
	public InvoiceDetailsRequest getMaxRecord() {
		return crudDao.findMaxIdRecord();
	}

}
