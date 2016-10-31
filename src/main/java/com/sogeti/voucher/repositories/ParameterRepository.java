/**
 * 
 */
package com.sogeti.voucher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.models.Parameter;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface ParameterRepository extends JpaRepository<Parameter, Long>{

}
