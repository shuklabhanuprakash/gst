package com.gst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gst.model.SellerRequest;
import com.gst.service.SellerService;

@Controller
public class CompanyController {
	@Autowired
	SellerService sellerService;

	
	@RequestMapping("/sellerMaster.submit")
	public String registerSellerDetails(SellerRequest requestObj,Model model) {
		sellerService.registerInfo(requestObj);
		return "masters/sellerMaster";
	}
}
