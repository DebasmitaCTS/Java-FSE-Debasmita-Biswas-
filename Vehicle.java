package com.cognizant.main.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cognizant.dto.RegisterVehicleDTO;
import com.cognizant.dto.VehicleDetailsDTO;
import com.cognizant.dto.VehicleTypesDTO;
import com.cognizant.dto.VehiclesDTO;
import com.cognizant.main.service.VehicleServiceImpl.InvalidRegistrationNoException;

public interface Vehicle {
public abstract List<VehicleTypesDTO> getVehicleTypes();
public abstract VehiclesDTO getVehicleById(int belongsToUserId);
//VehiclesDTO getVehicleById(int belongsToUserId);
//String deleteVehicles(String registrationNo, int belongsToUserId);
//List<VehiclesDTO> getpending();
//String persistVehicles(RegisterVehicleDTO registerVehicleDTO) throws InvalidRegistrationNoException;
//String updateapprovereject(RegisterVehicleDTO registerVehicleDTO);

public abstract String deleteVehicles(String registrationNo, int belongsToUserId);
public abstract List<VehiclesDTO> getpending();
public abstract String persistVehicles(RegisterVehicleDTO registerVehicleDTO) throws InvalidRegistrationNoException;
public abstract String updateapprovereject(RegisterVehicleDTO registerVehicleDTO);
VehiclesDTO getpending(int pageNumber);



}
