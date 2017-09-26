package com.gst.dao;

import org.springframework.data.repository.CrudRepository;

import com.gst.model.SalesInvoiceRequest;


public interface SalesInvoiceDao extends CrudRepository<SalesInvoiceRequest, Integer> {

}
