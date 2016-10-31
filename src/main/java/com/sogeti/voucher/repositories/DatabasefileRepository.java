/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Databasefile;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface DatabasefileRepository extends JpaRepository<Databasefile, Long>{

}
