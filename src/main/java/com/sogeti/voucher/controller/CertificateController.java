/**
 * 
 */
package com.sogeti.voucher.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.models.CertifiedCountPerCertificate;
import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.services.CertificateService;
import com.sogeti.voucher.services.CompanyService;
import com.sogeti.voucher.services.EmployeeService;
import com.sogeti.voucher.services.ExamService;
import com.sogeti.voucher.ui.models.UICertificate;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

/**
 * @author vkalyana
 *
 */
@RestController
public class CertificateController {

	private static final Logger logger = Logger.getLogger(CertificateController.class);
	
	@Autowired
	private CertificateService  certificateService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ExamService examService;
	
    @GetMapping("/certificates")
    public VoucherResponse certificateList() {
    	logger.info("Inside certificateList method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Certificate> certificateList = this.certificateService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(certificateList);
		} catch (Exception e) {
			logger.error("Unable to find certificates with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Exiting certificateList method ");
        return voucherResponse;
    }
    
    @GetMapping("/activecertificates")
    public VoucherResponse getActiveCertificates() {
    	logger.info("Inside getActiveCertificates method ");
        VoucherResponse voucherResponse;
		try {
			Iterable<Certificate> certificateList = this.certificateService.findAll();
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(certificateList);
		} catch (Exception e) {
			logger.error("Unable to find active certificates with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse(e.getMessage());
		}
		logger.info("Exiting getActiveCertificates method ");
        return voucherResponse;
    }
    
    @GetMapping("/certificate/{paramId}")
    public VoucherResponse getcertificate(@PathVariable("paramId") Long certificateId) {
    	logger.info("Inside getcertificate method ");
        VoucherResponse voucherResponse;
        try {
			Certificate comp = this.certificateService.findById(certificateId);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to find certificate with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to find certificate with id: "+ certificateId);
		}
        logger.info("Exiting getcertificate method ");
        return voucherResponse;
    }
    
    @PostMapping("/certificate")
    public VoucherResponse savecertificate(@RequestBody UICertificate uiCertificate) {
    	logger.info("Inside savecertificate method ");
        VoucherResponse voucherResponse;
        try {
        	
			Certificate certificate = new Certificate();
			BeanUtils.copyProperties(uiCertificate, certificate);
			Company company = this.companyService.findById(uiCertificate.getCompanyId());
			certificate.setCompany(company);
			
			this.certificateService.create(certificate);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(certificate);
		} catch (Exception e) {
			logger.error("Unable to find certificate with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to create certificate ");
		}
        logger.info("Exiting savecertificate method ");
        return voucherResponse;
    } 
    @PutMapping("/certificate")
    public VoucherResponse updatecertificate(@RequestBody UICertificate uiCertificate) {
    	logger.info("Inside updatecertificate method ");
        VoucherResponse voucherResponse;
        try {
        	Certificate cert = this.certificateService.findById(uiCertificate.getId());
        	BeanUtils.copyProperties(uiCertificate, cert);
        	Company company = this.companyService.findById(uiCertificate.getCompanyId());
			cert.setCompany(company);
			
			Certificate param = this.certificateService.update(cert);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(param);
		} catch (Exception e) {
			logger.error("Unable to find certificate with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not able to update certificate ");
		}
        logger.info("Exiting updatecertificate method ");
        return voucherResponse;
    } 
    
    @DeleteMapping("/certificate/{paramId}")
    public VoucherResponse deletecertificate(@PathVariable("paramId") Long certificateId) {
    	logger.info("Inside deletecertificate method ");
        VoucherResponse voucherResponse;
        try {
			Certificate comp = this.certificateService.findById(certificateId);
			if(Objects.isNull(comp)){
				this.certificateService.delete(comp.getId());
			}
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(comp);
		} catch (Exception e) {
			logger.error("Unable to delete certificate with error ", e);
			voucherResponse = new VoucherResponse();
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Unable to delete certificate with id: "+ certificateId);
		}
        logger.info("Exiting deletecertificate method ");
        return voucherResponse;
    }
    @GetMapping("/issuecertificates")
    public VoucherResponse getIssuedCertificates(Principal user) {
    	logger.info("Inside getIssuedCertificates method with "+ user.getName());
    	 VoucherResponse voucherResponse = new VoucherResponse();
         try {
        	 Employee emp = this.empService.findByUsername(user.getName());
        	 if(!Objects.isNull(emp)){
        		List<Certificate>  certList = this.certificateService.getIssuedCertificates("ISSUED", emp);
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(certList);
        	 }
 		} catch (Exception e) {
 			logger.error("Unable to delete certificate with error ", e);
 			voucherResponse.setStatus(VoucherConstants.FAILURE);
 			voucherResponse.setFailureResponse("Unable to find issued certificates");
 		}
         logger.info("Exiting getIssuedCertificates method ");
         return voucherResponse;
    }
    
    @GetMapping("/certificatecountlist")
    public VoucherResponse getCertificateSuccessCountList(Principal user) {
    	logger.info("Inside getIssuedCertificates method with "+ user.getName());
    	 VoucherResponse voucherResponse = new VoucherResponse();
    	 List<CertifiedCountPerCertificate> certCntList = new ArrayList<>();
         try {
        	 List<Certificate> certList = this.certificateService.findAll();
        		for (Certificate certificate : certList) {
        			Long certifiedCount = examService.getSuccessCertifiedCount(certificate);
        			CertifiedCountPerCertificate ccpc = new CertifiedCountPerCertificate();
        			ccpc.setCompanyName(certificate.getCompany().getName());
        			ccpc.setCertificateName(certificate.getName());
        			ccpc.setCertificateAbbreviation(certificate.getAbbreviation());
        			ccpc.setCertifiedCount(certifiedCount);
        			certCntList.add(ccpc);
        		    }
      			voucherResponse.setStatus(VoucherConstants.SUCCESS);
      			voucherResponse.setSuccessResponse(certCntList);
        	 
 		} catch (Exception e) {
 			logger.error("Unable to delete certificate with error ", e);
 			voucherResponse.setStatus(VoucherConstants.FAILURE);
 			voucherResponse.setFailureResponse("Unable to find issued certificates");
 		}
         logger.info("Exiting getIssuedCertificates method ");
         return voucherResponse;
    }
    
}
