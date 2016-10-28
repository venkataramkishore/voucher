/**
 * 
 */
package com.sogeti.voucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.voucher.exception.EmployeeNotFound;
import com.sogeti.voucher.models.Employee;
import com.sogeti.voucher.repositories.EmployeeRepository;
import com.sogeti.voucher.services.EmployeeService;

/**
 * @author vkalyana
 *
 */
@Service
@Repository
@Transactional(noRollbackFor=EmployeeNotFound.class)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmployeeService#create(com.sogeti.voucher.models.Employee)
	 */
	@Override
	public Employee create(Employee emp) {
		return this.empRepo.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmployeeService#delete(int)
	 */
	@Override
	public Employee delete(Long id) throws EmployeeNotFound {
		Employee deletedEmployee = this.empRepo.findOne(id);
        
        if (deletedEmployee == null)
            throw new EmployeeNotFound("No employee with id : " + id);
         
        this.empRepo.delete(deletedEmployee);
        return deletedEmployee;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmployeeService#findAll()
	 */
	@Override
	public Iterable<Employee> findAll() {
		return this.empRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmployeeService#update(com.sogeti.voucher.models.Employee)
	 */
	@Override
	public Employee update(Employee emp) throws EmployeeNotFound {
		Employee updatedEmployee = this.empRepo.findOne(emp.getId());
        
        if (updatedEmployee == null)
            throw new EmployeeNotFound("No employee with id : "+emp.getId());
         
        return updatedEmployee;
	}

	/* (non-Javadoc)
	 * @see com.sogeti.voucher.services.EmployeeService#findById(int)
	 */
	@Override
	public Employee findById(Long id) {
		return this.empRepo.findOne(id);
	}
	
	@Override
	public List<Employee> findByInService() throws EmployeeNotFound {
		return this.empRepo.findByInService();
	}
	@Override
	public List<Employee> findByOutService() throws EmployeeNotFound {
		return this.empRepo.findByOutService();
	}
	@Override
	public Employee findByUsername(String username) throws EmployeeNotFound {
		return this.empRepo.findByUsername(username);
	}
}
