package com.gst.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MA_COMPANY")
public class SellerRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="COMPANY_NAME")
	private String sellerName;
	@Column(name="ADDRESS_1" )
	private String address;
	@Column(name="STATE" )
	private String state;
	@Column(name="CITY" )
	private String city;
	@Column(name="PINCODE" )
	private Integer pinCode;
	@Column(name="PHONE_NO" )
	private Long phoneNo;
	@Column(name="MOBILE_NO" )
	private Long mobileNo;
	@Column(name="FAX_NO" )
	private Integer faxNo;
	@Column(name="EMAIL_ID" )
	private String email;
	@Column(name="GSTIN" )
	private String gstID;
	@Column(name="ADDRESS_2")
	private String address1;
	@Column (name="COUNTRY")
	private String country;
	@Column (name="BRANCH_CODE")
	private String branchCode;
	@Column(name="WEBSITE")
	private String website;
	@Column(name="VAT_TIN_NO")
	private String vatNo;
	@Column(name="PAN_NO")
	private String panNo;
	@Column(name="CIN_NO")
	private String cinNo;
	@Column(name="SERVICE_TAX_NO")
	private String serviceTaxNo;
	@Column(name="SERVICE_CAT")
	private String serviceCatagory;
	@Column(name="LOGO")
	private File companyLogo;
	@Column(name="STATE_CODE")
	private File stateCode;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public String getGstID() {
		return gstID;
	}

	public void setGstID(String gstID) {
		this.gstID = gstID;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}

	public String getServiceCatagory() {
		return serviceCatagory;
	}

	public void setServiceCatagory(String serviceCatagory) {
		this.serviceCatagory = serviceCatagory;
	}

	public File getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(File companyLogo) {
		this.companyLogo = companyLogo;
	}

	public File getStateCode() {
		return stateCode;
	}

	public void setStateCode(File stateCode) {
		this.stateCode = stateCode;
	}

}
