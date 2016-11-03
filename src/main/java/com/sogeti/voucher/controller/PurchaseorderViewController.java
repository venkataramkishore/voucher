/**
 * 
 */
package com.sogeti.voucher.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.PurchaseorderView;
import com.sogeti.voucher.services.PurchaseorderViewService;
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
    
}
