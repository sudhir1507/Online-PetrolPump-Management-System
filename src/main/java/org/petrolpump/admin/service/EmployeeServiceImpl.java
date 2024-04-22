package org.petrolpump.admin.service;

import org.petrolpump.admin.model.EmployeeModel;
import org.petrolpump.admin.repository.EmployeRepositoryImpl;
import org.petrolpump.admin.repository.EmployeeRepository;
import java.util.*;
public class EmployeeServiceImpl implements EmployeeService{
     EmployeeRepository empRepo=new  EmployeRepositoryImpl();
	@Override
	public boolean isAddNewEmployee(EmployeeModel model) {
		
		return empRepo.isAddNewEmployee(model);
	}
	@Override
	public List<EmployeeModel> getAllEmployees() {
		return empRepo.getAllEmployees();
	}
	@Override
	public boolean allocateMachine(int eid, int mid, String ...x) {
		
		return empRepo.allocateMachine(eid, mid, x);
	}
	@Override
	public boolean deleteEmployeeById(int eid) {
		
		return empRepo.deleteEmployeeById(eid);
	}
	@Override
	public boolean updateEmployeeById(EmployeeModel model) {
		
		return empRepo.updateEmployeeById(model);
	}
	@Override
	public int verifyEmployee(String email, String contact) {
		
		return empRepo.verifyEmployee(email,contact);
	}
	@Override
	public EmployeeModel getProfile(int employeeId) {
		
		return empRepo.getProfile(employeeId);
	}
	@Override
	public boolean updateprofile(EmployeeModel model) {
		
		return empRepo.updateprofile(model);
	}
	@Override
	public List<Object[]> viewAllocatedMachies(int employeeId) {
		
		return empRepo.viewAllocatedMachies(employeeId);
	}

}
