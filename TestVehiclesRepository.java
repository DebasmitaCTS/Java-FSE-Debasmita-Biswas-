package com.cognizant.main;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import com.cognizant.main.entities.Vehicles;
import com.cognizant.main.entities.VehicleDetails;
import com.cognizant.main.entities.VehicleTypes;
import com.cognizant.main.repository.VehicleTypesRepository;
import com.cognizant.main.repository.VehiclesRepository;
import com.cognizant.utilities.InspectionStatusEnum;
@DataJpaTest
@ContextConfiguration(classes=RidesharingplatformApplication.class)
public class TestVehiclesRepository {
	@Autowired
	private VehiclesRepository vehiclesRepository;
	@Autowired
	private VehicleTypesRepository vehicleTypesRepository;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testFindAllPositive() {
		VehicleDetails vehicleDetails=new VehicleDetails();
		vehicleDetails.setRegistrationNo("abcd");
		vehicleDetails.setRTOName("rto");
		vehicleDetails.setRegistrationDate(LocalDate.now());
		vehicleDetails.setRegistrationExpiresOn(LocalDate.now());
		vehicleDetails.setRCDocURL("rcdoc");
		vehicleDetails.setInsuranceCompanyName("name");
		vehicleDetails.setInsuraceNo(78);
		vehicleDetails.setInsurancedOn(LocalDate.now());
		vehicleDetails.setInsuranceExpiresOn(LocalDate.now());
		vehicleDetails.setInsuranceCertificateDOCURL("certificate");
		vehicleDetails.setPUCCertificateNo(98);
		vehicleDetails.setPUCIssuedOn(LocalDate.now());
		vehicleDetails.setPUCValidUntil(LocalDate.now());
		vehicleDetails.setPUCDOCURL("url");
		
		entityManager.persist(vehicleDetails);
		VehicleDetails vehicleDetailsFind=entityManager.find(VehicleDetails.class, "abcd");
		
		VehicleTypes vehicleTypes=new  VehicleTypes();
		vehicleTypes.setId(78);
		entityManager.persist(vehicleTypes);
		VehicleTypes vehicleTypesFind=entityManager.find(VehicleTypes.class, 78);

		Vehicles  vehicle=new Vehicles(); 
		vehicle.setVehicleDetails(vehicleDetailsFind);
		vehicle.setRegistrationNo("abcd");
		vehicle.setVehicleTypeId(vehicleTypesFind);
		vehicle.setBelongsToUserId(3457);
		vehicle.setInspectionStatus(InspectionStatusEnum.PENDING);
		vehicle.setInspectedByUserId(768);
		vehicle.setInspectedOn(LocalDate.now());
		vehiclesRepository.save(vehicle);
		Iterable<Vehicles> it=vehiclesRepository.findAll();
		assertTrue(it.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<Vehicles> it=vehiclesRepository.findAll();
		assertTrue(!it.iterator().hasNext());
	}
	@Test
	public void testFindByIdPositive() {
		VehicleDetails vehicleDetails=new VehicleDetails();
		vehicleDetails.setRegistrationNo("abcd");
		vehicleDetails.setRTOName("rto");
		vehicleDetails.setRegistrationDate(LocalDate.now());
		vehicleDetails.setRegistrationExpiresOn(LocalDate.now());
		vehicleDetails.setRCDocURL("rcdoc");
		vehicleDetails.setInsuranceCompanyName("name");
		vehicleDetails.setInsuraceNo(78);
		vehicleDetails.setInsurancedOn(LocalDate.now());
		vehicleDetails.setInsuranceExpiresOn(LocalDate.now());
		vehicleDetails.setInsuranceCertificateDOCURL("certificate");
		vehicleDetails.setPUCCertificateNo(98);
		vehicleDetails.setPUCIssuedOn(LocalDate.now());
		vehicleDetails.setPUCValidUntil(LocalDate.now());
		vehicleDetails.setPUCDOCURL("url");
		
		entityManager.persist(vehicleDetails);
		VehicleDetails vehicleDetailsFind=entityManager.find(VehicleDetails.class, "abcd");
		
		VehicleTypes vehicleTypes=new  VehicleTypes();
		vehicleTypes.setId(78);
		entityManager.persist(vehicleTypes);
		VehicleTypes vehicleTypesFind=entityManager.find(VehicleTypes.class, 78);

		
		Vehicles  vehicle=new Vehicles(); 
		vehicle.setVehicleDetails(vehicleDetailsFind);
		vehicle.setRegistrationNo("abcd");
		vehicle.setVehicleTypeId(vehicleTypesFind);		
		vehicle.setBelongsToUserId(3457);
		vehicle.setInspectionStatus(InspectionStatusEnum.PENDING);
		vehicle.setInspectedByUserId(768);
		vehicle.setInspectedOn(LocalDate.now());
		vehiclesRepository.save(vehicle);
		Optional<Vehicles> vechicles=vehiclesRepository.findById("abcd");
		assertTrue(vechicles.isPresent());
		
	}
	@Test
	public void testFindByIdNegative() {
		Optional<Vehicles> vechicles=vehiclesRepository.findById("abcd");
		assertTrue(!vechicles.isPresent());
	}
	@Test
	public void testSavePositive() {
		VehicleDetails vehicleDetails=new VehicleDetails();
		vehicleDetails.setRegistrationNo("abcd");
		vehicleDetails.setRTOName("rto");
		vehicleDetails.setRegistrationDate(LocalDate.now());
		vehicleDetails.setRegistrationExpiresOn(LocalDate.now());
		vehicleDetails.setRCDocURL("rcdoc");
		vehicleDetails.setInsuranceCompanyName("name");
		vehicleDetails.setInsuraceNo(78);
		vehicleDetails.setInsurancedOn(LocalDate.now());
		vehicleDetails.setInsuranceExpiresOn(LocalDate.now());
		vehicleDetails.setInsuranceCertificateDOCURL("certificate");
		vehicleDetails.setPUCCertificateNo(98);
		vehicleDetails.setPUCIssuedOn(LocalDate.now());
		vehicleDetails.setPUCValidUntil(LocalDate.now());
		vehicleDetails.setPUCDOCURL("url");
		entityManager.persist(vehicleDetails);
		VehicleDetails vehicleDetailsFind=entityManager.find(VehicleDetails.class, "abcd");
		VehicleTypes n=new  VehicleTypes();
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67);
		 
		vehicleTypesRepository.save(n);
				
		Vehicles e=new Vehicles();
		e.setVehicleDetails(vehicleDetailsFind);
		e.setRegistrationNo("abcd");
		e.setBelongsToUserId(3457);
		e.setVehicleTypeId(n);
		e.setInspectionStatus(InspectionStatusEnum.PENDING);
		e.setInspectedByUserId(768);
		e.setInspectedOn(LocalDate.now());
		vehiclesRepository.save(e);
		Optional<Vehicles> vechicles=vehiclesRepository.findById("abcd");
		assertTrue(vechicles.isPresent());
	}
	@Test
	public void testDeletePositive() {
		VehicleDetails vehicleDetails=new VehicleDetails();
		vehicleDetails.setRegistrationNo("abcd");
		vehicleDetails.setRTOName("rto");
		vehicleDetails.setRegistrationDate(LocalDate.now());
		vehicleDetails.setRegistrationExpiresOn(LocalDate.now());
		vehicleDetails.setRCDocURL("rcdoc");
		vehicleDetails.setInsuranceCompanyName("name");
		vehicleDetails.setInsuraceNo(78);
		vehicleDetails.setInsurancedOn(LocalDate.now());
		vehicleDetails.setInsuranceExpiresOn(LocalDate.now());
		vehicleDetails.setInsuranceCertificateDOCURL("certificate");
		vehicleDetails.setPUCCertificateNo(98);
		vehicleDetails.setPUCIssuedOn(LocalDate.now());
		vehicleDetails.setPUCValidUntil(LocalDate.now());
		vehicleDetails.setPUCDOCURL("url");
		entityManager.persist(vehicleDetails);
		VehicleDetails vehicleDetailsFind=entityManager.find(VehicleDetails.class, "abcd");
		VehicleTypes n=new  VehicleTypes();
		n.setId(76);
		n.setType(3457);
		n.setMaxPassengersAllowed(87);
		n.setFarePerKM(67); 
		vehicleTypesRepository.save(n);
		
		Vehicles e=new Vehicles();
		e.setVehicleDetails(vehicleDetailsFind);
		e.setRegistrationNo("abcd");
		e.setBelongsToUserId(3457);
		e.setVehicleTypeId(n);
		e.setInspectionStatus(InspectionStatusEnum.PENDING);
		e.setInspectedByUserId(768);
		e.setInspectedOn(LocalDate.now());
		vehiclesRepository.delete(e);
		Optional<Vehicles> vechicles=vehiclesRepository.findById("abcd");
		assertTrue(!vechicles.isPresent());
	}
}
