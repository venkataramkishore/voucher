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

import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.models.Company;
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

	@Query("SELECT COUNT(e) FROM Exam e WHERE e.status = 'SUCCEEDED' AND e.certificate = :certificate AND e.employee.status = 'IN_SERVICE'")
	public Long getSuccessCertifiedCount(@Param("certificate") Certificate cert);
	
	@Query("SELECT e FROM Exam e WHERE e.status IN(:statusList) AND e.employee.status = 'IN_SERVICE' ORDER BY e.examdate DESC")
	public List<Exam> getAllPendingExams(@Param("statusList") List<String> status);

	@Query("SELECT e FROM Exam e WHERE e.status IN (:statusList) AND e.employee.managerid = :managerId AND e.certificate.company = :company AND e.employee.status ='IN_SERVICE' ORDER BY e.examdate DESC")
	public List<Exam> findByEmployeeCompanyAndStatus(@Param("managerId")Long managerId,  @Param("company") Company comp, @Param("statusList") List<String> status);
	
	@Query("SELECT e.examdate FROM Exam e WHERE e.employee.managerid = :managerId AND e.status IN(:statusList) ORDER BY e.examdate ASC")
	public Date getMonthExamList(@Param("managerId")Long managerId, @Param("statusList") List<String> status);
}
