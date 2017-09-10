package com.gst.controller;

import org.springframework.stereotype.Controller;

/**
 * PdfGenerator.java
 * 
 * @author srk 28-Jun-2015 3:28:37 PM
 */
@Controller
public class ExportPdfData {
/*
	@Autowired
	InvoiceService invoiceService;

	SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyyhhmmss");
	SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
	List<Invoice> ls = new ArrayList<Invoice>();
	List<String> headerList = null;
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet1 = null;

	public void exportToPDF(InvoiceDetailsRequest invoiceDtls) {
		Document document = new Document();
		try {
			// Has to provide below fields dynamically
			String filePath="test.pdf";//"E:\\Temp\\Invoice_" + format1.format(new Date()) + ".pdf"
			ls = setInvoiceData(invoiceDtls);
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(filePath));

			document.open();
			document.addTitle("Invoice Report");
			document.addAuthor("SamSuper");

			// PDF printing started
			Paragraph p;
			p = new Paragraph("");
			p.add(new Chunk("Government of India/State \n",
					FontFactory.getFont(FontFactory.HELVETICA, 20.0f, Font.BOLD)));
			p.add(new Chunk("Department of...............\n\n",
					FontFactory.getFont(FontFactory.HELVETICA, 20.0f, Font.BOLD)));
			p.add(new Chunk("Form GST INV - 1 \n", FontFactory.getFont(FontFactory.HELVETICA, 15.0f, Font.BOLD)));
			p.add(new Chunk("(See Rule-----) \n", FontFactory.getFont(FontFactory.HELVETICA, 15.0f, Font.BOLD)));
			p.add(new Chunk("Application for Electronic Reference Number of an Invoice \n",
					FontFactory.getFont(FontFactory.HELVETICA, 15.0f, Font.BOLD)));
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);

			document.add(new Paragraph("\n1. GSTIN "));
			document.add(new Paragraph("2. Name "));
			document.add(new Paragraph("3. Address "));
			document.add(new Paragraph("4. Serial No. of Invoice "));
			document.add(new Paragraph("5. Date of Invoice "));

			p = new Paragraph("\n");
			p.add(new Chunk("Details of Receiver (Billed to)                   Details of Consignee(Shipped to)\n",
					FontFactory.getFont(FontFactory.HELVETICA, 12.0f, Font.BOLD)));
			document.add(p);

			document.add(new Paragraph("Name                		                                           Name"));
			document.add(new Paragraph("Address                                                         Address"));
			document.add(new Paragraph("State                                                              State"));
			document.add(new Paragraph("State Code                                                    State Code"));
			document.add(new Paragraph("GSTIN/Unique ID                                          GSTIN/Unique ID"));

			float[] columnWidth1 = { 0.40f, 2.3f, 0.65f, 0.5f, 0.5f, 1f, 1f, 1.0f, 1.0f, 2.25f, 2.25f, 2.25f };
			PdfPTable table1 = new PdfPTable(columnWidth1);
			table1.setWidthPercentage(100f);

			for (String header : headerList) {
				if (header.contains("GST")) {
					PdfPCell cell = new PdfPCell();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setPhrase(new Phrase(header, new Font(Font.HELVETICA, 9, Font.NORMAL)));
					table1.addCell(cell);
				} else {
					PdfPCell cell = new PdfPCell();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setPhrase(new Phrase(header, new Font(Font.HELVETICA, 9, Font.NORMAL)));
					table1.addCell(cell);
				}
			}
			table1.completeRow();

			PdfPCell cell = null;
			float[] columnWidth6 = { 0.40f, 2.3f, 0.65f, 0.5f, 0.5f, 1f, 1f, 1.0f, 1.0f, 1.125f, 1.125f, 1.125f, 1.125f,
					1.125f, 1.125f };
			PdfPTable table6 = new PdfPTable(columnWidth6);
			table6.setWidthPercentage(100f);
			for (Invoice bo : ls) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSrNo()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				if (bo.getDescription() != null) {
					cell.setPhrase(new Phrase(bo.getDescription(), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				} else {
					cell.setPhrase(new Phrase("--", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				}
				table6.addCell(cell);

				cell = new PdfPCell();
				if (bo.getHsn() != null) {
					cell.setPhrase(new Phrase(bo.getHsn(), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				} else {
					cell.setPhrase(new Phrase("--", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				}
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getQuantity()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getUnit()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getTotal()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getDiscount()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(
						new Phrase(String.valueOf(bo.getTaxableValue()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getCgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getCgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getIgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getIgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

			}
			table6.completeRow();

			float[] columnWidth2 = { 5.35f, 1f, 1.0f, 1.0f, 1.125f, 1.125f, 1.125f, 1.125f, 1.125f, 1.125f };
			PdfPTable table2 = new PdfPTable(columnWidth2);
			table2.setWidthPercentage(100f);
			String temp = "";
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					temp = "Freight ";
				} else if (i == 1) {
					temp = "Insurance ";
				} else if (i == 2) {
					temp = "Packing and Forwarding Charges";
				} else if (i == 3) {
					temp = "Total ";
				}
				for (int j = 0; j < 7; j++) {
					if (j == 0) {
						cell = new PdfPCell();
						cell.setPhrase(new Phrase(temp, new Font(Font.HELVETICA, 8, Font.NORMAL)));
						table2.addCell(cell);
					} else {
						cell = new PdfPCell();
						cell.setPhrase(new Phrase("", new Font(Font.HELVETICA, 8, Font.NORMAL)));
						table2.addCell(cell);
					}
				}
				table2.completeRow();
			}

			List<String> totalColumns = new ArrayList<String>();
			totalColumns.add("Total Invoice Value(In figure)         ");
			totalColumns.add("Total Invoice Value(In Words)         ");

			float[] columnWidth4 = { 8.35f, 6.75f };
			PdfPTable table4 = new PdfPTable(columnWidth4);
			table4.setWidthPercentage(100f);

			for (String s : totalColumns) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase(s, new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table4.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase("  ", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table4.addCell(cell);
				table4.completeRow();
			}

			float[] columnWidth5 = { 8.35f, 2.25f, 2.25f, 2.25f };
			PdfPTable table5 = new PdfPTable(columnWidth5);
			table5.setWidthPercentage(100f);
			cell = new PdfPCell();
			cell.setPhrase(new Phrase("Amount of Tax subject to Reverse Charges         ",
					new Font(Font.HELVETICA, 8, Font.NORMAL)));
			table5.addCell(cell);

			for (int i = 0; i < 3; i++) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase("  ", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table5.addCell(cell);
			}
			table5.completeRow();

			Paragraph paragraph = new Paragraph(" ");
			paragraph.add(table1);
			paragraph.add(table6);
			paragraph.add(table2);
			// paragraph.add(table3);
			paragraph.add(table4);
			paragraph.add(table5);
			document.add(paragraph);
			document.add(new Paragraph("\nDeclaration : "));
			document.add(new Paragraph(
					"\nSignature                                                      Name of the Signatory"));
			document.add(new Paragraph("\nDesignation/Status "));
			document.add(new Paragraph(
					"\nElectronic Reference Number                                                     Date-"));
			document.close();
			table1 = null;
			table6 = null;
			table2 = null;
			table4 = null;
			table5 = null;
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void exportToPDFLatest(InvoiceDetailsRequest invoiceDtls) {
		Document document = new Document();
		try {
			// Has to provide below fields dynamically

			ls = setInvoiceData(invoiceDtls);
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("D:\\Temp\\Invoice_" + format1.format(new Date()) + ".pdf"));

			document.open();
			document.addTitle("Invoice Report");
			document.addAuthor("SamSuper");

			// PDF printing started
			Paragraph p;
			p = new Paragraph("");
			p.add(new Chunk("Pratap & Pratap \n",
					FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 20.0f, Font.BOLD)));
			p.add(new Chunk("23, Modern Market, Bikaner-334001(Rajasthan)\n",
					FontFactory.getFont(FontFactory.HELVETICA, 10.0f, Font.NORMAL)));
			p.add(new Chunk("Mobile : +91-83878-11111 \n",
					FontFactory.getFont(FontFactory.HELVETICA, 10.0f, Font.BOLD)));
			p.add(new Chunk("GSTIN: 24ABCPP1234Z1ZX \n\n",
					FontFactory.getFont(FontFactory.HELVETICA, 10.0f, Font.BOLD)));
			p.add(new Chunk("EXPORT INVOICE \n", FontFactory.getFont(FontFactory.HELVETICA, 15.0f, Font.BOLD)));
			p.add(new Chunk(
					"Supply Meant for Export Under Bond or Letter of Undertaking without Payment of Integrated Tax(IGST) \n",
					FontFactory.getFont(FontFactory.HELVETICA, 10.0f, Font.BOLD)));
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);

			document.add(
					new Paragraph("Reverse Charges:                                             Transportation Mode:"));
			document.add(new Paragraph(
					"Invoice No.:                                                       Vehicle Number:"));
			document.add(
					new Paragraph("Invoice Date:                                                     Date of Supply:"));
			document.add(
					new Paragraph("State:                     State Code:                          Place of Supply:"));

			p = new Paragraph("\n");
			p.add(new Chunk("Details of Receiver (Billed to)                   Details of Consignee(Shipped to)\n",
					FontFactory.getFont(FontFactory.HELVETICA, 12.0f, Font.BOLD)));
			document.add(p);

			document.add(new Paragraph("Name                		                                           Name"));
			document.add(new Paragraph("Address                                                         Address\n\n"));
			document.add(new Paragraph("Country                                                           Country"));

			float[] columnWidth1 = { 0.40f, 2.3f, 0.65f, 0.5f, 0.5f, 1f, 1f, 1.0f, 1.0f, 2.25f, 2.25f, 2.25f };
			PdfPTable table1 = new PdfPTable(columnWidth1);
			table1.setWidthPercentage(100f);

			for (String header : headerList) {
				if (header.contains("GST")) {
					PdfPCell cell = new PdfPCell();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setPhrase(new Phrase(header, new Font(Font.HELVETICA, 9, Font.NORMAL)));
					table1.addCell(cell);
				} else {
					PdfPCell cell = new PdfPCell();
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setPhrase(new Phrase(header, new Font(Font.HELVETICA, 9, Font.NORMAL)));
					table1.addCell(cell);
				}
			}
			table1.completeRow();

			PdfPCell cell = null;
			float[] columnWidth6 = { 0.40f, 2.3f, 0.65f, 0.5f, 0.5f, 1f, 1f, 1.0f, 1.0f, 1.125f, 1.125f, 1.125f, 1.125f,
					1.125f, 1.125f };
			PdfPTable table6 = new PdfPTable(columnWidth6);
			table6.setWidthPercentage(100f);
			for (Invoice bo : ls) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSrNo()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				if (bo.getDescription() != null) {
					cell.setPhrase(new Phrase(bo.getDescription(), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				} else {
					cell.setPhrase(new Phrase("--", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				}
				table6.addCell(cell);

				cell = new PdfPCell();
				if (bo.getHsn() != null) {
					cell.setPhrase(new Phrase(bo.getHsn(), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				} else {
					cell.setPhrase(new Phrase("--", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				}
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getQuantity()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getUnit()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getTotal()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getDiscount()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(
						new Phrase(String.valueOf(bo.getTaxableValue()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getCgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getCgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getSgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getIgstAmt()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase(String.valueOf(bo.getIgstRate()), new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table6.addCell(cell);

			}
			table6.completeRow();

			float[] columnWidth2 = { 5.35f, 1f, 1.0f, 1.0f, 1.125f, 1.125f, 1.125f, 1.125f, 1.125f, 1.125f };
			PdfPTable table2 = new PdfPTable(columnWidth2);
			table2.setWidthPercentage(100f);
			String temp = "";
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					temp = "Freight ";
				} else if (i == 1) {
					temp = "Insurance ";
				} else if (i == 2) {
					temp = "Packing and Forwarding Charges";
				} else if (i == 3) {
					temp = "Total ";
				}
				for (int j = 0; j < 7; j++) {
					if (j == 0) {
						cell = new PdfPCell();
						cell.setPhrase(new Phrase(temp, new Font(Font.HELVETICA, 8, Font.NORMAL)));
						table2.addCell(cell);
					} else {
						cell = new PdfPCell();
						cell.setPhrase(new Phrase("", new Font(Font.HELVETICA, 8, Font.NORMAL)));
						table2.addCell(cell);
					}
				}
				table2.completeRow();
			}

			List<String> totalColumns = new ArrayList<String>();
			totalColumns.add("Total Invoice Value(In figure)         ");
			totalColumns.add("Total Invoice Value(In Words)         ");

			float[] columnWidth4 = { 8.35f, 6.75f };
			PdfPTable table4 = new PdfPTable(columnWidth4);
			table4.setWidthPercentage(100f);

			for (String s : totalColumns) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase(s, new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table4.addCell(cell);

				cell = new PdfPCell();
				cell.setPhrase(new Phrase("  ", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table4.addCell(cell);
				table4.completeRow();
			}

			float[] columnWidth5 = { 8.35f, 2.25f, 2.25f, 2.25f };
			PdfPTable table5 = new PdfPTable(columnWidth5);
			table5.setWidthPercentage(100f);
			cell = new PdfPCell();
			cell.setPhrase(new Phrase("Amount of Tax subject to Reverse Charges         ",
					new Font(Font.HELVETICA, 8, Font.NORMAL)));
			table5.addCell(cell);

			for (int i = 0; i < 3; i++) {
				cell = new PdfPCell();
				cell.setPhrase(new Phrase("  ", new Font(Font.HELVETICA, 8, Font.NORMAL)));
				table5.addCell(cell);
			}
			table5.completeRow();

			Paragraph paragraph = new Paragraph(" ");
			paragraph.add(table1);
			paragraph.add(table6);
			paragraph.add(table2);
			// paragraph.add(table3);
			paragraph.add(table4);
			paragraph.add(table5);
			document.add(paragraph);
			document.add(new Paragraph("\nDeclaration : "));
			document.add(new Paragraph(
					"\nSignature                                                      Name of the Signatory"));
			document.add(new Paragraph("\nDesignation/Status "));
			document.add(new Paragraph(
					"\nElectronic Reference Number                                                     Date-"));
			document.close();
			table1 = null;
			table6 = null;
			table2 = null;
			table4 = null;
			table5 = null;
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<String> setHeaderList() {
		headerList = new ArrayList<String>();
		headerList.add("Sr. No");
		headerList.add("Description of Goods");
		headerList.add("HSN");
		headerList.add("Qty.");
		headerList.add("Unit");
		headerList.add("Rate(Per item)");
		headerList.add("Total");
		headerList.add("Discount");
		headerList.add("Taxable value");
		headerList.add("CGST \nRate   Amt.");
		headerList.add("SGST \nRate   Amt.");
		headerList.add("IGST \nRate   Amt.");
		return headerList;
	}

	private List<Invoice> setInvoiceData(InvoiceDetailsRequest invoiceDtls) {
		List<Invoice> temp = new ArrayList<Invoice>();
		// fetching data from invoice_amt_and_tax_dtls
		// InvoiceAmtAndTaxDetails
		// InvoiceDetailsRequest invoiceDtls=invoiceService.getInvoiceById(1);
		System.out.println("size of trax details::::::" + invoiceDtls.getInvoiceAmtAndTaxDetails().size());
		List<InvoiceAmtAndTaxDetails> invoiceTaxDtls = new ArrayList<InvoiceAmtAndTaxDetails>();
		invoiceTaxDtls = invoiceDtls.getInvoiceAmtAndTaxDetails();

		// end fetching data from invoice_amt_and_tax_dtls
		int counter = 0;
		// for(int i=0;i<invoiceDtls.getInvoiceAmtAndTaxDetails().size();i++){
		for (InvoiceAmtAndTaxDetails inv : invoiceTaxDtls) {
			Invoice in = new Invoice();
			in.setSrNo(++counter);
			in.setDescription(inv.getParticular().getGoodsDesc());
			in.setHsn(inv.getHsnCode());
			if (inv.getQuantity() != null) {
				in.setQuantity(inv.getQuantity());
			} else {
				in.setQuantity(0);
			}
			if (inv.getQuantity() != null) {
				in.setUnit(inv.getQuantity());
			} else {
				in.setUnit(0);
			}
			if (inv.getUnitCost() != null) {
				in.setRate(inv.getUnitCost());
			} else {
				in.setRate(0);
			}
			if (inv.getTotalLineAmt() != null) {
				in.setTotal(inv.getTotalLineAmt());
			} else {
				in.setTotal(0);
			}
			in.setDiscount(0);
			if (inv.getTotalLineAmt() != null) {
				in.setTaxableValue(inv.getTotalLineAmt());
			} else {
				in.setTaxableValue(0);
			}
			if (inv.getCgstTaxRate() != null) {
				in.setCgstRate(inv.getCgstTaxRate());
			} else {
				in.setCgstRate(0);
			}
			if (inv.getCgstAmt() != null) {
				in.setCgstAmt(inv.getCgstAmt());
			} else {
				in.setCgstAmt(0);
			}
			if (inv.getSgstTaxRate() != null) {
				in.setSgstRate(inv.getSgstTaxRate());
			} else {
				in.setSgstRate(0);
			}
			if (inv.getSgstAmt() != null) {
				in.setSgstAmt(inv.getSgstAmt());
			} else {
				in.setSgstAmt(0);
			}
			if (inv.getIgstTaxRate() != null) {
				in.setIgstRate(inv.getIgstTaxRate());
			} else {
				in.setIgstRate(0);
			}
			if (inv.getIgstAmt() != null) {
				in.setIgstAmt(inv.getIgstAmt());
			} else {
				in.setIgstAmt(0);
			}
			temp.add(in);
		}
		// }
		counter = 0;
		return temp;
	}

	public void mergeRegion(int i, int j, int k, int l) {
		sheet1.addMergedRegion(new CellRangeAddress(i, // first row (0-based)
				j, // last row (0-based)
				k, // first column (0-based)
				l // last column (0-based)
		));
	}

	private HSSFCellStyle hoardingtyle() {
		HSSFCellStyle ss = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		// font.setColor(HSSFColor.RED.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 14);
		font.setFontName("Times New Roman");
		ss.setFont(font);
		ss.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		ss.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		return ss;
	}

	private HSSFCellStyle titleStyle() {
		HSSFCellStyle ss = workbook.createCellStyle();
		ss.setBorderTop((short) 2);
		ss.setBorderBottom((short) 2);
		ss.setBorderLeft((short) 2);
		ss.setBorderRight((short) 2);
		ss.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		ss.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font = workbook.createFont();
		// font.setColor(HSSFColor.RED.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		ss.setFont(font);
		ss.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		ss.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		return ss;
	}

	private HSSFCellStyle labelStyle() {
		HSSFCellStyle ss = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		// font.setColor(HSSFColor.RED.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Times New Roman");
		ss.setFont(font);
		ss.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		ss.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		return ss;
	}

	public HSSFCellStyle dataLeftStyle() {
		HSSFCellStyle map = workbook.createCellStyle();
		map.setBorderTop((short) 1);
		map.setBorderBottom((short) 1);
		map.setBorderLeft((short) 1);
		map.setBorderRight((short) 1);
		map.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		map.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		return map;
	}

	public HSSFCellStyle dataRightStyle() {
		HSSFCellStyle map = workbook.createCellStyle();
		map.setBorderTop((short) 1);
		map.setBorderBottom((short) 1);
		map.setBorderLeft((short) 1);
		map.setBorderRight((short) 1);
		map.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		map.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		return map;
	}
*/
	/*
	 * public static void main(String[] args) { ExportPdfData export= new
	 * ExportPdfData(); export.setHeaderList(); export.exportToPDFLatest(); }
	 */
}
