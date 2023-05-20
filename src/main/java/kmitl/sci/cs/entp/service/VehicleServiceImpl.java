package kmitl.sci.cs.entp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.model.PatchVehicleRequest;
import kmitl.sci.cs.entp.model.Vehicle;
import kmitl.sci.cs.entp.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	@Override
	public List<Vehicle> getVehicles() {
		
		return repository.findAll();
	}

	@Override
	public Vehicle getVehicle(String vehicleId) {
		// TODO Auto-generated method stub
		return repository.findByVehicleId(Long.valueOf(vehicleId));
	}

	@Override
	public void Create(Vehicle vehicle) {
		
		if(vehicle.getStatus() == null) {
			vehicle.setStatus("Available");
		}
		repository.save(vehicle);
		System.out.println("Vehicle Has been saved");
	}

	@Override
	public void delete(String vehicleId) {
		// TODO Auto-generated method stub
		repository.deleteByVehicleId(Long.valueOf(vehicleId));
	}

	@Override
	public void update(String vehicleId, PatchVehicleRequest request) {
		// TODO Auto-generated method stub
		Vehicle vehicle = getVehicle(vehicleId);
		if(request.getOwner() != null) {
			vehicle.setOwner(request.getOwner());
		}
		if(request.getStatus() != null) {
			vehicle.setStatus(request.getStatus());
		}
		repository.save(vehicle);
	}

	@Override
	public void rent(String vehicleId, String userId) {
		// find vehicle
		Vehicle vehicle = getVehicle(vehicleId);
		if(vehicle != null && vehicle.getStatus().equals("Available")) {
			System.out.println("Vehicle Has been rent");
			// save user
			vehicle.setOwner(userId);
			vehicle.setStatus("Rented");
			// update time
			vehicle.setAssociationDate(new Date());
			repository.save(vehicle);
		}
	}
	
	public void remove(String vehicleId) {
		//find vehicle
		Vehicle vehicle = getVehicle(vehicleId);
		if(vehicle != null) {
			//update to empty one
			vehicle.setAssociationDate(null);
			vehicle.setOwner(null);
			vehicle.setStatus("Available");
			repository.save(vehicle);
		}
		
		//save
	}



}
