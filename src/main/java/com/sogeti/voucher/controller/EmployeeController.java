/**
 * 
 */
package com.sogeti.voucher.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/managers")
    public VoucherResponse managerList() {
    	logger.info("Inside managerList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Employee> empList = this.empService.findManagers();
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
    
    @GetMapping("/admins")
    public VoucherResponse adminsList() {
    	logger.info("Inside adminsList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Employee> empList = this.empService.findAdmins();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find employees with ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Inside adminsList method ");
        return voucherResponse;
    }
    @GetMapping("/activeemployees")
    public VoucherResponse activeEmployeeList() {
    	logger.info("Inside activeEmployeeList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Employee> empList = this.empService.findByInService();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find employees with ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Inside activeEmployeeList method ");
        return voucherResponse;
    }
    
    @GetMapping("/inactiveemployees")
    public VoucherResponse inactiveEmployeeList() {
    	logger.info("Inside inactiveEmployeeList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Employee> empList = this.empService.findByOutService();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find employees with ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Inside inactiveEmployeeList method ");
        return voucherResponse;
    }
    
    @GetMapping("/myactiveemployees")
    public VoucherResponse myActiveEmployeeList(Principal user) {
    	logger.info("Inside myActiveEmployeeList method ");
        VoucherResponse voucherResponse;
		try {
			Employee emp = this.empService.findByUsername(user.getName());
			
			Iterable<Employee> empList = this.empService.findMyEmployees(emp.getId());
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find employees with ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Inside myActiveEmployeeList method ");
        return voucherResponse;
    }
    
    
    @PostMapping("/employee")
    public VoucherResponse saveEmployee(@RequestBody Employee employee) {
    	logger.info("Inside saveEmployee method ");
        VoucherResponse voucherResponse;
        try {
			Employee emp= this.empService.create(employee);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse( emp );
		} catch (Exception e) {
			logger.error("Unable to save Employee with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create employee ");
		}
        logger.info("Exiting saveEmployee method ");
        return voucherResponse;
    } 
    
    @PutMapping("/employee")
    public VoucherResponse updateEmployee(@RequestBody Employee employee) {
    	logger.info("Inside updateEmployee method ");
        VoucherResponse voucherResponse;
        try {
			Employee emp = this.empService.update(employee);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(emp);
		} catch (Exception e) {
			logger.error("Unable to find employee with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to update employee ");
		}
        logger.info("Exiting updateEmployee method ");
        return voucherResponse;
    } 
}
