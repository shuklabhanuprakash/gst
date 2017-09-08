package com.gst.service;

import java.util.List;

import com.gst.model.InvoiceDetailsRequest;


public interface InvoiceService {

	public void registerInfo(InvoiceDetailsRequest request);

	public List<InvoiceDetailsRequest> getInvoiceList();

	public InvoiceDetailsRequest getEditInvoiceDetails(Integer id);

	public void deleteInvoiceDetails(Integer id);

	public InvoiceDetailsRequest getInvoiceById(Integer id);
	
	public InvoiceDetailsRequest getMaxRecord();
}
