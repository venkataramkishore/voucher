/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Parameter;
import com.sogeti.voucher.repositories.ParameterRepository;
import com.sogeti.voucher.services.ParameterService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class ParameterServiceImpl implements ParameterService {

	
	@Autowired
	private ParameterRepository ParameterRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#create(com.sogeti.voucher.models.Parameter)
	 */
	@Override
	public Parameter create(Parameter emp) {
		return this.ParameterRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#delete(int)
	 */
	@Override
	public Parameter delete(Long id) throws Exception {
		Parameter deletedParameter = this.ParameterRepo.findOne(id);
        
        if (deletedParameter == null)
            throw new Exception("No Parameter with id : " + id);
         
        this.ParameterRepo.delete(deletedParameter);
        return deletedParameter;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#findAll()
	 */
	@Override
	public List<Parameter> findAll() {
		return this.ParameterRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#update(com.sogeti.voucher.models.Parameter)
	 */
	@Override
	public Parameter update(Parameter Parameter) throws Exception {
		Parameter updatedParameter = this.ParameterRepo.findOne(Parameter.getId());
        
        if (updatedParameter == null)
            throw new Exception("No Parameter with id : "+Parameter.getId());
         
        return updatedParameter;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#findById(int)
	 */
	@Override
	public Parameter findById(Long id) {
		return this.ParameterRepo.findOne(id);
	}

}
