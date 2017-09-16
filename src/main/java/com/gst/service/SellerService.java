package com.gst.service;

import java.util.List;

import com.gst.model.SellerRequest;

public interface SellerService {
	
	public SellerRequest registerInfo(SellerRequest request);
	
	public List<SellerRequest> getSellers();

	public SellerRequest getSeller(Integer id);

	public List<SellerRequest> deleteSeller(Integer id);

}
