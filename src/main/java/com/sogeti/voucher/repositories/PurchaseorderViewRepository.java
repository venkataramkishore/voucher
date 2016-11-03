/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.PurchaseorderView;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface PurchaseorderViewRepository extends JpaRepository<PurchaseorderView, Long>{

	@Query("select pov from PurchaseorderView pov where pov.code= :code and pov.orderdate= to_date(:orderDate, 'YYYY/MM/DD')")
	public List<PurchaseorderView> fetchPOWithCodeAndDate(@Param("code") String code, @Param("orderDate") String orderDate);
}
