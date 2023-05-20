package kmitl.sci.cs.entp.service;

import java.util.List;

import kmitl.sci.cs.entp.model.PatchVehicleRequest;
import kmitl.sci.cs.entp.model.Vehicle;



public interface VehicleService {
	public List<Vehicle> getVehicles();
	public Vehicle getVehicle(String vehicleId);
	public void Create(Vehicle vehicle);
	public void delete(String vehicleId);
	public void update(String vehicleId, PatchVehicleRequest request);
	public void rent(String vehicleId, String userId);
	public void remove(String vehicleId);
}
