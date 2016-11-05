/**
 * 
 */
package com.sogeti.voucher.util;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.sogeti.voucher.models.PurchaseorderView;

/**
 * @author vkalyana
 *
 */
public class FilePOVoucherUtils {

	/**
	  * Builds the report layout. 
	  * <p>
	  * This doesn't have any data yet. This is your template.
	  */
	 public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, String code, String orderDate ) {
	  // Set column widths
	  worksheet.setColumnWidth(0, 5000);
	  worksheet.setColumnWidth(1, 5000);
	  worksheet.setColumnWidth(2, 5000);
	 /* worksheet.setColumnWidth(3, 5000);
	  worksheet.setColumnWidth(4, 5000);
	  worksheet.setColumnWidth(5, 5000);*/
	   
	  // Build the title and date headers
	  buildTitle(worksheet, startRowIndex, startColIndex, code, orderDate);
	  // Build the column headers
	  buildHeaders(worksheet, startRowIndex, startColIndex);
	 }
	  
	 /**
	  * Builds the report title and the date header
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  */
	 public static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex, String code, String orderDate) {
	  // Create font style for the report title
	  Font fontTitle = worksheet.getWorkbook().createFont();
	  fontTitle.setBold(true);
	  fontTitle.setFontHeight((short) 280);
	   
      // Create cell style for the report title
	    HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
	    cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
	    cellStyleTitle.setWrapText(true);
	    cellStyleTitle.setFont(fontTitle);
	    int row = startRowIndex;
	    
	  // Create report title
	  HSSFRow rowTitle = worksheet.createRow((short) row++);
	  rowTitle.setHeight((short) 500);
	  HSSFCell cellTitle = rowTitle.createCell(startColIndex);
	  cellTitle.setCellValue("Purchase Order :: Vouchers");
	  cellTitle.setCellStyle(cellStyleTitle);
	   
	  // Create merged region for the report title
	  worksheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
	  
	  // Create date header
	  HSSFRow dateTitle = worksheet.createRow((short) row++);
	  HSSFCell cellDate = dateTitle.createCell(startColIndex);
	  cellDate.setCellValue("This report was generated at " + new Date());
	  
	// Create date header
	  HSSFRow purchaseCode = worksheet.createRow((short) row++);
	  HSSFCell cellCodeKey = purchaseCode.createCell(startColIndex);
	  cellCodeKey.setCellValue("Purchase Order Code");
	  HSSFCell cellCodeValue = purchaseCode.createCell(startColIndex+1);
	  cellCodeValue.setCellValue( code );
	  
	// Create date header
	  HSSFRow purchaseOrderdate = worksheet.createRow((short) row++);
	  HSSFCell cellOrderDateKey = purchaseOrderdate.createCell(startColIndex);
	  cellOrderDateKey.setCellValue("Order Date");
	  HSSFCell cellOrderDateValue = purchaseOrderdate.createCell(startColIndex);
	  cellOrderDateValue.setCellValue(orderDate);
	  
	 }
	  
	 /**
	  * Builds the column headers
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  */
	 public static void buildHeaders(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
	  // Create font style for the headers
	  Font font = worksheet.getWorkbook().createFont();
	        font.setBold(true);
	 
	        // Create cell style for the headers
	  HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
	  headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
	  headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
	  headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	  headerCellStyle.setWrapText(true);
	  headerCellStyle.setFont(font);
	  headerCellStyle.setBorderBottom(BorderStyle.THIN);
	   
	  // Create the column headers
	  HSSFRow rowHeader = worksheet.createRow((short) startRowIndex +5);
	  rowHeader.setHeight((short) 500);
	   
	  HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
	  cell1.setCellValue("Voucher");
	  cell1.setCellStyle(headerCellStyle);
	 
	  HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
	  cell2.setCellValue("Emp#");
	  cell2.setCellStyle(headerCellStyle);
	 
	  HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
	  cell3.setCellValue("Name");
	  cell3.setCellStyle(headerCellStyle);
	 
	 }
	 
	 /**
	  * Fills the report with content
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  * @param datasource the data source
	  */
	 public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<PurchaseorderView> datasource) {
	  // Row offset
	  startRowIndex += 5;
	   
	  // Create cell style for the body
	  HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
	  bodyCellStyle.setAlignment(HorizontalAlignment.CENTER);
	  bodyCellStyle.setWrapText(true);
	   
	  // Create body
	  for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
	   // Create a new row
	   HSSFRow row = worksheet.createRow((short) i+1);
	 
	   // Retrieve the id value
	   HSSFCell cell1 = row.createCell(startColIndex+0);
	   cell1.setCellValue(datasource.get(i-2).getCode());
	   cell1.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the brand value
	   HSSFCell cell2 = row.createCell(startColIndex+1);
	   cell2.setCellValue(datasource.get(i-2).getEmployeeId());
	   cell2.setCellStyle(bodyCellStyle);
	 
	   // Retrieve the model value
	   HSSFCell cell3 = row.createCell(startColIndex+2);
	   cell3.setCellValue(datasource.get(i-2).getFirstname()+" "+ datasource.get(i-2).getLastname());
	   cell3.setCellStyle(bodyCellStyle);
	 
	  }
	 }
	 
}
