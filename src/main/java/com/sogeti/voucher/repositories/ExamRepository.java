/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.models.Exam;



/**
 * @author vkalyana
 *
 */
@Transactional
public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query("SELECT e FROM Exam e WHERE e.employee = :employee AND e.status IN :status ORDER BY e.examdate DESC")
	public List<Exam> findByEmployeeAndStatus(@Param("employee")Employee employee, @Param("status")List<String> status);

}
