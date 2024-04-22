package org.petrolpump.admin.repository;

import java.util.*;


import org.petrolpump.admin.DBConfig.DBConfig;
import org.petrolpump.admin.model.EmployeeModel;

public class EmployeRepositoryImpl extends DBConfig implements EmployeeRepository {
	List<EmployeeModel> list=new ArrayList<>();
	List<Object[]> lists;
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
	@Override
	public boolean allocateMachine(int eid, int mid, String ...x) {
		try {
			stmt=conn.prepareStatement("insert into employeemachinejoin values(?,?,?,?,?)");
			stmt.setInt(1, eid);
			stmt.setInt(2, mid);
			stmt.setString(3, x[0]);
			stmt.setString(4, x[1]);
			java.sql.Date d=java.sql.Date.valueOf(x[2]);
			stmt.setDate(5,d );
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean deleteEmployeeById(int eid) {
		try {
			stmt=conn.prepareStatement("delete from employee where eid=?");
			stmt.setInt(1, eid);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}
	@Override
	public boolean updateEmployeeById(EmployeeModel model) {
		try {
			stmt=conn.prepareStatement("update employee set name=?, email=?, contact=?, address=?, salary=? where eid=?");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, model.getSal());
			stmt.setInt(6, model.getId());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}
	@Override
	public int verifyEmployee(String email, String contact) {
		try {
			stmt=conn.prepareStatement("select * from employee where email=? and contact=?");
			stmt.setString(1, email);
			stmt.setString(2, contact);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return 0;
		}
	}
	@Override
	public EmployeeModel getProfile(int employeeId) {
		try {
			stmt=conn.prepareStatement("select * from employee where eid=?");
			stmt.setInt(1, employeeId);
			rs=stmt.executeQuery();
			EmployeeModel e=new EmployeeModel();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setContact(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setSal(rs.getInt(6));
				
			}
			return e;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
	}
	@Override
	public boolean updateprofile(EmployeeModel model) {
		try {
			stmt=conn.prepareStatement("update employee set name=?, email=?, contact=?, address=?, salary=? where eid=?");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, model.getSal());
			stmt.setInt(6, model.getId());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}
	@Override
	public List<Object[]> viewAllocatedMachies(int employeeId) {
		try {
			lists=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select m.machinecode,emj.date,emj.stime,emj.etime from machineinfo m inner join employeemachinejoin emj on m.mid=emj.mid and emj.date>curDate() inner join employee e on e.eid=emj.eid where e.eid=?");
			stmt.setInt(1, employeeId);
			rs=stmt.executeQuery();
			if(rs.next()) {
				Object []obj=new Object[] {rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)};
				lists.add(obj);
			}
			return lists.size()>0?lists:null;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
	}

}
