package org.petrolpump.admin.service;

import java.util.*;

import org.petrolpump.admin.model.FuelTypeModel;

public interface FuelService {
	public boolean isAddFuelModel(FuelTypeModel model);
	public List<FuelTypeModel> getAllFuelTypes();
	public boolean isDeleteFuelTypeById(int id);
	public boolean isUpdateFuelType(FuelTypeModel model);
	
}
