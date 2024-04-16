package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.FuelTypeModel;
import org.petrolpump.admin.repository.FuelRepository;
import org.petrolpump.admin.repository.FuelRepositoryImpl;

public class FuelTypeServiceImpl  implements FuelService{
    FuelRepository fuelRepo=new FuelRepositoryImpl();
	@Override
	public boolean isAddFuelModel(FuelTypeModel model) {
		
		return fuelRepo.isAddFuelType(model);
	}
	@Override
	public List<FuelTypeModel> getAllFuelTypes() {
		
		return fuelRepo.getAllFuelTpes();
	}
	@Override
	public boolean isDeleteFuelTypeById(int id) {
		
		return fuelRepo.isDeleteFuelTypeById(id);
	}
	@Override
	public boolean isUpdateFuelType(FuelTypeModel model) {
		
		return fuelRepo.isUpdateFuelType(model);
	}

}
