/**
 * 
 */
package com.sogeti.security.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author vkalyana
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomLdapAuthoritiesPopulator customAuthProperties;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .httpBasic()
        .and()
        .formLogin().loginPage("/login")
        .failureUrl("/login?error")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll()
        .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
          .anyRequest().authenticated()
          .and()
          .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().ldapAuthoritiesPopulator(customAuthProperties).contextSource().url("ldap://ldapserver.sgti.nl:3268").managerDn("ldapuser")
		.managerPassword("QSpSoEHK").and().userSearchBase("OU=Sogeti Users,DC=SGTI,DC=NL")
		.userSearchFilter("(sAMAccountName={0})");
	}
}