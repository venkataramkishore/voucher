/**
 * 
 */
package com.sogeti.voucher.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.PurchaseorderView;
import com.sogeti.voucher.services.PurchaseorderViewService;
import com.sogeti.voucher.util.FilePOVoucherUtils;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class PurchaseorderViewController {

	private static final Logger logger = Logger.getLogger(PurchaseorderViewController.class);
	
	@Autowired
	private PurchaseorderViewService  poViewService;
	
    @GetMapping("/povouchers/{pocode}/{orderdate}")
    public VoucherResponse getPurchaseorderView(@PathVariable("pocode") String pocode, @PathVariable("orderdate")String orderdate) {
    	logger.info("Inside getPurchaseorderView method ");
        VoucherResponse voucherResponse;
        List<PurchaseorderView> poList=null;
        try {
			 poList = this.poViewService.fetchPOWithCodeAndDate(pocode, orderdate);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(poList);
		} catch (Exception e) {
			logger.error("Unable to find getPurchaseorderView with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to find Purchaseorder with id: "+ pocode);
		}
        logger.info("Exiting getPurchaseorderView method ");
        return voucherResponse;
    }
    
    @SuppressWarnings("resource")
	@GetMapping("/povouchersxls/{pocode}/{orderdate}")
    public void downloadXLSPurchaseorderView(@PathVariable("pocode") String pocode, @PathVariable("orderdate")String orderdate,
    		HttpServletResponse response) {
    	logger.info("Inside downloadXLSPurchaseorderView method ");
        List<PurchaseorderView> poList=null;
        try {
			 poList = this.poViewService.fetchPOWithCodeAndDate(pocode, orderdate);
			 if(!Objects.isNull(poList)){
				// 1. Create new workbook
				  HSSFWorkbook workbook = new HSSFWorkbook();
				   
				  // 2. Create new worksheet
				  HSSFSheet worksheet = workbook.createSheet("Vouchers");
				// 3. Define starting indices for rows and columns
				  int startRowIndex = 0;
				  int startColIndex = 0;

				  FilePOVoucherUtils.buildReport(worksheet, startRowIndex, startColIndex, pocode, orderdate);
				  
				  FilePOVoucherUtils.fillReport(worksheet, startRowIndex, startColIndex, poList);
				// 6. Set the response properties
				  String fileName = pocode+"-"+orderdate+".xls";
				  response.setHeader("Content-Disposition", "inline; filename=" + fileName);
				  // Make sure to set the correct content type
				  response.setContentType("application/vnd.ms-excel");
				   
				  //7. Write to the output stream
				   // Retrieve the output stream
				   ServletOutputStream outputStream = response.getOutputStream();
				   // Write to the output stream
				   worksheet.getWorkbook().write(outputStream);
				   // Flush the stream
				   outputStream.flush();
			 }
			 
				 
		} catch (Exception e) {
			logger.error("Unable to find downloadXLSPurchaseorderView with error ", e);
		}
        logger.info("Exiting downloadXLSPurchaseorderView method ");
    }
    @SuppressWarnings("resource")
	@GetMapping("/povoucherspdf/{pocode}/{orderdate}")
    public void downloadPDFPurchaseorderView(@PathVariable("pocode") String pocode, @PathVariable("orderdate")String orderdate,
    		HttpServletResponse response) {
    	logger.info("Inside downloadXLSPurchaseorderView method ");
        List<PurchaseorderView> poList=null;
        try {
			 poList = this.poViewService.fetchPOWithCodeAndDate(pocode, orderdate);
			 if(!Objects.isNull(poList)){
				// 1. Create new workbook
				  HSSFWorkbook workbook = new HSSFWorkbook();
				   
				  // 2. Create new worksheet
				  HSSFSheet worksheet = workbook.createSheet("Vouchers");
				// 3. Define starting indices for rows and columns
				  int startRowIndex = 0;
				  int startColIndex = 0;

				  FilePOVoucherUtils.buildReport(worksheet, startRowIndex, startColIndex, pocode, orderdate);
				  
				  FilePOVoucherUtils.fillReport(worksheet, startRowIndex, startColIndex, poList);
				// 6. Set the response properties
				  String fileName = pocode+"-"+orderdate+".pdf";
				  response.setHeader("Content-Disposition", "inline; filename=" + fileName);
				  // Make sure to set the correct content type
				  response.setContentType("application/pdf");
				   
				  //7. Write to the output stream
				   // Retrieve the output stream
				   ServletOutputStream outputStream = response.getOutputStream();
				   // Write to the output stream
				   worksheet.getWorkbook().write(outputStream);
				   // Flush the stream
				   outputStream.flush();
			 }
			 
				 
		} catch (Exception e) {
			logger.error("Unable to find downloadXLSPurchaseorderView with error ", e);
		}
        logger.info("Exiting downloadXLSPurchaseorderView method ");
    }
    
}
