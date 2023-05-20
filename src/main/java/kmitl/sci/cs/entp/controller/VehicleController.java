package kmitl.sci.cs.entp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kmitl.sci.cs.entp.model.PatchVehicleRequest;
import kmitl.sci.cs.entp.model.Vehicle;
import kmitl.sci.cs.entp.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@GetMapping("/vehicle")
	public List<Vehicle> getVehicles(){
		return service.getVehicles();
	}
	
	@GetMapping("/vehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id") String vehicleId) {
		return service.getVehicle(vehicleId);
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Vehicle vehicle) {
		service.Create(vehicle);
	}
	
	@PatchMapping("/update/{id}")
	public void update(@PathVariable("id") String vehicleId, @RequestBody PatchVehicleRequest request) {
		
		
		service.update(vehicleId, request);			
		
	}
	
	@DeleteMapping("/delete/{vehicleId}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("vehicleId") String vehicleId) {
		service.delete(vehicleId);
	}
	
	@PostMapping("/rent/{vehicleId}/users/{userId}")
	public void rent(@PathVariable("vehicleId") String vehicleId, @PathVariable("userId") String userId) {
		service.rent(vehicleId, userId);
	}
	
	@DeleteMapping("/remove/{vehicleId}")
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable("vehicleId") String vehicleId) {
		
		service.remove(vehicleId);
	}
}
