/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Purchaseorder;

/**
 * @author vkalyana
 *
 */
public interface PurchaseorderService {

	public Purchaseorder create(Purchaseorder Purchaseorder);
    public List<Purchaseorder> findAll();
    public Purchaseorder update(Purchaseorder Purchaseorder) throws Exception;
    public Purchaseorder findById(Long id);
	Purchaseorder delete(Long id) throws Exception;
	
}
