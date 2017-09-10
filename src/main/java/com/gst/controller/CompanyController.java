package com.gst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.gst.model.SellerRequest;
import com.gst.service.SellerService;

@Controller
public class CompanyController {
	@Autowired
	SellerService sellerService;

	
	@PostMapping("/seller")
	public ResponseEntity<SellerRequest>  registerSellerDetails(SellerRequest requestObj) {
		return ResponseEntity.ok(sellerService.registerInfo(requestObj));
	}
}
