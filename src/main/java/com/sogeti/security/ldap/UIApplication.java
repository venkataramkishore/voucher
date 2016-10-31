package com.sogeti.security.ldap;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.voucher.util.PrincipalUser;
import com.sogeti.voucher.util.VoucherConstants;
import com.sogeti.voucher.util.VoucherResponse;

@SpringBootApplication
@ComponentScan(basePackages="com.sogeti")
@EntityScan("com.sogeti.voucher.models")
@EnableJpaRepositories(basePackages={"com.sogeti.voucher.repositories"})
@RestController
public class UIApplication {

	private static Logger logger = Logger.getLogger(UIApplication.class);
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		logger.info("principal user :: " + user.getName());
		return user;
	}
	
	private String authority;

	@RequestMapping("/authenticate")
	public VoucherResponse getAuthentication() {
		logger.info("principal authorities :: " +SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		logger.info("principal user :: " + SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
		VoucherResponse voucherResponse = new VoucherResponse();
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			//String authority = "";
			if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().isEmpty() &&
					SecurityContextHolder.getContext().getAuthentication().getAuthorities().size()>0){
				SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(  auth -> this.authority = auth.getAuthority());
				
			}else{
				this.authority= "ROLE_EMPLOYEE";
			}
			PrincipalUser currentUser = new PrincipalUser(username, authority);
			voucherResponse.setStatus(VoucherConstants.SUCCESS);
			voucherResponse.setSuccessResponse(currentUser);
			
		} catch (Exception e) {
			voucherResponse.setStatus(VoucherConstants.FAILURE);
			voucherResponse.setFailureResponse("Not a valid user credentials");
		}
		
		return voucherResponse;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}
}