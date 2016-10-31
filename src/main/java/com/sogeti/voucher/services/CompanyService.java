/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Company;

/**
 * @author vkalyana
 *
 */
public interface CompanyService {

	public Company create(Company emp);
    public List<Company> findAll();
    public Company update(Company Company) throws Exception;
    public Company findById(Long id);
    public List<Company> findByStatus(String username) throws Exception;
	Company delete(Long id) throws Exception;
	
}
