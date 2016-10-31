/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Company;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long>{

	//public List<Company> findByStatus() throws Exception;
}
