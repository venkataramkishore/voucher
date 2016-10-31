/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Exam;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface ExamRepository extends JpaRepository<Exam, Long>{

}
