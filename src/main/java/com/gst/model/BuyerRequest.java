package com.gst.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BUYER")
public class BuyerRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String gstID;
	@Column
	private String buyerName;
	@Column
	private String state;
	@Column
	private String stateCode;
	@Column
	private Integer pinCode;
	@Column
	private Long phoneNo;
	@Column
	private Integer faxNo;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String address1;
	@Column
	private String country;
	@Column
	private String branchCode;
	@Column
	private String website;
	@Column
	private String vatNo;
	@Column
	private String taxCat;

	@OneToMany(mappedBy = "buyerRequest", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ConsigneeRequest> consigneeRequests;

	/*@OneToOne(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private InvoiceDetailsRequest customerId;

	@OneToOne(mappedBy = "consigneeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private InvoiceDetailsRequest consigneeId;*/

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

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(Integer faxNo) {
		this.faxNo = faxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	public String getTaxCat() {
		return taxCat;
	}

	public void setTaxCat(String taxCat) {
		this.taxCat = taxCat;
	}

	public List<ConsigneeRequest> getConsigneeRequests() {
		return consigneeRequests;
	}

	public void setConsigneeRequests(List<ConsigneeRequest> consigneeRequests) {
		this.consigneeRequests = consigneeRequests;
	}

	/*public InvoiceDetailsRequest getCustomerId() {
		return customerId;
	}

	public void setCustomerId(InvoiceDetailsRequest customerId) {
		this.customerId = customerId;
	}

	public InvoiceDetailsRequest getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(InvoiceDetailsRequest consigneeId) {
		this.consigneeId = consigneeId;
	}*/

}
