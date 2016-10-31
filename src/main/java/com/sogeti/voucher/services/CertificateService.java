/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Certificate;

/**
 * @author vkalyana
 *
 */
public interface CertificateService {

	public Certificate create(Certificate certificate);
    public List<Certificate> findAll();
    public Certificate update(Certificate Certificate) throws Exception;
    public Certificate findById(Long id);
	Certificate delete(Long id) throws Exception;
	
}
