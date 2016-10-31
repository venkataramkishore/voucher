/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.repositories.CertificateRepository;
import com.sogeti.voucher.services.CertificateService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class CertificateServiceImpl implements CertificateService {

	
	@Autowired
	private CertificateRepository CertificateRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CertificateService#create(com.sogeti.voucher.models.Certificate)
	 */
	@Override
	public Certificate create(Certificate emp) {
		return this.CertificateRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CertificateService#delete(int)
	 */
	@Override
	public Certificate delete(Long id) throws Exception {
		Certificate deletedCertificate = this.CertificateRepo.findOne(id);
        
        if (deletedCertificate == null)
            throw new Exception("No Certificate with id : " + id);
         
        this.CertificateRepo.delete(deletedCertificate);
        return deletedCertificate;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CertificateService#findAll()
	 */
	@Override
	public List<Certificate> findAll() {
		return this.CertificateRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CertificateService#update(com.sogeti.voucher.models.Certificate)
	 */
	@Override
	public Certificate update(Certificate Certificate) throws Exception {
		Certificate updatedCertificate = this.CertificateRepo.findOne(Certificate.getId());
        
        if (updatedCertificate == null)
            throw new Exception("No Certificate with id : "+Certificate.getId());
         
        return updatedCertificate;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CertificateService#findById(int)
	 */
	@Override
	public Certificate findById(Long id) {
		return this.CertificateRepo.findOne(id);
	}

}
