package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.repository.MachineRepository;
import org.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineServiceImpl implements MachineService {
	MachineRepository m=new MachineRepositoryImpl();
	@Override
	public boolean isAddNewMachine(MachineModel model,String[] ftypeId,String[] capArray) {
		
		return m.isAddNewMachine(model,ftypeId,capArray);
	}
	@Override
	public List<Object[]> getAllMachines() {
		return m.getAllMachines();
	}
	@Override
	public boolean isDeleteMachineById(int mid) {
		
		return m.isDeleteMachineById(mid);
	}
	@Override
	public boolean isUpdateMachine(MachineModel model) {
		
		return m.isUpdateMachine(model);
	}
	

}
