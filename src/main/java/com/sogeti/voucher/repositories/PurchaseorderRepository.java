/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Purchaseorder;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface PurchaseorderRepository extends JpaRepository<Purchaseorder, String>{

}
