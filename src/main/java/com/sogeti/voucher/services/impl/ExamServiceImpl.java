/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
