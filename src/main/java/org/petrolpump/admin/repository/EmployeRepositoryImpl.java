package org.petrolpump.admin.repository;

import java.util.*;


import org.petrolpump.admin.DBConfig.DBConfig;
import org.petrolpump.admin.model.EmployeeModel;

public class EmployeRepositoryImpl extends DBConfig implements EmployeeRepository {
	List<EmployeeModel> list=new ArrayList<>();
	int empId=0;
	public int getEmployeeId() {
		try {
			stmt=conn.prepareStatement("select max(eid) from employee");
			rs=stmt.executeQuery();
			if(rs.next()) {
				empId=rs.getInt(1);
			}
		    return ++empId;
		}catch(Exception e) {
			return -1;
		}
	}
	@Override
	public boolean isAddNewEmployee(EmployeeModel model) {
		try {
			int employeeId=this.getEmployeeId();
			stmt=conn.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			stmt.setInt(1, employeeId);
			stmt.setString(2, model.getName());
			stmt.setString(3, model.getEmail());
			stmt.setString(4, model.getContact());
			stmt.setString(5, model.getAddress());
			stmt.setInt(6, model.getSal());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}
	@Override
	public List<EmployeeModel> getAllEmployees() {
		try {
			stmt=conn.prepareStatement("select * from employee");
			rs=stmt.executeQuery();
			while(rs.next()) {
				EmployeeModel model=new EmployeeModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContact(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setSal(rs.getInt(6));
				list.add(model);
			}
			return list.size()>0?list:null;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
	}

}
