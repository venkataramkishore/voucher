/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.PurchaseorderView;
import com.sogeti.voucher.repositories.PurchaseorderViewRepository;
import com.sogeti.voucher.services.PurchaseorderViewService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class PurchaseorderViewServiceImpl implements PurchaseorderViewService {
	
	@Autowired
	private PurchaseorderViewRepository viewRepo;
	
	@Override
	public List<PurchaseorderView> fetchPOWithCodeAndDate(String code, String orderDate) throws Exception {
		return this.viewRepo.fetchPOWithCodeAndDate(code, orderDate);
	}
}
