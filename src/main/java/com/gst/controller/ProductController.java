package com.gst.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gst.model.ProductRequest;
import com.gst.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;


	@RequestMapping("/productMaster")
	public String productMaster(Map<String, Object> model) {
		return "masters/productMaster";
	}
	
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public void registerProduct(@RequestBody ProductRequest requestObj,Model model) {
		productService.registerInfo(requestObj);
		//return "masters/productMaster";
	}
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products",productService.getProducts());
		return "masters/productMaster";
	}
	/*@RequestMapping(value="/product",method=RequestMethod.GET)
	public String getProduct(Model model,@RequestParam("id") Integer id) {
		model.addAttribute("product",productService.getProduct(id));
		return "masters/productMaster";
	}*/
	@RequestMapping(value="/deleteProduct/{id}",method=RequestMethod.GET)
	public void deleteProduct(Model model,@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	 
}
