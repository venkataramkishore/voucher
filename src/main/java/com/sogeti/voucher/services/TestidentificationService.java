/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Testidentification;

/**
 * @author vkalyana
 *
 */
public interface TestidentificationService {

	public Testidentification create(Testidentification Testidentification);
    public List<Testidentification> findAll();
    public Testidentification update(Testidentification Testidentification) throws Exception;
    public Testidentification findById(Long id);
	Testidentification delete(Long id) throws Exception;
	
}
