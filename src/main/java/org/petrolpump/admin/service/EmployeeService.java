package org.petrolpump.admin.service;

import org.petrolpump.admin.model.EmployeeModel;
import java.util.*;
public interface EmployeeService {
	public boolean isAddNewEmployee(EmployeeModel model);
	public List<EmployeeModel> getAllEmployees();
}
