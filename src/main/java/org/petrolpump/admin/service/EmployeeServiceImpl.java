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

}
