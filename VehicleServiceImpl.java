package com.cognizant.main.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cognizant.dto.RegisterVehicleDTO;
import com.cognizant.dto.VehicleTypesDTO;
import com.cognizant.dto.VehiclesDTO;
import com.cognizant.main.entities.VehicleDetails;
import com.cognizant.main.entities.VehicleTypes;
import com.cognizant.main.entities.Vehicles;
import com.cognizant.main.repository.VehicleDetailsRepository;
import com.cognizant.main.repository.VehicleTypesRepository;
import com.cognizant.main.repository.VehiclesRepository;
import com.cognizant.utilities.InspectionStatusEnum;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements Vehicle {
	
@Autowired
private VehicleTypesRepository vehicleTypesRepository;

@Autowired
private VehiclesRepository vehiclesRepository;

@Autowired
private VehicleDetailsRepository vehicleDetailsRepository;


	@Override
	public List<VehicleTypesDTO> getVehicleTypes() {
		
		Iterable<VehicleTypes> it = vehicleTypesRepository.findAll();
		List<VehicleTypesDTO> lis = new ArrayList<VehicleTypesDTO>();
		for(VehicleTypes v : it) {
			VehicleTypesDTO dto = new VehicleTypesDTO();
			dto.setId(v.getId());
			dto.setType(v.getType());
			dto.setMaxPassengersAllowed(v.getMaxPassengersAllowed());
			dto.setFarePerKM(v.getFarePerKM());
			
			lis.add(dto);
		}
		return lis;
		
	}
	
	public class InvalidRegistrationNoException extends Exception{
		public InvalidRegistrationNoException(String message) {
			super(message);
		}
	}

	@Override
	public String persistVehicles(RegisterVehicleDTO registerVehicleDTO) throws InvalidRegistrationNoException {
				
		Vehicles vehicles=new Vehicles();
		VehicleDetails vehicledetails=new VehicleDetails();
		
		vehicles.setRegistrationNo(registerVehicleDTO.getRegistrationNo());
	
	String registrationNo=registerVehicleDTO.getRegistrationNo();
	if(registrationNo.matches("[A-Za-z]{2}\\d{2}[A-Za-z]{2}\\d{4}")) {
		boolean existsNo=vehiclesRepository.existsByRegistrationNo(registerVehicleDTO.getRegistrationNo());
		   if(!existsNo) {
			  
		vehicles.setRegistrationNo(registrationNo);
	       }
		   else {
			   return "Registration Number already Exists";
		   }
	}
	else {
		throw new InvalidRegistrationNoException("Inavalid registration number!");
	}
	   boolean exists=vehiclesRepository.existsByBelongsToUserId(registerVehicleDTO.getBelongsToUserId());
	   if(!exists) {
		   vehicles.setBelongsToUserId(registerVehicleDTO.getBelongsToUserId());
	   }else {
		   return "User Id already Exists";
	   }
	   vehicles.setBelongsToUserId(registerVehicleDTO.getBelongsToUserId());
		
		Optional<VehicleTypes> vehicle = vehicleTypesRepository.findById(registerVehicleDTO.getVehicleTypeId());
		vehicles.setVehicleTypeId(vehicle.get());
		
		vehicles.setInspectionStatus(InspectionStatusEnum.PENDING);
		vehicles.setInspectedByUserId(registerVehicleDTO.getInspectedByUserId());
		vehicles.setInspectedOn(registerVehicleDTO.getInspectedOn());		
		vehicledetails.setRegistrationNo(registerVehicleDTO.getRegistrationNo());
		vehicledetails.setRTOName(registerVehicleDTO.getRtoname());
		
//		LocalDate currentDate = LocalDate.now();
//        Period period = Period.between(registerVehicleDTO.getRegistrationDate(), currentDate);
        
		
		
		vehicledetails.setRegistrationDate(registerVehicleDTO.getRegistrationDate());		
		LocalDate RegistrationExpiresOn=registerVehicleDTO.getRegistrationDate().plusYears(15);		
		vehicledetails.setInsuranceCompanyName(registerVehicleDTO.getInsuranceCompanyName());
		vehicledetails.setInsuraceNo(registerVehicleDTO.getInsuraceNo());
		vehicledetails.setInsurancedOn(registerVehicleDTO.getInsurancedOn());		
		LocalDate InsuranceExpiresOn=registerVehicleDTO.getInsurancedOn().plusYears(1);
		vehicledetails.setPUCCertificateNo(registerVehicleDTO.getPuccertificateno());
		vehicledetails.setPUCIssuedOn(registerVehicleDTO.getPucissuedon());
		LocalDate pUCValidUntil=registerVehicleDTO.getPucissuedon().plusMonths(6);
		
//		if (period.getYears() > 15) {
//            //throw new IllegalArgumentException("Vehicle is more than 15 years old")
//        	return "Vehicle is more than 15 years old.";
//        }
		if(LocalDate.now().isAfter(RegistrationExpiresOn)) {
			
			return "Vehicle is more than 15 years.";
		}

		else if(LocalDate.now().isAfter(pUCValidUntil)) {
			
			return "Vehicle PUC is expired";
		}
		else if(LocalDate.now().isAfter(InsuranceExpiresOn)){
			
			return "Vehicle insurance is expired";
		}else {
			
			vehicledetails.setRegistrationExpiresOn(RegistrationExpiresOn);
			vehicledetails.setInsuranceExpiresOn(InsuranceExpiresOn);
			vehicledetails.setPUCValidUntil(pUCValidUntil);
		}
		
	if(registerVehicleDTO.getRcdocurl().length()>1024) {
		return "RC document size exceeds the limit of 1024 KB";
	}else if (registerVehicleDTO.getInsuranceCertificateDOCURL().length()>1024)
	{
		return "Insurance document size exceeds the limit of 1024 KB";
	}
	else if(registerVehicleDTO.getPucdocurl().length()>=1024) {
		return "PUC document size exceeds the limit of 1024 KB";
		
	}
	else {
		vehicledetails.setRCDocURL(registerVehicleDTO.getPucdocurl());
		vehicledetails.setPUCDOCURL(registerVehicleDTO.getPucdocurl());
		vehicledetails.setInsuranceCertificateDOCURL(registerVehicleDTO.getInsuranceCertificateDOCURL());
	}
	
		vehicleDetailsRepository.save(vehicledetails);
		
		Vehicles addvehicles=vehiclesRepository.save(vehicles);
		
		if(addvehicles!=null) {
			return "success";
		}
		else {
			return "fail";
		}

	}
	

	
	@Override
	public String deleteVehicles(String registrationNo,int belongsToUserId) {
		

		Optional<Vehicles> optionalOfvehicles = vehiclesRepository.findByRegistrationNoAndBelongsToUserId(registrationNo,belongsToUserId);

		if(optionalOfvehicles.isPresent())
		{
			
			vehiclesRepository.deleteByRegistrationNoAndBelongsToUserId(registrationNo,belongsToUserId);
			
			return "success";
		}
		return "Enter Valid Data";
	}
	
//	@Override
//	public List<VehiclesDTO> getpending(){
//
//		Iterable<Vehicles> vechileList = vehiclesRepository.findAll();
//		
//		List<VehiclesDTO> vehiclesdtolist=new ArrayList<VehiclesDTO>();
//		
//		for(Vehicles vehicles:vechileList) {
//			
//		if(vehicles.getInspectionStatus().toString().equals("PENDING")) {
//			VehiclesDTO vehiclesdto=new VehiclesDTO();
//			vehiclesdto.setRegistrationNo(vehicles.getRegistrationNo());	
//			vehiclesdto.setVehicleTypeId(vehicles.getVehicleTypeId().getId());
//			vehiclesdto.setBelongsToUserId(vehicles.getBelongsToUserId());
//			vehiclesdto.setInspectionStatus(vehicles.getInspectionStatus());
//			vehiclesdto.setInspectedByUserId(vehicles.getInspectedByUserId());
//			vehiclesdto.setInspectedOn(vehicles.getInspectedOn());
//			
//            vehiclesdtolist.add(vehiclesdto);    
//		}
//		}
//		return vehiclesdtolist;	
//	}
	

	@Override
	public VehiclesDTO getpending(int pageNumber){
		List<Vehicles> allpendingList = vehiclesRepository.findAllByInspectionStatus(InspectionStatusEnum.PENDING);
		int totalItems=allpendingList.size();
		int totalPages=totalItems;		
//		if(pageNumber < 0|| pageNumber >= totalPages) {
//			throw new IllegalArgumentException("Invalid page number");
//			
//		}
		if (pageNumber>allpendingList.size()) {
	        throw new IllegalArgumentException("Invalid page number");

//			return (VehiclesDTO)new PageImpl<>(List.of(),PageRequest.of(pageNumber,1),totalItems).get().findFirst().get();
		}
		pageNumber--;
		Vehicles pendingRequest=allpendingList.get(pageNumber);
		VehiclesDTO vehiclesdto=mapToDto(pendingRequest);
		return (VehiclesDTO)new PageImpl<>(List.of(vehiclesdto),PageRequest.of(pageNumber, 1),totalItems).get().findFirst().get();
		
	}
	private VehiclesDTO mapToDto(Vehicles vehicles) {
		
		VehiclesDTO vehiclesdto=new VehiclesDTO();
		vehiclesdto.setRegistrationNo(vehicles.getRegistrationNo());	
		vehiclesdto.setVehicleTypeId(vehicles.getVehicleTypeId().getId());
		vehiclesdto.setBelongsToUserId(vehicles.getBelongsToUserId());
		vehiclesdto.setInspectionStatus(vehicles.getInspectionStatus());
		vehiclesdto.setInspectedByUserId(vehicles.getInspectedByUserId());
		vehiclesdto.setInspectedOn(vehicles.getInspectedOn());

		return vehiclesdto;
	}
	
	@Override
    public String updateapprovereject(RegisterVehicleDTO registerVehicleDTO) {
		String registrationNo=registerVehicleDTO.getRegistrationNo();
		
    	Optional<Vehicles> optionalofvehicles=vehiclesRepository.findById(registrationNo);
    	if(optionalofvehicles.isPresent()) {
    		Vehicles v = optionalofvehicles.get();
    		v.setInspectionStatus(registerVehicleDTO.getInspectionStatus());
    		v.setInspectedByUserId(registerVehicleDTO.getInspectedByUserId());
    		v.setInspectedOn(registerVehicleDTO.getInspectedOn());	
    		vehiclesRepository.save(v);
    		return "updated"; 
    		
    	}
    	else {
    		return "Enter Valid Details";
    	}
    }
	
    @Override
	public VehiclesDTO getVehicleById(int belongsToUserId)
	{
		
		Optional<Vehicles> optionalOfVehicles=vehiclesRepository.findByBelongsToUserId(belongsToUserId);
		VehiclesDTO vehicleDto=new VehiclesDTO();
		if(optionalOfVehicles.isPresent()) {
			
			Vehicles vehicle = optionalOfVehicles.get();
			vehicleDto.setRegistrationNo(vehicle.getRegistrationNo());
			vehicleDto.setBelongsToUserId(vehicle.getBelongsToUserId());
			vehicleDto.setVehicleTypeId(vehicle.getVehicleTypeId().getId());
			vehicleDto.setInspectionStatus(vehicle.getInspectionStatus());
			vehicleDto.setInspectedByUserId(vehicle.getInspectedByUserId());
			vehicleDto.setInspectedOn(vehicle.getInspectedOn());
			return vehicleDto;
		}
		
		return vehicleDto;
		
	}


	@Override
	public List<VehiclesDTO> getpending() {
		// TODO Auto-generated method stub
		return null;
	}



}