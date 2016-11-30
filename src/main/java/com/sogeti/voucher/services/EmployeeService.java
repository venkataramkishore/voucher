/**
 * 
 */
package com.sogeti.voucher.services;

import java.util.List;

import com.sogeti.voucher.exception.EmployeeNotFound;
import com.sogeti.voucher.models.Employee;

/**
 * @author vkalyana
 *
 */
public interface EmployeeService {

	public Employee create(Employee emp);
    public Iterable<Employee> findAll();
    public Employee update(Employee Employee) throws EmployeeNotFound;
    public Employee findById(Long id);
    public Employee findByUsername(String username) throws EmployeeNotFound;
    public List<Employee> findByInService() throws EmployeeNotFound;
    public List<Employee> findByOutService() throws EmployeeNotFound;
	Employee delete(Long id) throws EmployeeNotFound;
	public List<Employee> findManagers()  throws EmployeeNotFound;
	public List<Employee> findAdmins()  throws EmployeeNotFound;
	public List<Employee> findMyEmployees(Long managerid)  throws EmployeeNotFound;
}
