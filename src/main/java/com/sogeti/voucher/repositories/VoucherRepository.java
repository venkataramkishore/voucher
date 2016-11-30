/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Voucher;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface VoucherRepository extends JpaRepository<Voucher, Long>{

	@Query("SELECT v FROM Voucher v WHERE v.status = 'AVAILABLE' AND v.validtill >= CURRENT_DATE AND v.validtill <= :maxDate ORDER BY v.validtill ASC")
	public List<Voucher> getExpiringVouchers(@Param("maxDate") Date maxDate);
}
