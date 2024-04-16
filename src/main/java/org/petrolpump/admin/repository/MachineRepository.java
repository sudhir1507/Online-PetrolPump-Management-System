package org.petrolpump.admin.repository;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;

public interface MachineRepository {
	public boolean isAddNewMachine(MachineModel model,String[] ftypeId,String[] capArray);
	public List<Object[]> getAllMachines();
	public boolean isDeleteMachineById(int mid);
    public boolean isUpdateMachine(MachineModel model);
}
