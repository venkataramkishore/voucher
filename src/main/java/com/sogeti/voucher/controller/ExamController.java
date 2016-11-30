package com.sogeti.voucher.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.enums.ExamStatus;
import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.models.Exam;
import com.sogeti.voucher.services.CompanyService;
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
	
	@Autowired
	private CompanyService companyService;
	
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
	
	@GetMapping("/employeespendingexamlist/{companyId}")
    public VoucherResponse getEmployeesPendingExamList(Principal user, @PathVariable("companyId") Long companyId) {
    	logger.info("Inside getPendingExamList method with "+ user.getName());
    	 VoucherResponse voucherResponse = new VoucherResponse();
    	 Company comp= null;
    	 List<Exam>  examList = null;
         try {
        	 if(companyId > 0){
        		 comp =  this.companyService.findById(companyId);
        	 }
        	 
        	 Employee emp = this.empService.findByUsername(user.getName());
        	 if(!Objects.isNull(emp)){
        		 List<String> status = new ArrayList<String>();
        		 status.add(ExamStatus.PENDING.getValue());
        		 status.add(ExamStatus.NO_VOUCHER.getValue());
        		 if(companyId > 0 ){
        			 examList = this.examService.findByEmployeeCompanyAndStatus(emp, comp, status);
        		 }else{
        			 examList = this.examService.findByEmployeeAndStatus(emp, status);
        		 }
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
	
	
	@GetMapping("/allpendingexamlist")
    public VoucherResponse getAllPendingExams() {
    	logger.info("Inside getAllPendingExams method with ");
    	 VoucherResponse voucherResponse = new VoucherResponse();
         try {
        	  List<String> status = new ArrayList<String>();
        		 status.add(ExamStatus.PENDING.getValue());
        		 status.add(ExamStatus.NO_VOUCHER.getValue());
        		List<Exam>  examList = this.examService.getAllPendingExams(status);
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(examList);
        	 
 		} catch (Exception e) {
 			logger.error("Unable to find exam for employee ", e);
 			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
 		}
         logger.info("Exiting getAllPendingExams method ");
         return voucherResponse;
    }
	
	@GetMapping("/monthlist")
    public VoucherResponse getMonthList(Principal user) {
    	logger.info("Inside getMonthList method with ");
    	 VoucherResponse voucherResponse = new VoucherResponse();
         try {
        	 Employee emp = this.empService.findByUsername(user.getName());
        	 List<String> status = new ArrayList<String>();
    		 status.add(ExamStatus.FAILED.getValue());
    		 status.add(ExamStatus.SUCCEEDED.getValue());
    		 
        	 Date firstExamDate = examService.getMonthExamList(emp.getId(), status);
			    if (firstExamDate == null) {
			    	firstExamDate = new Date();
			    }
			    Date now = new Date();
			    Calendar calendar = Calendar.getInstance();
			    calendar.setTime(firstExamDate);
			    List<Date> monthsList = new ArrayList<Date>();
			    while (calendar.getTime().before(now)) {
	    			monthsList.add(0, calendar.getTime());
	    			calendar.add(Calendar.MONTH, 1);
			    }
        	 
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(monthsList);
        	 
 		} catch (Exception e) {
 			logger.error("Unable to find month list ", e);
 			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
 		}
         logger.info("Exiting getMonthList method ");
         return voucherResponse;
    }

}
