/**
 * 
 */
package com.sogeti.voucher.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.services.EmployeeService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService  empService;
	
    @GetMapping("/employees")
    public VoucherResponse employeeList() {
    	logger.info("Inside employeeList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Employee> empList = this.empService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find employees with ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Inside employeeList method ");
        return voucherResponse;
    }
     
}
