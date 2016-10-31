/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Certificate;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface CertificateRepository extends JpaRepository<Certificate, Long>{

}
