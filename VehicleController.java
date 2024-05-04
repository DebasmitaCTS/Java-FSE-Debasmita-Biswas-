
package com.cognizant.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dto.RegisterVehicleDTO;
import com.cognizant.dto.VehicleTypesDTO;
import com.cognizant.dto.VehiclesDTO;
import com.cognizant.dto.status;
import com.cognizant.main.service.Vehicle;
import com.cognizant.main.service.VehicleServiceImpl;
import com.cognizant.main.service.VehicleServiceImpl.InvalidRegistrationNoException;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController @RequestMapping("api")
@Tag(name = "Vehicles")
@CrossOrigin(origins="http://localhost:4200")
public class VehicleController {
	
	public Vehicle vehiclePost;
	
	@Autowired
	private  VehicleServiceImpl vehicleimpl;

	@PostMapping("/vehicles/addvehicle")
	public ResponseEntity<String> postAddMethod(@Valid @RequestBody RegisterVehicleDTO registerVehicleDTO) throws InvalidRegistrationNoException
	{String result=null;
	

//		try {
		
		 result = vehicleimpl.persistVehicles(registerVehicleDTO);
		
		if(result.equals("success")) {
			
			status stas = new status();
			stas.setStatus(result);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
			}
		}
//		catch(InvalidRegistrationNoException e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
//	}
	
	
	@GetMapping("/vehicles/vehicletypes")
	public ResponseEntity<?> GetAllVehicletypes(){
		List<VehicleTypesDTO> responseList=vehicleimpl.getVehicleTypes();

		ResponseEntity<List<VehicleTypesDTO>> responseEntity=null;
		
		if(!responseList.isEmpty()) {
			responseEntity = new ResponseEntity<List<VehicleTypesDTO>>(responseList, HttpStatus.OK);
			
		}else {
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		return responseEntity;
		}
	
	
	@DeleteMapping("/vehicles/delete/{registrationNo}/{belongsToUserId}")
	public ResponseEntity<?> DeleteVehicle(@PathVariable("registrationNo")String registrationNo, @PathVariable("belongsToUserId")int belongsToUserId){
		
		String result=vehicleimpl.deleteVehicles(registrationNo,belongsToUserId);
		if(result.equals("success")) {
			
			status stas = new status();
			stas.setStatus(result);
			
			return new ResponseEntity<>(stas,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/vehicle/{belongsToUserId}")
	public ResponseEntity<?> GetVehicleByBelongsToUserId(@PathVariable("belongsToUserId")int belongsToUserId){
		VehiclesDTO response=vehicleimpl.getVehicleById(belongsToUserId);
		
		if(response.getBelongsToUserId()!=0) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}	
		
}
	
	@PutMapping("/vehicles/approveorreject")
	public ResponseEntity<?> updateapprovereject(@RequestBody RegisterVehicleDTO registerVehicleDTO){
		
		String result=vehicleimpl.updateapprovereject(registerVehicleDTO);
		if(result.equals("updated")) {
			
			status stas = new status();
			stas.setStatus(result);
			
			return new ResponseEntity<>(stas,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
			}	
	}
		
//
//	@GetMapping("/vehicles/pendingapprovals")
//    public ResponseEntity<?> getPendingRequests(){
//		List<VehiclesDTO> pendingRequests=vehicleimpl.getpending();
//		ResponseEntity<List<VehiclesDTO>> responseEntity=null;
//		if(!pendingRequests.isEmpty()) {
//			responseEntity=new ResponseEntity<List<VehiclesDTO>>(pendingRequests,HttpStatus.OK);
//		}
//		else
//		{
//			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		return responseEntity;
//	
//	}
	

	@GetMapping("/vehicles/pendingapprovals/{pageno}")
    public ResponseEntity<VehiclesDTO> getPendingRequests(@PathVariable ("pageno") int pageNumber){
		
		VehiclesDTO pendingVehiclesPage=vehicleimpl.getpending(pageNumber);
		if(pendingVehiclesPage!=null) {
		 return new ResponseEntity<>(pendingVehiclesPage,HttpStatus.OK);
	    }
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}
}
