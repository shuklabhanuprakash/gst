package com.gst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gst.model.InvoiceAmtAndTaxDetails;
import com.gst.model.InvoiceDetailsRequest;
import com.gst.service.BuyerService;
import com.gst.service.InvoiceService;
import com.gst.service.ProductService;

@Controller
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	@Autowired
	BuyerService buyerService;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/invoiceMaster.submit", method = RequestMethod.POST)
	public String registerInvoiceDetails(InvoiceDetailsRequest requestObj, Model model) {
		List<InvoiceAmtAndTaxDetails> invoiceTaxList = new ArrayList<InvoiceAmtAndTaxDetails>();
		Double taxAmt = 0.0;
		Double taxDivide = 0.0;
		requestObj.getInvoiceAmtAndTaxDetails().get(0).setInvoiceDetailsRequest(requestObj);
		requestObj.getInvoiceAmtAndTaxDetails().get(1).setInvoiceDetailsRequest(requestObj);
		requestObj.setInvoiceDate(new java.util.Date());
		requestObj.setDateOfSupply(new java.util.Date());

		// tax calculation
		invoiceTaxList = requestObj.getInvoiceAmtAndTaxDetails();
		int i = 0;
		for (InvoiceAmtAndTaxDetails invTaxList : invoiceTaxList) {
			System.out.println("Quantity::::" + invTaxList.getQuantity());
			System.out.println("Unit Cost::::" + invTaxList.getUnitCost());
			System.out.println("Tax Rate::::" + invTaxList.getTaxRate());
			System.out.println("Tax Amount::::" + invTaxList.getTaxRate());
			if (StringUtils.equals(requestObj.getClientStateCode(), "6")) {
				if (invTaxList.getTaxRate() != 0) {
					taxDivide = (invTaxList.getTaxRate() / 2);
				} else {
					taxDivide = 0.0;
				}
				if (taxDivide != 0) {
					taxAmt = invTaxList.getUnitCost() * invTaxList.getQuantity() * (taxDivide / 100);
				} else {
					taxAmt = 0.0;
				}
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setCgstTaxRate(taxDivide);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setCgstAmt(taxAmt);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setSgstTaxRate(taxDivide);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setSgstAmt(taxAmt);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setIgstTaxRate(0.0);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setIgstAmt(0.0);
			} else {
				if (invTaxList.getTaxRate() != 0) {
					taxAmt = invTaxList.getUnitCost() * invTaxList.getQuantity() * (invTaxList.getTaxRate() / 100);
				} else {
					taxAmt = 0.0;
				}
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setCgstTaxRate(0.0);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setCgstAmt(0.0);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setSgstTaxRate(0.0);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setSgstAmt(0.0);
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setIgstTaxRate(invTaxList.getTaxRate());
				requestObj.getInvoiceAmtAndTaxDetails().get(i).setIgstAmt(taxAmt);
			}
			i++;
		}
		// end tax calculation

		invoiceService.registerInfo(requestObj);
		return "redirect:viewInvoice";
	}

	@RequestMapping(value = "/viewInvoice", method = RequestMethod.GET)
	public String viewInvoice(Model model) {
		//InvoiceDetailsRequest InvoiceDetailsRequest=invoiceService.getMaxRecord();
		//model.addAttribute("customerDetails", buyerService.getCustomerById(1));
		//model.addAttribute("invoiceDetails", invoiceService.getInvoiceById(1));
		model.addAttribute("invoiceDetails", invoiceService.getMaxRecord());
		return "viewInvoice";
	}
	
	@RequestMapping("/InvoiceList")
	public String getInvoiceList(Model model) {
		model.addAttribute("invoiceList", invoiceService.getInvoiceList());
		return "invoiceViewList";
	}
	
	@RequestMapping("/editInvoice")
	public String editInvoice(@RequestParam(value = "id", required = false) Integer id, Model model) {
		if (null != id) {
			model.addAttribute("customerList",buyerService.getCustomer());
			model.addAttribute("productList",productService.getProducts());
			model.addAttribute("editInvoice", invoiceService.getEditInvoiceDetails(id));
			//model.addAttribute("consignee", consigneeService.getConsigneeByBuyerId(id));
			//model.addAttribute("editConsignee", buyerService.registerInfo(requestObj);;
		}
		return "editInvoice";
	}
	
	@RequestMapping(value = "/exportData", method = RequestMethod.GET)
	public void exportDataToFile(@RequestParam(value = "id", required = false) Integer id,HttpServletResponse httpServletResponse) {
	/*	InvoiceDetailsRequest invoiceDtls = invoiceService.getInvoiceById(id);
		ExportPdfData export = new ExportPdfData();
		export.setHeaderList();
		export.exportToPDFLatest(invoiceDtls);
		httpServletResponse.setHeader("Location", "invoice");*/
	}

}
