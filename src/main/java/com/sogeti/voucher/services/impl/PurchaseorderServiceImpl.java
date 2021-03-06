/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Purchaseorder;
import com.sogeti.voucher.repositories.PurchaseorderRepository;
import com.sogeti.voucher.services.PurchaseorderService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class PurchaseorderServiceImpl implements PurchaseorderService {

	
	@Autowired
	private PurchaseorderRepository purchaseorderRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.PurchaseorderService#create(com.sogeti.voucher.models.Purchaseorder)
	 */
	@Override
	public Purchaseorder create(Purchaseorder emp) {
		return this.purchaseorderRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.PurchaseorderService#delete(int)
	 */
	@Override
	public Purchaseorder delete(String code) throws Exception {
		Purchaseorder deletedPurchaseorder = this.purchaseorderRepo.findOne(code);
        
        if (deletedPurchaseorder == null)
            throw new Exception("No Purchaseorder with id : " + code);
         
        this.purchaseorderRepo.delete(deletedPurchaseorder);
        return deletedPurchaseorder;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.PurchaseorderService#findAll()
	 */
	@Override
	public List<Purchaseorder> findAll() {
		return this.purchaseorderRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.PurchaseorderService#update(com.sogeti.voucher.models.Purchaseorder)
	 */
	@Override
	public Purchaseorder update(Purchaseorder Purchaseorder) throws Exception {
		Purchaseorder updatedPurchaseorder = null; //this.PurchaseorderRepo.findOne(Purchaseorder.getCode());
        
       /* if (updatedPurchaseorder == null)
            throw new Exception("No Purchaseorder with id : "+Purchaseorder.getId());
         */
        return updatedPurchaseorder;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.PurchaseorderService#findById(int)
	 */
	@Override
	public Purchaseorder findByCode(String id) {
		return this.purchaseorderRepo.findOne(id);
	}
	
	public Purchaseorder findByPO(String pocode, String orderdate) {
		return null;
	}
}
