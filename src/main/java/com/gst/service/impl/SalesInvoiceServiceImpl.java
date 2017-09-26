package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gst.model.SalesInvoiceRequest;
import com.gst.service.SalesInvoiceService;

@Service("salesInvoiceService")
public class SalesInvoiceServiceImpl implements SalesInvoiceService {
	@Autowired
	CrudRepository<SalesInvoiceRequest, Integer> crudDao;

	@Override
	public SalesInvoiceRequest registerInfo(SalesInvoiceRequest request) {

		return crudDao.save(request);
	}

	@Override
	public List<SalesInvoiceRequest> getSalesInvoices() {
		return (List<SalesInvoiceRequest>) crudDao.findAll();
	}

	/*@Override
	public SalesInvoiceRequest getSalesInvoice(Integer id) {
		return crudDao.findOne(id);
	}*/

	@Override
	public List<SalesInvoiceRequest> deleteSalesInvoce(Integer id) {
		 crudDao.delete(id);
		 return (List<SalesInvoiceRequest>) crudDao.findAll();
	}

}
