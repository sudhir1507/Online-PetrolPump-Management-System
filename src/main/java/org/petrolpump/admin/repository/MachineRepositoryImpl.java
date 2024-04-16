package org.petrolpump.admin.repository;

import java.util.*;

import org.petrolpump.admin.DBConfig.DBConfig;
import org.petrolpump.admin.model.MachineModel;

public class MachineRepositoryImpl extends DBConfig implements MachineRepository{
	List<Object[]> list;
	int mid=0;
	public int getMachineIdAutometic() {
		
		try {
			stmt=conn.prepareStatement("select max(mid) from machineinfo");
			rs=stmt.executeQuery();
			if(rs.next()) {
				mid=rs.getInt(1);
			}
			return ++mid;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return -1;
		}
	}
	@Override
	public boolean isAddNewMachine(MachineModel model,String[] ftypeId,String[] capArray) {
		try {
			mid=this.getMachineIdAutometic();
			stmt=conn.prepareStatement("insert into machineinfo values(?,?)");
			stmt.setInt(1,mid);
			stmt.setString(2, model.getMachineCode());
			int value=stmt.executeUpdate();
			int j=0;
			if(value>0) {
				for(int i=0;i<capArray.length;i++) {
					if(capArray[i].equals("")){
						
					}
					else{              // when we dont select remaining check box there value added as null
						stmt=conn.prepareStatement("insert into machinetypejoin value(?,?,?)");       //for which we dont insert record in machinetypejoin
					    stmt.setInt(1, mid);
					    stmt.setInt(2, Integer.parseInt(ftypeId[j].trim()));
					    stmt.setInt(3, Integer.parseInt(capArray[i].trim()));
					    value=stmt.executeUpdate();
					    j++;
					}
				}
				return value>0?true:false;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}

	@Override
	public List<Object[]> getAllMachines() {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select m.machinecode,f.type,mtj.capacity,m.mid from machineinfo m left join machinetypejoin mtj on m.mid=mtj.mid left join fueltype f on mtj.typeid=f.typeid");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Object []obj=new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)};
				list.add(obj);
			}
			return list.size()>0?list:null;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean isDeleteMachineById(int mid) {
		try {
			stmt=conn.prepareStatement("delete from machineinfo where mid=?");
			stmt.setInt(1, mid);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	@Override
	public boolean isUpdateMachine(MachineModel model) {
		try {
			stmt=conn.prepareStatement("update machineinfo set machinecode=? where mid=? ");
			stmt.setString(1, model.getMachineCode());
			stmt.setInt(2, model.getId());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
	}

}
