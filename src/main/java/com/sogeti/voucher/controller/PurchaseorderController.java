/**
 * 
 */
package com.sogeti.voucher.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.Purchaseorder;
import com.sogeti.voucher.services.PurchaseorderService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class PurchaseorderController {

	private static final Logger logger = Logger.getLogger(PurchaseorderController.class);
	
	@Autowired
	private PurchaseorderService  purchaseorderService;
	
    @GetMapping("/purchaseorders")
    public VoucherResponse purchaseorderList() {
    	logger.info("Inside PurchaseorderList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Purchaseorder> empList = this.purchaseorderService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find Purchaseorders with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Exiting PurchaseorderList method ");
        return voucherResponse;
    }
    
    @GetMapping("/purchaseorder/{pocode}/{orderdate}")
    public VoucherResponse getPurchaseorder(@PathVariable("pocode") String pocode, @PathVariable("orderdate")String orderdate) {
    	logger.info("Inside getPurchaseorder method ");
        VoucherResponse voucherResponse;
        Purchaseorder comp=null;
        try {
			 comp = this.purchaseorderService.findByPO(pocode, orderdate);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Purchaseorder with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to find Purchaseorder with id: "+ pocode);
		}
        logger.info("Exiting getPurchaseorder method ");
        return voucherResponse;
    }
    
    @PostMapping("/Purchaseorder")
    public VoucherResponse savePurchaseorder(@RequestBody Purchaseorder purchaseorder) {
    	logger.info("Inside getPurchaseorder method ");
        VoucherResponse voucherResponse;
        try {
			Purchaseorder comp = this.purchaseorderService.create(purchaseorder);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Purchaseorder with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create Purchaseorder ");
		}
        logger.info("Exiting getPurchaseorder method ");
        return voucherResponse;
    } 
    @PutMapping("/purchaseorder")
    public VoucherResponse updatePurchaseorder(@RequestBody Purchaseorder purchaseorder) {
    	logger.info("Inside getPurchaseorder method ");
        VoucherResponse voucherResponse;
        try {
			Purchaseorder param = this.purchaseorderService.update(purchaseorder);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(param);
		} catch (Exception e) {
			logger.error("Unable to find Purchaseorder with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create Purchaseorder ");
		}
        logger.info("Exiting getPurchaseorder method ");
        return voucherResponse;
    } 
    
    @DeleteMapping("/purchaseorder/{pocode}")
    public VoucherResponse deletePurchaseorder(@PathVariable("pocode") String pocode) {
    	logger.info("Inside deletePurchaseorder method ");
        VoucherResponse voucherResponse;
        try {
			Purchaseorder comp = this.purchaseorderService.findByCode(pocode);
			if(Objects.isNull(comp)){
				this.purchaseorderService.delete(comp.getCode());
			}
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to delete Purchaseorder with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Unable to delete Purchaseorder with code: "+ pocode);
		}
        logger.info("Exiting deletePurchaseorder method ");
        return voucherResponse;
    }
}
