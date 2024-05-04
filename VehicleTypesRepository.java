package com.cognizant.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.main.entities.VehicleTypes;

@Repository
	public interface VehicleTypesRepository extends JpaRepository<VehicleTypes,Integer>{

}
