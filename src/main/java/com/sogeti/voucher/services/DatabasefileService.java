/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Databasefile;

/**
 * @author vkalyana
 *
 */
public interface DatabasefileService {

	public Databasefile create(Databasefile Databasefile);
    public List<Databasefile> findAll();
    public Databasefile update(Databasefile Databasefile) throws Exception;
    public Databasefile findById(Long id);
	Databasefile delete(Long id) throws Exception;
	
}
