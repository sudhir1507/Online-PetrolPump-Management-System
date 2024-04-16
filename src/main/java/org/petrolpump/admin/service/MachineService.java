package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;

public interface MachineService {
	public boolean isAddNewMachine(MachineModel model,String[] ftypeId,String[] capArray);
	public List<Object[]> getAllMachines();
	public boolean isDeleteMachineById(int mid);
	public boolean isUpdateMachine(MachineModel model);
}
