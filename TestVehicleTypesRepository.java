package com.cognizant.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;


import com.cognizant.main.entities.VehicleTypes;
import com.cognizant.main.repository.VehicleTypesRepository;

@DataJpaTest
@ContextConfiguration(classes=RidesharingplatformApplication.class)
public class TestVehicleTypesRepository {
	@Autowired
	private VehicleTypesRepository vehicleTypesRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testFindAllPositive() {
		VehicleTypes n=new  VehicleTypes();		
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67);		
		entityManager.persist(n);
		Iterable<VehicleTypes> it=vehicleTypesRepository.findAll();
		assertTrue(it.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<VehicleTypes> it=vehicleTypesRepository.findAll();
		assertTrue(it.iterator().hasNext());
}
	@Test
	public void testFindByIdPositive() {
		VehicleTypes n=new  VehicleTypes();		
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67);
		entityManager.persist(n);
		Optional<VehicleTypes> vehicleTypes=vehicleTypesRepository.findById(76);
		assertTrue(vehicleTypes.isPresent());
	}
	@Test
	public void testFindByIdNegative() {
		Optional<VehicleTypes> vehicleTypes=vehicleTypesRepository.findById(76);
		assertTrue(!vehicleTypes.isPresent());
}
	@Test
	public void testSavePositive() {
		VehicleTypes n=new  VehicleTypes();		
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67);
		vehicleTypesRepository.save(n);
		Optional<VehicleTypes> vehicleTypes=vehicleTypesRepository.findById(76);
		assertTrue(vehicleTypes.isPresent());
	}
	@Test
	public void testDeletePositive() {
		VehicleTypes n=new  VehicleTypes();		
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67);
		vehicleTypesRepository.delete(n);
		Optional<VehicleTypes> vehicleTypes=vehicleTypesRepository.findById(76);
		assertTrue(!vehicleTypes.isPresent());
	}
}
