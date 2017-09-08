package com.gst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "INVOICE_AMT_AND_TAX_DTLS")
public class InvoiceAmtAndTaxDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PARTICULAR")
	private ProductRequest particular;

	@Column(name = "HSN_CODE")
	private String hsnCode;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "UNIT_COST")
	private Double unitCost;

	@Column(name = "TAX_RATE")
	private Double taxRate;

	@Column(name = "CGST_TAX_RATE")
	private Double cgstTaxRate;

	@Column(name = "SGST_TAX_RATE")
	private Double sgstTaxRate;

	@Column(name = "IGST_TAX_RATE")
	private Double igstTaxRate;

	@Column(name = "CGST_AMT")
	private Double cgstAmt;

	@Column(name = "SGST_AMT")
	private Double sgstAmt;

	@Column(name = "IGST_AMT")
	private Double igstAmt;

	@Column(name = "TOTAL_LINE_AMT")
	private Double totalLineAmt;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_NO")
	private InvoiceDetailsRequest invoiceDetailsRequest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductRequest getParticular() {
		return particular;
	}

	public void setParticular(ProductRequest particular) {
		this.particular = particular;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getCgstTaxRate() {
		return cgstTaxRate;
	}

	public void setCgstTaxRate(Double cgstTaxRate) {
		this.cgstTaxRate = cgstTaxRate;
	}

	public Double getSgstTaxRate() {
		return sgstTaxRate;
	}

	public void setSgstTaxRate(Double sgstTaxRate) {
		this.sgstTaxRate = sgstTaxRate;
	}

	public Double getIgstTaxRate() {
		return igstTaxRate;
	}

	public void setIgstTaxRate(Double igstTaxRate) {
		this.igstTaxRate = igstTaxRate;
	}

	public Double getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(Double cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public Double getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(Double sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public Double getIgstAmt() {
		return igstAmt;
	}

	public void setIgstAmt(Double igstAmt) {
		this.igstAmt = igstAmt;
	}

	public Double getTotalLineAmt() {
		return totalLineAmt;
	}

	public void setTotalLineAmt(Double totalLineAmt) {
		this.totalLineAmt = totalLineAmt;
	}

	public InvoiceDetailsRequest getInvoiceDetailsRequest() {
		return invoiceDetailsRequest;
	}

	public void setInvoiceDetailsRequest(InvoiceDetailsRequest invoiceDetailsRequest) {
		this.invoiceDetailsRequest = invoiceDetailsRequest;
	}

}