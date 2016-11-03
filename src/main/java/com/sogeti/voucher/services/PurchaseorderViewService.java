/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.PurchaseorderView;

/**
 * @author vkalyana
 *
 */
public interface PurchaseorderViewService {

	public List<PurchaseorderView> fetchPOWithCodeAndDate(String code, String orderDate) throws Exception;
}
