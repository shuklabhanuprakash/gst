package com.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gst.model.SellerRequest;
import com.gst.service.SellerService;

@Controller
public class CompanyController {
	@Autowired
	SellerService sellerService;

	
	@PostMapping("/seller")
	public ResponseEntity<SellerRequest>  registerSellerDetails(@RequestBody SellerRequest requestObj) {
		return ResponseEntity.ok(sellerService.registerInfo(requestObj));
	}
	
	@GetMapping("/sellers")
	public ResponseEntity<List<SellerRequest>> getSellers() {
		return ResponseEntity.ok(sellerService.getSellers());
	}
	
	@GetMapping("/seller/{id}")
	public ResponseEntity<SellerRequest> getSeller(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(sellerService.getSeller(id));
	}
	@RequestMapping(value="/deleteSeller/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<SellerRequest>> deleteSeller(@PathVariable("id") Integer id) {
		sellerService.deleteSeller(id);
		return ResponseEntity.ok(sellerService.getSellers());
	}
	
	
	
}
