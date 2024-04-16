package org.petrolpump.admin.repository;

import java.util.ArrayList;
import java.util.List;

import org.petrolpump.admin.DBConfig.DBConfig;
import org.petrolpump.admin.model.FuelTypeModel;

public class FuelRepositoryImpl extends DBConfig implements FuelRepository{
	List<FuelTypeModel> list;
	@Override
	public boolean isAddFuelType(FuelTypeModel model) {
		try {
			stmt=conn.prepareStatement("insert into fueltype values('0',?)");
		    stmt.setString(1, model.getName());
		    int value=stmt.executeUpdate();
		    return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}

	@Override
	public List<FuelTypeModel> getAllFuelTpes() {
		list=new ArrayList<FuelTypeModel>();
		try {
			stmt=conn.prepareStatement("select * from fueltype");
			rs=stmt.executeQuery();
			while(rs.next()) {
				FuelTypeModel model=new FuelTypeModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list.size()>0?list:null;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
	}

	@Override
	public boolean isDeleteFuelTypeById(int id) {
		try {
			stmt=conn.prepareStatement("delete from fueltype where typeid=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.err.println("Error is "+e);
			return false;
		}
	}

	@Override
	public boolean isUpdateFuelType(FuelTypeModel model) {
		try {
			stmt=conn.prepareStatement("update fueltype set type=? where typeid=?");
			stmt.setString(1, model.getName());
			stmt.setInt(2, model.getId());
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			return false;
		}
	}

}
