/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.models.Voucher;

/**
 * @author vkalyana
 *
 */
public interface VoucherService {

	public Voucher create(Voucher Voucher);
    public List<Voucher> findAll();
    public Voucher update(Voucher Voucher) throws Exception;
    public Voucher findById(Long id);
	Voucher delete(Long id) throws Exception;
	
}
