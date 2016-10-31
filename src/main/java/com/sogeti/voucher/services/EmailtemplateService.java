/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Emailtemplate;

/**
 * @author vkalyana
 *
 */
public interface EmailtemplateService {

	public Emailtemplate create(Emailtemplate Emailtemplate);
    public List<Emailtemplate> findAll();
    public Emailtemplate update(Emailtemplate Emailtemplate) throws Exception;
    public Emailtemplate findById(Long id);
	Emailtemplate delete(Long id) throws Exception;
	
}
