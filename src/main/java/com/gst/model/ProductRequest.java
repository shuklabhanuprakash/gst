package com.gst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MA_PRODUCT")
public class ProductRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column (name="GOODS_DESC")
	private String goodsDesc;
	@Column (name="HSN_CODE")
	private String hsnCode;
	@Column (name="TAX_RATE")
	private Double taxRate;
	@Column (name="ITEM_NAME")
	private String itemName;
	@Column (name="SAC_CODE")
	private String sacCode;
	@Column (name="UNIT_OF_MEASURE")
	private String unitOfMeasure;
	@Column (name="SKU")
	private String sku;
	@Column (name="ITEM_PRICE")
	private Double itemPrice;
	@Column (name="CESS")
	private Double cess;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return "ProductRequest [id=" + id + ", goodsDesc=" + goodsDesc
				+ ", hsnCode=" + hsnCode + ", taxRate=" + taxRate + "]";
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSacCode() {
		return sacCode;
	}

	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getCess() {
		return cess;
	}

	public void setCess(Double cess) {
		this.cess = cess;
	}

}
