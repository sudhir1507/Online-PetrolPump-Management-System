package org.petrolpump.admin.repository;

import org.petrolpump.admin.model.FuelTypeModel;
import java.util.*;
public interface FuelRepository {
	public boolean isAddFuelType(FuelTypeModel model);
	public List<FuelTypeModel> getAllFuelTpes();
	public boolean isDeleteFuelTypeById(int id);
	public boolean isUpdateFuelType(FuelTypeModel model);
}
