package com.gst.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "INVOICE_DTLS")
public class InvoiceDetailsRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVOICE_NO")
	private Integer id;

	@Column(name = "REVERSE_CHARGES")
	private Double reverseCharges;

	@Column(name = "INVOICE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceDate;

	@Column(name = "TRANSPORTATION_MODE")
	private String transportationMode;

	@Column(name = "VEHICLE_NUMBER")
	private String vehicleNumber;

	@Column(name = "DATE_OF_SUPPLY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfSupply;

	@Column(name = "PLACE_OF_SUPPLY")
	private String placeOfSupply;

	@Column(name = "CLIENT_STATE_CODE")
	private String clientStateCode;

	@Column(name = "RECEIVER_NAME")
	private String receiverName;

	@Column(name = "RECEIVER_ADDRESS")
	private String receiverAddress;

	@Column(name = "RECEIVER_COUNTRY")
	private String receiverCountry;

	@Column(name = "CONSIGNEE_NAME")
	private String consigneeName;

	@Column(name = "CONSIGNEE_ADDRESS")
	private String consigneeAddress;

	@Column(name = "CONSIGNEE_COUNTRY")
	private String consigneeCountry;
	
	@Column(name = "CLIENT_GST_NO")
	private String clientGSTIN;
	
	@Column(name = "COMPANY_GST_NO")
	private String companyGSTIN;

	@Column(name = "TOTAL_INVOICE_AMT")
	private Double totalInvoiceAmt;

	@OneToMany(mappedBy = "invoiceDetailsRequest", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<InvoiceAmtAndTaxDetails> invoiceAmtAndTaxDetails;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BUYER_ID")
	private BuyerRequest customerId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSIGNEE_ID")
	private ConsigneeRequest consigneeId;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getReverseCharges() {
		return reverseCharges;
	}

	public void setReverseCharges(Double reverseCharges) {
		this.reverseCharges = reverseCharges;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getTransportationMode() {
		return transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getDateOfSupply() {
		return dateOfSupply;
	}

	public void setDateOfSupply(Date dateOfSupply) {
		this.dateOfSupply = dateOfSupply;
	}

	public String getPlaceOfSupply() {
		return placeOfSupply;
	}

	public void setPlaceOfSupply(String placeOfSupply) {
		this.placeOfSupply = placeOfSupply;
	}

	public String getClientStateCode() {
		return clientStateCode;
	}

	public void setClientStateCode(String clientStateCode) {
		this.clientStateCode = clientStateCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverCountry() {
		return receiverCountry;
	}

	public void setReceiverCountry(String receiverCountry) {
		this.receiverCountry = receiverCountry;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeCountry() {
		return consigneeCountry;
	}

	public void setConsigneeCountry(String consigneeCountry) {
		this.consigneeCountry = consigneeCountry;
	}

	public String getClientGSTIN() {
		return clientGSTIN;
	}

	public void setClientGSTIN(String clientGSTIN) {
		this.clientGSTIN = clientGSTIN;
	}

	public String getCompanyGSTIN() {
		return companyGSTIN;
	}

	public void setCompanyGSTIN(String companyGSTIN) {
		this.companyGSTIN = companyGSTIN;
	}

	public String getCcompanyGSTIN() {
		return companyGSTIN;
	}

	public void setCcompanyGSTIN(String companyGSTIN) {
		this.companyGSTIN = companyGSTIN;
	}

	public Double getTotalInvoiceAmt() {
		return totalInvoiceAmt;
	}

	public void setTotalInvoiceAmt(Double totalInvoiceAmt) {
		this.totalInvoiceAmt = totalInvoiceAmt;
	}

	public List<InvoiceAmtAndTaxDetails> getInvoiceAmtAndTaxDetails() {
		return invoiceAmtAndTaxDetails;
	}

	public void setInvoiceAmtAndTaxDetails(List<InvoiceAmtAndTaxDetails> invoiceAmtAndTaxDetails) {
		this.invoiceAmtAndTaxDetails = invoiceAmtAndTaxDetails;
	}

	public BuyerRequest getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BuyerRequest customerId) {
		this.customerId = customerId;
	}

	public ConsigneeRequest getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(ConsigneeRequest consigneeId) {
		this.consigneeId = consigneeId;
	}

}
