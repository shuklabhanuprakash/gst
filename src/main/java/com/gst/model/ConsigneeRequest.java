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
@Table(name="MA_CONSIGNEE")
public class ConsigneeRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="GSTIN")
	private String gstID;
	@Column(name="CONSIGNEE_COMPANY_NAME")
	private String cosigneeName;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="ADDRESS_2")
	private String address2;
	@Column(name="ADDRESS_3")
	private String address3;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="STATE_CODE")
	private String stateCode;
	@Column(name="PIN_CODE")
	private Integer pinCode;
	@Column(name="CONSIGNEE_CONTACT_NAME")
	private String consigneeContactName;
	@Column(name="CONSIGNEE_CONTACT_DETAIL")
	private String consigneeContactDetail;
	
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

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getConsigneeContactName() {
		return consigneeContactName;
	}

	public void setConsigneeContactName(String consigneeContactName) {
		this.consigneeContactName = consigneeContactName;
	}

	public String getConsigneeContactDetail() {
		return consigneeContactDetail;
	}

	public void setConsigneeContactDetail(String consigneeContactDetail) {
		this.consigneeContactDetail = consigneeContactDetail;
	}

	
}
