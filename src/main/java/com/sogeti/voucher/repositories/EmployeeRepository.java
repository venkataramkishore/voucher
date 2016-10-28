/**
 * 
 */
package com.sogeti.voucher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.exception.EmployeeNotFound;
import com.sogeti.voucher.models.Employee;

/**
 * @author vkalyana
 *
 */
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.status='IN_SERVICE' and LOWER(e.username) = LOWER(:username)")
    public Employee findByUsername(@Param("username") String username) throws EmployeeNotFound;
    
    public List<Employee> findByStatus(String status) throws EmployeeNotFound;
    
    @Query("select e from Employee e where e.status='IN_SERVICE'")
    public List<Employee> findByInService() throws EmployeeNotFound;
    
    @Query("select e from Employee e where e.status='OUT_SERVICE'")
    public List<Employee> findByOutService() throws EmployeeNotFound;
    
}
