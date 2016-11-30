/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.enums.ExamStatus;
import com.sogeti.voucher.models.Certificate;
import com.sogeti.voucher.models.Company;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.models.Exam;
import com.sogeti.voucher.repositories.ExamRepository;
import com.sogeti.voucher.services.ExamService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=Exception.class)
public class ExamServiceImpl implements ExamService {

	
	@Autowired
	private ExamRepository ExamRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#create(com.sogeti.voucher.models.Exam)
	 */
	@Override
	public Exam create(Exam emp) {
		return this.ExamRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#delete(int)
	 */
	@Override
	public Exam delete(Long id) throws Exception {
		Exam deletedExam = this.ExamRepo.findOne(id);
        
        if (deletedExam == null)
            throw new Exception("No Exam with id : " + id);
         
        this.ExamRepo.delete(deletedExam);
        return deletedExam;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#findAll()
	 */
	@Override
	public List<Exam> findAll() {
		return this.ExamRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#update(com.sogeti.voucher.models.Exam)
	 */
	@Override
	public Exam update(Exam Exam) throws Exception {
		Exam updatedExam = this.ExamRepo.findOne(Exam.getId());
        
        if (updatedExam == null)
            throw new Exception("No Exam with id : "+Exam.getId());
         
        return updatedExam;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.ExamService#findById(int)
	 */
	@Override
	public Exam findById(Long id) {
		return this.ExamRepo.findOne(id);
	}

	@Override
	public List<Exam> findByEmployeeAndStatus(Employee employee, List<String> status) {
		return this.ExamRepo.findByEmployeeAndStatus(employee, status);
	}
	
	@Override
	public List<Exam> findByEmployeeCompanyAndStatus(Employee employee, Company comp, List<String> status) {
		return this.ExamRepo.findByEmployeeCompanyAndStatus(employee.getId(), comp, status);
	}

	@Override
	public Long getSuccessCertifiedCount(Certificate cert) {
		return this.ExamRepo.getSuccessCertifiedCount(cert);
	}
	@Override
	public List<Exam> getAllPendingExams(List<String> status) {
		return this.ExamRepo.getAllPendingExams(status);
	}
	
	@Override
	public Date getMonthExamList(Long managerId, List<String> status) {
		return this.ExamRepo.getMonthExamList(managerId, status);
	}
}
