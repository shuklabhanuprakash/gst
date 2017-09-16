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
	
	
	@PostMapping("/product")
	public ResponseEntity<ProductRequest> registerProduct(@RequestBody ProductRequest requestObj) {
		return ResponseEntity.ok(productService.registerInfo(requestObj));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductRequest>> getProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductRequest> getProduct(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(productService.getProduct(id));
	}
	@RequestMapping(value="/deleteProduct/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<ProductRequest>> deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok(productService.getProducts());
	}
	 
}
