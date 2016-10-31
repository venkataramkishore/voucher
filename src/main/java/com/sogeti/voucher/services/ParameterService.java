/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Parameter;

/**
 * @author vkalyana
 *
 */
public interface ParameterService {

	public Parameter create(Parameter Parameter);
    public List<Parameter> findAll();
    public Parameter update(Parameter Parameter) throws Exception;
    public Parameter findById(Long id);
	Parameter delete(Long id) throws Exception;
	
}
