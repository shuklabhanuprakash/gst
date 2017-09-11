package com.gst.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gst.dao.CompanyGstInfo;
import com.gst.model.RegistrationRequest;
import com.gst.service.BuyerService;
import com.gst.service.ProductService;
import com.gst.service.RegistrationService;

@Controller
public class ApplicationController {
	@Autowired
	RegistrationService registrationService;
	@Autowired
	CompanyGstInfo companyGstInfo;
	@Autowired
    BuyerService buyerService;
	@Autowired
    ProductService productService;

	/*@RequestMapping("/")
	public String login(Map<String, Object> model) {
		companyGstInfo.chkConn();
		return "index";
	}*/
	
 //registratrion 
	@RequestMapping("/registration")
	public String registration(Map<String, Object> model) {
		return "application/registration";
	}

	@RequestMapping("/invoice")
	public String invoice(Map<String, Object> model) {
		return "invoice";
	}

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping("/gstr_1")
	public String gstr1(Map<String, Object> model) {
		return "gstr1/gstr1_main_menu";
	}

	@PostMapping("/registration")
	public ResponseEntity<String> registerDetails(RegistrationRequest requestObj) {
		registrationService.registerInfo(requestObj);
		return ResponseEntity.ok("User logged");
	}

	@RequestMapping("/sellerMaster")
	public String sellerMaster(Map<String, Object> model) {
		return "masters/sellerMaster";
	}

	@RequestMapping("/consigneeMaster")
	public String consigneeMaster(Map<String, Object> model) {
		return "masters/consigneeMaster";
	}

	@RequestMapping("/consignee")
	public String getConsigneeList(Model model) {
		return "masters/buyerMaster";
	}
		
}