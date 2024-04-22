package org.petrolpump.admin.repository;

import org.petrolpump.admin.model.EmployeeModel;
import java.util.*;
public interface EmployeeRepository {
  public boolean isAddNewEmployee(EmployeeModel model);
  public List<EmployeeModel> getAllEmployees();
  public boolean allocateMachine(int eid,int mid,String ...x);
  public boolean deleteEmployeeById(int eid);
  public boolean updateEmployeeById(EmployeeModel model);
  public int verifyEmployee(String email,String contact);
  public EmployeeModel getProfile(int employeeId);
  public boolean updateprofile(EmployeeModel model);
  public List<Object[]> viewAllocatedMachies(int employeeId);
}
