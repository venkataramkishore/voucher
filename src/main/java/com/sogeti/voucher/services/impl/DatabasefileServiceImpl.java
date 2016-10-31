/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Databasefile;
import com.sogeti.voucher.repositories.DatabasefileRepository;
import com.sogeti.voucher.services.DatabasefileService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class DatabasefileServiceImpl implements DatabasefileService {

	
	@Autowired
	private DatabasefileRepository DatabasefileRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.DatabasefileService#create(com.sogeti.voucher.models.Databasefile)
	 */
	@Override
	public Databasefile create(Databasefile emp) {
		return this.DatabasefileRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.DatabasefileService#delete(int)
	 */
	@Override
	public Databasefile delete(Long id) throws Exception {
		Databasefile deletedDatabasefile = this.DatabasefileRepo.findOne(id);
        
        if (deletedDatabasefile == null)
            throw new Exception("No Databasefile with id : " + id);
         
        this.DatabasefileRepo.delete(deletedDatabasefile);
        return deletedDatabasefile;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.DatabasefileService#findAll()
	 */
	@Override
	public List<Databasefile> findAll() {
		return this.DatabasefileRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.DatabasefileService#update(com.sogeti.voucher.models.Databasefile)
	 */
	@Override
	public Databasefile update(Databasefile dbfile) throws Exception {
		Databasefile updatedDatabasefile = this.DatabasefileRepo.findOne(dbfile.getId());
        
        if (updatedDatabasefile == null)
            throw new Exception("No Databasefile with id : "+dbfile.getId());
         
        return updatedDatabasefile;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.DatabasefileService#findById(int)
	 */
	@Override
	public Databasefile findById(Long id) {
		return this.DatabasefileRepo.findOne(id);
	}

}
