package com.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gst.model.PurchaseInvoiceRequest;
import com.gst.service.PurchaseInvoiceService;

@Service("purchaseInvoiceService")
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {
	@Autowired
	CrudRepository<PurchaseInvoiceRequest, Integer> crudDao;

	@Override
	public PurchaseInvoiceRequest registerInfo(PurchaseInvoiceRequest request) {

		return crudDao.save(request);
	}

	@Override
	public List<PurchaseInvoiceRequest> getPurchaseInvoices() {
		return (List<PurchaseInvoiceRequest>) crudDao.findAll();
	}

	/*@Override
	public SalesInvoiceRequest getPurchaseInvoice(Integer id) {
		return crudDao.findOne(id);
	}*/

	@Override
	public List<PurchaseInvoiceRequest> deletePurchaseInvoce(Integer id) {
		 crudDao.delete(id);
		 return (List<PurchaseInvoiceRequest>) crudDao.findAll();
	}

}
