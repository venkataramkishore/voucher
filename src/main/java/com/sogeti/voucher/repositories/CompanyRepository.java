/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Company;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long>{

	@Query("select cmp from Company cmp where cmp.status='ACTIVE'")
	public List<Company> findActiveCompanies();
}
