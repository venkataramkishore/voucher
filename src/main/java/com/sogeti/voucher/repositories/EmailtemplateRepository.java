/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Emailtemplate;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface EmailtemplateRepository extends JpaRepository<Emailtemplate, Long>{

}
