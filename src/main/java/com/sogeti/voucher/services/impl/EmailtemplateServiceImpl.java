/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Emailtemplate;
import com.sogeti.voucher.repositories.EmailtemplateRepository;
import com.sogeti.voucher.services.EmailtemplateService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class EmailtemplateServiceImpl implements EmailtemplateService {

	
	@Autowired
	private EmailtemplateRepository EmailtemplateRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmailtemplateService#create(com.sogeti.voucher.models.Emailtemplate)
	 */
	@Override
	public Emailtemplate create(Emailtemplate emp) {
		return this.EmailtemplateRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmailtemplateService#delete(int)
	 */
	@Override
	public Emailtemplate delete(Long id) throws Exception {
		Emailtemplate deletedEmailtemplate = this.EmailtemplateRepo.findOne(id);
        
        if (deletedEmailtemplate == null)
            throw new Exception("No Emailtemplate with id : " + id);
         
        this.EmailtemplateRepo.delete(deletedEmailtemplate);
        return deletedEmailtemplate;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmailtemplateService#findAll()
	 */
	@Override
	public List<Emailtemplate> findAll() {
		return this.EmailtemplateRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmailtemplateService#update(com.sogeti.voucher.models.Emailtemplate)
	 */
	@Override
	public Emailtemplate update(Emailtemplate Emailtemplate) throws Exception {
		Emailtemplate updatedEmailtemplate = this.EmailtemplateRepo.findOne(Emailtemplate.getId());
        
        if (updatedEmailtemplate == null)
            throw new Exception("No Emailtemplate with id : "+Emailtemplate.getId());
         
        return updatedEmailtemplate;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmailtemplateService#findById(int)
	 */
	@Override
	public Emailtemplate findById(Long id) {
		return this.EmailtemplateRepo.findOne(id);
	}

}
