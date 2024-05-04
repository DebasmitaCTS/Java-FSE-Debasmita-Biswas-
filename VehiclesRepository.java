package com.cognizant.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.main.entities.Vehicles;
import com.cognizant.utilities.InspectionStatusEnum;


@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles,String>{

	Optional<Vehicles> findByBelongsToUserId(int belongsToUserId);
	
	Optional<Vehicles> deleteByRegistrationNoAndBelongsToUserId(String registrationNo,int belongsToUserId);
	
	Optional<Vehicles> findByRegistrationNoAndBelongsToUserId(String registrationNo,int belongsToUserId);
	
    List<Vehicles> findAllByInspectionStatus(InspectionStatusEnum pending);
    
    boolean existsByRegistrationNo(String registrationNo);
    boolean existsByBelongsToUserId(int belongsToUserId);
	
	//Page<Vehicles>findByInspectionStatus(InspectionStatusEnum pending, Pageable pageable);
}
