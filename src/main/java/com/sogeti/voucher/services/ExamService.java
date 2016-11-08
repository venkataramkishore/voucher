/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.enums.ExamStatus;
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
	
}
