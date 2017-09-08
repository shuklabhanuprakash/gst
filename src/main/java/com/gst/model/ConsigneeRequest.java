package com.gst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CONSIGNEE")
public class ConsigneeRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String gstID;
	@Column
	private String cosigneeName;
	@Column
	private String address;
	@Column
	private String state;
	@Column
	private String companyName;
	@Column
	private String country;
	
	@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="buyer_id")
	private BuyerRequest buyerRequest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGstID() {
		return gstID;
	}

	public void setGstID(String gstID) {
		this.gstID = gstID;
	}

	public String getCosigneeName() {
		return cosigneeName;
	}

	public void setCosigneeName(String cosigneeName) {
		this.cosigneeName = cosigneeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BuyerRequest getBuyerRequest() {
		return buyerRequest;
	}

	public void setBuyerRequest(BuyerRequest buyerRequest) {
		this.buyerRequest = buyerRequest;
	}

	
}
