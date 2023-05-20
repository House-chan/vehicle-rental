package kmitl.sci.cs.entp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

import kmitl.sci.cs.entp.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Long>{
	
	Vehicle findByVehicleId(long id);
	void deleteByVehicleId(long id);
	
//	private List<Vehicle> vehicles;
//	
//	public VehicleRepository() {
//		this.vehicles = new ArrayList<>();
//		
//		vehicles.add(new Vehicle(Long.valueOf(0), "Available", "John"));
//		vehicles.add(new Vehicle(Long.valueOf(1), "Available", "Jane"));
//		vehicles.add(new Vehicle(Long.valueOf(2), "Rented", "Dane"));
//	}
//	
//	public List<Vehicle> getVehicle(){
//		return vehicles;
//	}
//	
//	public void save(Vehicle vehicle) {
//		this.vehicles.add(vehicle);
//	}
//	
//	public void update(int vehicleId, Vehicle vehicle) {
//		this.vehicles.set(vehicleId, vehicle);
//	}
//	
//	public void delete(long vehicleId) {
//		for(Vehicle vehicle:vehicles) {
//			//check vehicle exist
//			if(vehicle.getId() == vehicleId) {				
//				//change vehicle to unavailable
//				vehicle.setStatus("Available");
//				//change owner to user
//				vehicle.setOwner(null);
//				//update time rent
//				vehicle.setAssociationDate(null);
//				break;
//			}
//		}
//	}
//	
//	public void rent(long vehicleId, String userId) {
//		for(Vehicle vehicle:vehicles) {
//			//check vehicle exist
//			if(vehicle.getId() == vehicleId) {
//				//check vehicle available
//				if(vehicle.getStatus().equals("Available")) {
//					//change vehicle to unavailable
//					vehicle.setStatus("Rented");
//					//change owner to user
//					vehicle.setOwner(userId);
//					//update time rent
//					vehicle.setAssociationDate(new Date());
//				}
//				break;
//			}
//		}
//	}
}
