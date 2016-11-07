/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.repositories.CompanyRepository;
import com.sogeti.voucher.services.CompanyService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
	private CompanyRepository companyRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CompanyService#create(com.sogeti.voucher.models.Company)
	 */
	@Override
	public Company create(Company emp) {
		return this.companyRepo.save(emp);
	}

	@Override
	public List<Company> findActiveCompanies() throws Exception {
		return this.companyRepo.findActiveCompanies();
	}
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CompanyService#delete(int)
	 */
	@Override
	public Company delete(Long id) throws Exception {
		Company deletedCompany = this.companyRepo.findOne(id);
        
        if (deletedCompany == null)
            throw new Exception("No Company with id : " + id);
         
        this.companyRepo.delete(deletedCompany);
        return deletedCompany;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CompanyService#findAll()
	 */
	@Override
	public List<Company> findAll() {
		return this.companyRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CompanyService#update(com.sogeti.voucher.models.Company)
	 */
	@Override
	public Company update(Company company) throws Exception {
		Company updatedCompany = this.companyRepo.findOne(company.getId());
        
        if (updatedCompany == null)
            throw new Exception("No Company with id : "+company.getId());
         
        return updatedCompany;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.CompanyService#findById(int)
	 */
	@Override
	public Company findById(Long id) {
		return this.companyRepo.findOne(id);
	}

	@Override
	public List<Company> findByStatus(String status) throws Exception {
		return null; //this.companyRepo.findByStatus();
	}
}
