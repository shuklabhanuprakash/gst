package com.gst.dao;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.PurchaseInvoiceRequest;


public interface PurchaseInvoiceDao extends CrudRepository<PurchaseInvoiceRequest, Integer> {

}
