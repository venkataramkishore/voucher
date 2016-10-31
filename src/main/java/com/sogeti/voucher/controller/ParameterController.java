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

import com.sogeti.voucher.models.Parameter;
import com.sogeti.voucher.services.ParameterService;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class ParameterController {

	private static final Logger logger = Logger.getLogger(ParameterController.class);
	
	@Autowired
	private ParameterService  parameterService;
	
    @GetMapping("/parameters")
    public VoucherResponse parameterList() {
    	logger.info("Inside ParameterList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Parameter> empList = this.parameterService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(empList);
		} catch (Exception e) {
			logger.error("Unable to find Parameters with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Exiting ParameterList method ");
        return voucherResponse;
    }
    
    @GetMapping("/parameter/{paramId}")
    public VoucherResponse getParameter(@PathVariable("paramId") Long parameterId) {
    	logger.info("Inside getParameter method ");
        VoucherResponse voucherResponse;
        try {
			Parameter comp = this.parameterService.findById(parameterId);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Parameter with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to find Parameter with id: "+ parameterId);
		}
        logger.info("Exiting getParameter method ");
        return voucherResponse;
    }
    
    @PostMapping("/parameter")
    public VoucherResponse saveParameter(@RequestBody Parameter Parameter) {
    	logger.info("Inside getParameter method ");
        VoucherResponse voucherResponse;
        try {
			Parameter comp = this.parameterService.create(Parameter);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find Parameter with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create Parameter ");
		}
        logger.info("Exiting getParameter method ");
        return voucherResponse;
    } 
    @PutMapping("/parameter")
    public VoucherResponse updateParameter(@RequestBody Parameter parameter) {
    	logger.info("Inside getParameter method ");
        VoucherResponse voucherResponse;
        try {
			Parameter param = this.parameterService.update(parameter);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(param);
		} catch (Exception e) {
			logger.error("Unable to find Parameter with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create Parameter ");
		}
        logger.info("Exiting getParameter method ");
        return voucherResponse;
    } 
    
    @DeleteMapping("/parameter/{paramId}")
    public VoucherResponse deleteParameter(@PathVariable("paramId") Long parameterId) {
    	logger.info("Inside deleteParameter method ");
        VoucherResponse voucherResponse;
        try {
			Parameter comp = this.parameterService.findById(parameterId);
			if(Objects.isNull(comp)){
				this.parameterService.delete(comp.getId());
			}
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to delete Parameter with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Unable to delete parameter with id: "+ parameterId);
		}
        logger.info("Exiting deleteParameter method ");
        return voucherResponse;
    }
}
