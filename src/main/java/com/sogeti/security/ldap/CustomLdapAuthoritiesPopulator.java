/**
 * 
 */
package com.sogeti.security.ldap;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import com.sogeti.voucher.exception.EmployeeNotFound;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.services.EmployeeService;

/**
 * @author vkalyana
 *
 */
@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
	private static final Logger logger = Logger.getLogger(CustomLdapAuthoritiesPopulator.class);
	
	@Autowired
	private EmployeeService empService;

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData,
			String username) {
		logger.info("Context with username: "+ username + " <> "  + userData);
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		try {
			Employee emp = this.empService.findByUsername(username);
			gas.add(new SimpleGrantedAuthority(emp.getRole()));
			logger.info("Able to find employee with role "+ emp.getRole());
		} catch (EmployeeNotFound e) {
			logger.error("Exception in finding role ", e);
			gas.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
		}

		return gas;
	}
}
