package com.gst.service;

import java.util.List;

import com.gst.model.PurchaseInvoiceRequest;

public interface PurchaseInvoiceService {
	
	public PurchaseInvoiceRequest registerInfo(PurchaseInvoiceRequest request);

	public List<PurchaseInvoiceRequest> getPurchaseInvoices();

	//public PurchaseInvoiceRequest getPurchaseInvoice(Integer id);

	public List<PurchaseInvoiceRequest> deletePurchaseInvoce(Integer id);

}
