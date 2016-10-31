/**
 * 
 */
package com.sogeti.voucher.util;

/**
 * @author vkalyana
 *
 */
public class PrincipalUser {

	private String username;
	private String authority;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	/**
	 * @param username
	 * @param authority
	 */
	public PrincipalUser(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	
	
}
