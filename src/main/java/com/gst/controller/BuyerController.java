package com.gst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gst.model.BuyerRequest;
import com.gst.model.ConsigneeRequest;
import com.gst.model.ProductRequest;
import com.gst.service.BuyerService;
import com.gst.service.ConsigneeService;
import com.gst.service.ProductService;

@Controller
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	@Autowired
	ConsigneeService consigneeService;
	@Autowired
	ProductService productService;

	@RequestMapping("/buyerMaster")
	public String buyerMaster(@RequestParam(value = "id", required = false) Integer id, Model model) {
		if (null != id) {
			model.addAttribute("editCustomer", buyerService.getEditCustomer(id));
			model.addAttribute("consignee", consigneeService.getConsigneeByBuyerId(id));
			//model.addAttribute("editConsignee", buyerService.registerInfo(requestObj);;
		}
		return "masters/buyerMaster";
	}

	@RequestMapping("/buyerMaster.submit")
	public String registerBuyerDetails(@RequestBody BuyerRequest requestObj, Model model) {
		buyerService.registerInfo(requestObj);
		return "masters/buyerMaster";
	}

	@RequestMapping("/customer")
	public String getCustomerList(Model model) {
		model.addAttribute("customer", buyerService.getCustomer());
		return "customerViewList";
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(Model model, @RequestParam("id") Integer id) {
		buyerService.deleteCustomer(id);
		return getCustomerList(model);
	}

	@RequestMapping(value = "/consignee", method = RequestMethod.GET)
	@ResponseBody
	public ConsigneeRequest editConsignee(@RequestParam("id") Integer id){
		return consigneeService.getConsigneeById(id);
		
	}
	
	@RequestMapping(value = "/deleteConsignee", method = RequestMethod.GET)
	public void deleteConsignee(@RequestParam("id") Integer id){
		 consigneeService.deleteConsignee(id);
	}
	@RequestMapping(value="/createInvoice",method=RequestMethod.GET)
	public String createInvoice(Model model){
		model.addAttribute("customerList",buyerService.getCustomer());
		model.addAttribute("productList",productService.getProducts());
		return "createInvoice1";
	}
	
	@RequestMapping(value = "/getCustomerById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BuyerRequest> getCustomerById(@RequestParam("id") Integer id){
	System.out.println("listExistingUser is called in controller");
	BuyerRequest buyer=buyerService.getCustomerById(id);
	//consigneeService.getConsigneeById(id);
	return new ResponseEntity<BuyerRequest>(buyer,HttpStatus.OK); 
	}
	
	@RequestMapping(value= "/getHSNcodeById", method =RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ProductRequest> getHSNcodeById(@RequestParam("id") Integer id){
	ProductRequest product=	productService.getProduct(id);
	return new ResponseEntity<ProductRequest>(product,HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/getConsigneeById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ConsigneeRequest> getConsigneeById(@RequestParam("id") Integer id){
	ConsigneeRequest consignee= consigneeService.getConsigneeById(id);
	return new ResponseEntity<ConsigneeRequest>(consignee,HttpStatus.OK); 
	}
	

	
}
