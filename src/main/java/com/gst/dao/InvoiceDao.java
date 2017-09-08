package com.gst.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gst.model.InvoiceDetailsRequest;

public interface InvoiceDao extends CrudRepository<InvoiceDetailsRequest, Integer> {

	@Query("SELECT t FROM InvoiceDetailsRequest t WHERE t.id in(Select max(dd.id) from InvoiceDetailsRequest dd)")
	public InvoiceDetailsRequest findMaxIdRecord();

}
