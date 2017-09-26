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

import com.gst.model.PurchaseInvoiceRequest;
import com.gst.service.PurchaseInvoiceService;


@Controller
public class PuchaseInvoiceController {

	@Autowired
	private PurchaseInvoiceService purchaseInvoiceService;


	@RequestMapping("/purchaseInvoice")
	public String purchaseInvoice(Map<String, Object> model) {
		return "invoice/purchaseInvoice";
	}
	
	
	@PostMapping("/purchaseInvoice")
	public ResponseEntity<PurchaseInvoiceRequest> registerPurchaseInvoice(@RequestBody PurchaseInvoiceRequest requestObj) {
		return ResponseEntity.ok(purchaseInvoiceService.registerInfo(requestObj));
	}
	
	@GetMapping("/puchaseInvoices")
	public ResponseEntity<List<PurchaseInvoiceRequest>> getPurchaseInvoices() {
		return ResponseEntity.ok(purchaseInvoiceService.getPurchaseInvoices());
	}
	
	
	@RequestMapping(value="/deletePurchaseInvoice/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<PurchaseInvoiceRequest>> deletePurchaseInvoice(@PathVariable("id") Integer id) {
		purchaseInvoiceService.deletePurchaseInvoce(id);
		return ResponseEntity.ok(purchaseInvoiceService.getPurchaseInvoices());
	}
	 
}
