package com.gst.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gst.model.SalesInvoiceRequest;
import com.gst.service.SalesInvoiceService;


@Controller
public class SalesInvoiceController {

	@Autowired
	private SalesInvoiceService salesInvoiceService;


	@RequestMapping("/salesInvoice")
	public String salesInvoice(Map<String, Object> model) {
		return "invoice/salesInvoice";
	}
	
	
	@PostMapping("/salesInvoice")
	public ResponseEntity<SalesInvoiceRequest> registerSalesInvoice(@RequestBody SalesInvoiceRequest requestObj) {
		return ResponseEntity.ok(salesInvoiceService.registerInfo(requestObj));
	}
	
	@GetMapping("/salesInvoices")
	public ResponseEntity<List<SalesInvoiceRequest>> getsalesInvoices() {
		return ResponseEntity.ok(salesInvoiceService.getSalesInvoices());
	}
	
	
	@RequestMapping(value="/deleteSalesInvoice/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<SalesInvoiceRequest>> deleteSalesInvoice(@PathVariable("id") Integer id) {
		salesInvoiceService.deleteSalesInvoce(id);
		return ResponseEntity.ok(salesInvoiceService.getSalesInvoices());
	}
	 
}
