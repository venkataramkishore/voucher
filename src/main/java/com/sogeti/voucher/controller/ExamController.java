package com.sogeti.voucher.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.enums.ExamStatus;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.models.Exam;
import com.sogeti.voucher.services.EmployeeService;
import com.sogeti.voucher.services.ExamService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author anhati
 *
 */
@RestController
public class ExamController {

	private static final Logger logger = Logger.getLogger(ExamController.class);
	
	@Autowired
	private ExamService  examService;
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/pendingexamlist")
    public VoucherResponse getPendingExamList(Principal user) {
    	logger.info("Inside getPendingExamList method with "+ user.getName());
    	 VoucherResponse voucherResponse = new VoucherResponse();
         try {
        	 Employee emp = this.empService.findByUsername(user.getName());
        	 if(!Objects.isNull(emp)){
        		 List<String> status = new ArrayList<String>();
        		 status.add(ExamStatus.PENDING.getValue());
        		 status.add(ExamStatus.NO_VOUCHER.getValue());
        		List<Exam>  examList = this.examService.findByEmployeeAndStatus(emp, status);
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(examList);
        	 }
 		} catch (Exception e) {
 			logger.error("Unable to find exam for employee ", e);
 			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
 		}
         logger.info("Exiting getPendingExamList method ");
         return voucherResponse;
    }
}
