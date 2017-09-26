package com.gst.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MA_PURCHASE_INVOICE")
public class PurchaseInvoiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column (name="INVOICE_NO")
	private String invoiceNo;
	@Column (name="COM_ID")
	private String companyId;
	@Column (name="COM_GSTIN")
	private String companyGstId;
	@Column (name="COM_STATE_CODE")
	private String companyStateCode;
	@Column (name="CUSTOMER_ID")
	private Integer customerId;
	@Column (name="ORDER_NO")
	private String orderNo;
	@Column (name="ORDER_DATE")
	private Date orderDate;
	@Column (name="PRODUCT_QUANTITY")
	private Integer productQuantity;
	@Column (name="PRODUCT_PRICE")
	private Double productUnitPrice;
	@Column (name="PRODUCT_DISCOUNT")
	private Double productDiscount;
	@Column (name="PRODUCT_TAX")
	private Double productTax;
	@Column (name="TOTAL_DISCOUNT")
	private Double totalDiscount;
	@Column (name="SHIP_CHARGES")
	private Double shippingCharges;
	@Column (name="ADV_PAY")
	private Double advancePayment;
	@Column (name="TOTAL_PAY")
	private Double totalPayment;
	@Column (name="MODE_OF_PAY")
	private String modeOfPayment;
	@Column (name="PAY_NOTE")
	private String paymentNote;
	@Column (name="CLIENT_NOTE")
	private String clientNote;
	@Column (name="ADD_INFO")
	private String additionalInfo;
	@Column (name="SHIPPING_NO")
	private String shippingNo;
	@Column (name="SHIPPING_NOTE")
	private String shippingNote;
	@Column (name="SHIP_VEHICLE_NO")
	private String shippingVehicleNo;
	@Column (name="SHIP_DATE")
	private Date shippingDate;
	@Column (name="EXP_DELIVERY_DATE")
	private Date expDeliveryDate;
	@Column (name="PURCHASE_PERSON_NAME")
	private String purchasePersonsName;
	@Column (name="PURCHASE_PERSON_EMAIL")
	private String purchasePersonEmail;
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyGstId() {
		return companyGstId;
	}
	public void setCompanyGstId(String companyGstId) {
		this.companyGstId = companyGstId;
	}
	public String getCompanyStateCode() {
		return companyStateCode;
	}
	public void setCompanyStateCode(String companyStateCode) {
		this.companyStateCode = companyStateCode;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(Double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public Double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public Double getProductTax() {
		return productTax;
	}
	public void setProductTax(Double productTax) {
		this.productTax = productTax;
	}
	public Double getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	public Double getShippingCharges() {
		return shippingCharges;
	}
	public void setShippingCharges(Double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public Double getAdvancePayment() {
		return advancePayment;
	}
	public void setAdvancePayment(Double advancePayment) {
		this.advancePayment = advancePayment;
	}
	public Double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getPaymentNote() {
		return paymentNote;
	}
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}
	public String getClientNote() {
		return clientNote;
	}
	public void setClientNote(String clientNote) {
		this.clientNote = clientNote;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getShippingNo() {
		return shippingNo;
	}
	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}
	public String getShippingNote() {
		return shippingNote;
	}
	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}
	public String getShippingVehicleNo() {
		return shippingVehicleNo;
	}
	public void setShippingVehicleNo(String shippingVehicleNo) {
		this.shippingVehicleNo = shippingVehicleNo;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Date getExpDeliveryDate() {
		return expDeliveryDate;
	}
	public void setExpDeliveryDate(Date expDeliveryDate) {
		this.expDeliveryDate = expDeliveryDate;
	}
	public String getPurchasePersonsName() {
		return purchasePersonsName;
	}
	public void setPurchasePersonsName(String purchasePersonsName) {
		this.purchasePersonsName = purchasePersonsName;
	}
	public String getPurchasePersonEmail() {
		return purchasePersonEmail;
	}
	public void setPurchasePersonEmail(String purchasePersonEmail) {
		this.purchasePersonEmail = purchasePersonEmail;
	}
	

	
	
}
