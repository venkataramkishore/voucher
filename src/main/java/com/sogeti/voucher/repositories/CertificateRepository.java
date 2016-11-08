/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.models.Employee;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface CertificateRepository extends JpaRepository<Certificate, Long>{

	@Query("SELECT c FROM Certificate c WHERE c.status = :status AND c.id NOT IN(SELECT e.certificate FROM Exam e WHERE e.employee = :employee AND e.status = 'SUCCEEDED')")
	public List<Certificate> getIssuedCertificates(@Param("status")String status, @Param("employee")Employee employee);
}
