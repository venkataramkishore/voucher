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

import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.services.CompanyService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class CompanyController {

	private static final Logger logger = Logger.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService  companyService;
	
    @GetMapping("/companies")
    public VoucherResponse CompanyList() {
    	logger.info("Inside CompanyList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Company> empList = this.companyService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find Companys with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Exiting CompanyList method ");
        return voucherResponse;
    }
    
    @GetMapping("/company/{compId}")
    public VoucherResponse getCompany(@PathVariable("compId") Long companyId) {
    	logger.info("Inside getCompany method ");
        VoucherResponse voucherResponse;
        try {
			Company comp = this.companyService.findById(companyId);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Company with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to find company with id: "+ companyId);
		}
        logger.info("Exiting getCompany method ");
        return voucherResponse;
    }
    
    @PostMapping("/company")
    public VoucherResponse saveCompany(@RequestBody Company company) {
    	logger.info("Inside getCompany method ");
        VoucherResponse voucherResponse;
        try {
			Company comp = this.companyService.create(company);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Company with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create company ");
		}
        logger.info("Exiting getCompany method ");
        return voucherResponse;
    } 
    @PutMapping("/company")
    public VoucherResponse updateCompany(@RequestBody Company company) {
    	logger.info("Inside getCompany method ");
        VoucherResponse voucherResponse;
        try {
			Company comp = this.companyService.update(company);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Company with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create company ");
		}
        logger.info("Exiting getCompany method ");
        return voucherResponse;
    } 
    
    @DeleteMapping("/company/{compId}")
    public VoucherResponse deleteCompany(@PathVariable("compId") Long companyId) {
    	logger.info("Inside deleteCompany method ");
        VoucherResponse voucherResponse;
        try {
			Company comp = this.companyService.findById(companyId);
			if(Objects.isNull(comp)){
				this.companyService.delete(comp.getId());
			}
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to delete Company with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Unable to delete compnay with id: "+ companyId);
		}
        logger.info("Exiting deleteCompany method ");
        return voucherResponse;
    }
}
