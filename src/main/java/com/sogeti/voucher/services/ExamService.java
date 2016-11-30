/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.Date;
import java.util.List;

import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.models.Exam;

/**
 * @author vkalyana
 *
 */
public interface ExamService {

	public Exam create(Exam Exam);
    public List<Exam> findAll();
    public Exam update(Exam Exam) throws Exception;
    public Exam findById(Long id);
	Exam delete(Long id) throws Exception;
	public List<Exam> findByEmployeeAndStatus(Employee employee, List<String> status);
	public Long getSuccessCertifiedCount(Certificate cert);
	public List<Exam> getAllPendingExams(List<String> status);
	public List<Exam> findByEmployeeCompanyAndStatus(Employee employee, Company comp, List<String> status) ;
	public Date getMonthExamList(Long managerId, List<String> status);
}
