package com.gst.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gst.model.BuyerRequest;
import com.gst.model.ConsigneeRequest;
import com.gst.model.ProductRequest;
import com.gst.service.BuyerService;
import com.gst.service.ConsigneeService;
import com.gst.service.ProductService;

@RestController
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	@Autowired
	ConsigneeService consigneeService;
	@Autowired
	ProductService productService;

	@GetMapping("/buyer/{id}")
	public ResponseEntity<BuyerRequest> buyerMaster(@PathVariable(value = "id", required = true) Integer id) {
		return ResponseEntity.ok(buyerService.getEditCustomer(id));
	}

	@PostMapping("/buyer")
	public ResponseEntity<BuyerRequest> registerBuyerDetails(@RequestBody BuyerRequest requestObj) {
		return ResponseEntity.ok(buyerService.registerInfo(requestObj));
	}

	@GetMapping("/buyers")
	public ResponseEntity<List<BuyerRequest>> getBuyers() {
		return ResponseEntity.ok(buyerService.getBuyers());
	}

	@RequestMapping(value = "/deleteBuyer", method = RequestMethod.GET)
	public ResponseEntity<List<BuyerRequest>> deleteCustomer(@RequestParam("id") Integer id) {
		buyerService.deleteCustomer(id);
		return ResponseEntity.ok(buyerService.getBuyers());
	}

	@GetMapping(value = "/consignee")
	public ResponseEntity<ConsigneeRequest> getConsigneeById(@RequestParam("id") Integer id) {
		return ResponseEntity.ok(consigneeService.getConsigneeById(id)) ;

	}

	@RequestMapping(value = "/deleteConsignee", method = RequestMethod.GET)
	public void deleteConsignee(@RequestParam("id") Integer id) {
		consigneeService.deleteConsignee(id);
	}
	
	@RequestMapping(value = "/consigneeByBuyerId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ConsigneeRequest>> getConsigneeByBuyerId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(consigneeService.getConsigneeByBuyerId(id));
	}
	
	
	@PostMapping("/consignee")
	public ResponseEntity<List<ConsigneeRequest>> saveConsignee(@RequestBody ConsigneeRequest requestObj) {
		
		consigneeService.saveConsignee(requestObj);
		
		return  ResponseEntity.ok(consigneeService.getConsigneeByBuyerId(requestObj.getBuyerRequest().getId()));
	}
	

}
