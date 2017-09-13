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
@Table(name = "MA_BUYER")
public class BuyerRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column  (name="GSTIN")
	private String gstID;
	@Column (name="CLIENT_NAME")
	private String buyerName;
	@Column (name="STATE")
	private String state;
	@Column (name="STATE_CODE")
	private String stateCode;
	@Column (name="PIN_CODE")
	private Integer pinCode;
	@Column (name="CLIENT_PHONE_NO")
	private Long phoneNo;
	@Column (name="CLIENT_FAX_NO")
	private Integer faxNo;
	@Column (name="CLIENT_EMAIL_ID ")
	private String email;
	@Column (name="SHIP_ADDRESS_1")
	private String address;
	@Column (name="SHIP_ADDRESS_2")
	private String address1;
	@Column (name="SHIP_COUNTRY")
	private String country;
	@Column(name="BRANCH_CODE")
	private String branchCode;
	@Column (name="WEBSITE")
	private String website;
	@Column (name="VAT_NO")
	private String vatNo;
	@Column (name="TAX_CAT")
	private String taxCat;
	@Column (name="PRIMARY_CONTACT_PERSON")
	private String primaryContactPerson;
	@Column (name="CONTACT_MOBILE_NO ")
	private Long primaryContactMobileNo;
	@Column (name="CONTACT_PHONE_NO   ")
	private Long primaryContactPhoneNo;
	@Column (name="SKYPE_NAME_NO ")
	private String primaryContactSkype;
	@Column (name="CONTACT_PERSON_DESIGNATION")
	private String primaryContactDesignation;
	@Column (name="CONTACT_PERSON_DEPARTMENT")
	private String primaryContactDepartment;
	@Column (name="CLIENT_MOBILE_NO")
	private Long mobileNo;
	@Column (name="TIN_NO")
	private String tinNo;
	@Column (name="PAN_NO")
	private String panNo;
	@Column (name="SHIP_CITY")
	private String city;
	@Column (name="SERVICE_TAX_NO")
	private String serviceTaxNo;
	@Column (name="PRIVATE_CLIENT_DETAIL_NOTE")
	private String privateClientNote;
	@Column (name="OTHER_CLIENT_DETAIL_NOTE")
	private String otherClientnote;
	@Column  (name="BILL_ADDRESS_1")
	private String billAddress;
	@Column (name="BILL_ADDRESS_2")
	private String billAddress1;
	@Column  (name="BILL_COUNTRY")
	private String billCountry;
	@Column  (name="BILL_STATE")
	private String billState;
	@Column  (name="BILL_CITY")
	private String billCity;
	@Column  (name="CURRENCY")
	private String currency;
	
	
	

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

	public String getPrimaryContactPerson() {
		return primaryContactPerson;
	}

	public void setPrimaryContactPerson(String primaryContactPerson) {
		this.primaryContactPerson = primaryContactPerson;
	}

	public Long getPrimaryContactMobileNo() {
		return primaryContactMobileNo;
	}

	public void setPrimaryContactMobileNo(Long primaryContactMobileNo) {
		this.primaryContactMobileNo = primaryContactMobileNo;
	}

	public Long getPrimaryContactPhoneNo() {
		return primaryContactPhoneNo;
	}

	public void setPrimaryContactPhoneNo(Long primaryContactPhoneNo) {
		this.primaryContactPhoneNo = primaryContactPhoneNo;
	}

	public String getPrimaryContactSkype() {
		return primaryContactSkype;
	}

	public void setPrimaryContactSkype(String primaryContactSkype) {
		this.primaryContactSkype = primaryContactSkype;
	}

	public String getPrimaryContactDesignation() {
		return primaryContactDesignation;
	}

	public void setPrimaryContactDesignation(String primaryContactDesignation) {
		this.primaryContactDesignation = primaryContactDesignation;
	}

	public String getPrimaryContactDepartment() {
		return primaryContactDepartment;
	}

	public void setPrimaryContactDepartment(String primaryContactDepartment) {
		this.primaryContactDepartment = primaryContactDepartment;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}

	public String getPrivateClientNote() {
		return privateClientNote;
	}

	public void setPrivateClientNote(String privateClientNote) {
		this.privateClientNote = privateClientNote;
	}

	public String getOtherClientnote() {
		return otherClientnote;
	}

	public void setOtherClientnote(String otherClientnote) {
		this.otherClientnote = otherClientnote;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

	public String getBillAddress1() {
		return billAddress1;
	}

	public void setBillAddress1(String billAddress1) {
		this.billAddress1 = billAddress1;
	}

	public String getBillCountry() {
		return billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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
