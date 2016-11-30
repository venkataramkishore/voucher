package com.sogeti.voucher.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.Voucher;
import com.sogeti.voucher.services.VoucherService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author anhati
 *
 */
@RestController
public class VoucherController {

	private static final Logger logger = Logger.getLogger(VoucherController.class);
	
	@Autowired
	private VoucherService  voucherService;
	
	@GetMapping("/expiringvouchers")
    public VoucherResponse getExpiringVouchers(Principal user) {
    	logger.info("Inside getExpiringVouchers method with "+ user.getName());
    	 VoucherResponse voucherResponse = new VoucherResponse();
         try {
        	 Calendar calendar = Calendar.getInstance();
        		calendar.add(Calendar.MONTH, 3);
        		
        		List<Voucher>  voucherList = this.voucherService.getExpiringVouchers( calendar.getTime() );
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(voucherList);
        	 
 		} catch (Exception e) {
 			logger.error("Unable to find voucher ", e);
 			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
 		}
         logger.info("Exiting getExpiringVouchers method ");
         return voucherResponse;
    }
	
	
}
