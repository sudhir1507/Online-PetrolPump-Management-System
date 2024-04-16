package org.petrolpump.admin.repository;

import org.petrolpump.admin.model.EmployeeModel;
import java.util.*;
public interface EmployeeRepository {
  public boolean isAddNewEmployee(EmployeeModel model);
  public List<EmployeeModel> getAllEmployees();
}
