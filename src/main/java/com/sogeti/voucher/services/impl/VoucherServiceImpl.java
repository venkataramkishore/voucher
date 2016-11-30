/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Voucher;
import com.sogeti.voucher.repositories.VoucherRepository;
import com.sogeti.voucher.services.VoucherService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class VoucherServiceImpl implements VoucherService {

	
	@Autowired
	private VoucherRepository VoucherRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#create(com.sogeti.voucher.models.Exam)
	 */
	@Override
	public Voucher create(Voucher emp) {
		return this.VoucherRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.VoucherService#delete(int)
	 */
	@Override
	public Voucher delete(Long id) throws Exception {
		Voucher deletedVoucher = this.VoucherRepo.findOne(id);
        
        if (deletedVoucher == null)
            throw new Exception("No Voucher with id : " + id);
         
        this.VoucherRepo.delete(deletedVoucher);
        return deletedVoucher;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.VoucherService#findAll()
	 */
	@Override
	public List<Voucher> findAll() {
		return this.VoucherRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.VoucherService#update(com.sogeti.voucher.models.Voucher)
	 */
	@Override
	public Voucher update(Voucher Voucher) throws Exception {
		Voucher updatedVoucher = this.VoucherRepo.findOne(Voucher.getId());
        
        if (updatedVoucher == null)
            throw new Exception("No Voucher with id : "+Voucher.getId());
         
        return updatedVoucher;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.VoucherService#findById(int)
	 */
	@Override
	public Voucher findById(Long id) {
		return this.VoucherRepo.findOne(id);
	}

	@Override
	public List<Voucher> getExpiringVouchers(Date maxDate) {
		return this.VoucherRepo.getExpiringVouchers(maxDate);
	}

}
