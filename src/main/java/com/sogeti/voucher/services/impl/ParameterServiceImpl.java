/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
	private ParameterRepository parameterRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#create(com.sogeti.voucher.models.Parameter)
	 */
	@Override
	public Parameter create(Parameter emp) {
		return this.parameterRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#delete(int)
	 */
	@Override
	public Parameter delete(Long id) throws Exception {
		Parameter deletedParameter = this.parameterRepo.findOne(id);
        
        if (deletedParameter == null)
            throw new Exception("No Parameter with id : " + id);
         
        this.parameterRepo.delete(deletedParameter);
        return deletedParameter;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#findAll()
	 */
	@Override
	public List<Parameter> findAll() {
		return this.parameterRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#update(com.sogeti.voucher.models.Parameter)
	 */
	@Override
	public Parameter update(Parameter parameter) throws Exception {
		Parameter updatedParameter = this.parameterRepo.findOne(parameter.getId());
        
        if (updatedParameter == null)
            throw new Exception("No Parameter with id : "+parameter.getId());
        
        BeanUtils.copyProperties(parameter, updatedParameter);
        this.parameterRepo.save(updatedParameter);
         
        return updatedParameter;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ParameterService#findById(int)
	 */
	@Override
	public Parameter findById(Long id) {
		return this.parameterRepo.findOne(id);
	}

}
