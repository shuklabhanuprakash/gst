package com.gst.service;

import java.util.List;

import com.gst.model.SalesInvoiceRequest;

public interface SalesInvoiceService {
	
	public SalesInvoiceRequest registerInfo(SalesInvoiceRequest request);

	public List<SalesInvoiceRequest> getSalesInvoices();

	//public SalesInvoiceRequest getSalesInvoice(Integer id);

	public List<SalesInvoiceRequest> deleteSalesInvoce(Integer id);

}
