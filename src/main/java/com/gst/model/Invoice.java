package com.gst.model;

import java.io.Serializable;

public class Invoice implements Serializable{

	private static final long serialVersionUID = 6719204778515733134L;
	private int srNo;
	private String description;
	private String hsn;
	private int quantity;
	private int unit;
	private double rate;
	private double total;
	private double discount;
	private double taxableValue;
	private double cgstRate;
	private double cgstAmt;
	private double sgstRate;
	private double sgstAmt;
	private double igstRate;
	private double igstAmt;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTaxableValue() {
		return taxableValue;
	}
	public void setTaxableValue(double taxableValue) {
		this.taxableValue = taxableValue;
	}
	public double getCgstRate() {
		return cgstRate;
	}
	public void setCgstRate(double cgstRate) {
		this.cgstRate = cgstRate;
	}
	public double getCgstAmt() {
		return cgstAmt;
	}
	public void setCgstAmt(double cgstAmt) {
		this.cgstAmt = cgstAmt;
	}
	public double getSgstRate() {
		return sgstRate;
	}
	public void setSgstRate(double sgstRate) {
		this.sgstRate = sgstRate;
	}
	public double getSgstAmt() {
		return sgstAmt;
	}
	public void setSgstAmt(double sgstAmt) {
		this.sgstAmt = sgstAmt;
	}
	public double getIgstRate() {
		return igstRate;
	}
	public void setIgstRate(double igstRate) {
		this.igstRate = igstRate;
	}
	public double getIgstAmt() {
		return igstAmt;
	}
	public void setIgstAmt(double igstAmt) {
		this.igstAmt = igstAmt;
	}
	
	
}
