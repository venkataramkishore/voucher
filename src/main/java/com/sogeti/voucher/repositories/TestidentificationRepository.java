/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Testidentification;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface TestidentificationRepository extends JpaRepository<Testidentification, Long>{

}
