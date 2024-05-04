package com.cognizant.main;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import com.cognizant.main.entities.VehicleDetails;
import com.cognizant.main.repository.VehicleDetailsRepository;

@DataJpaTest
@ContextConfiguration(classes=RidesharingplatformApplication.class)
public class TestVehicleDetailsRepository {
	 
	@Autowired
	private VehicleDetailsRepository  vehicleDetailsRepository ;
	
	@Test
	public void testFindAllPositive() {
			
		VehicleDetails vehicledetails=new  VehicleDetails();
		
		vehicledetails.setRegistrationNo("number");
		vehicledetails.setRTOName("rto");
		vehicledetails.setRegistrationDate(LocalDate.now());
		vehicledetails.setRegistrationExpiresOn(LocalDate.now());
		vehicledetails.setRCDocURL("rcdoc");
		vehicledetails.setInsuranceCompanyName("name");
		vehicledetails.setInsuraceNo(78);
		vehicledetails.setInsurancedOn(LocalDate.now());
		vehicledetails.setInsuranceExpiresOn(LocalDate.now());
		vehicledetails.setInsuranceCertificateDOCURL("certificate");
		vehicledetails.setPUCCertificateNo(98);
		vehicledetails.setPUCIssuedOn(LocalDate.now());
		vehicledetails.setPUCValidUntil(LocalDate.now());
		vehicledetails.setPUCDOCURL("url");
		vehicleDetailsRepository.save(vehicledetails);
		Iterable<VehicleDetails> it=vehicleDetailsRepository.findAll();
		assertTrue(it.iterator().hasNext());
	}
	@Test
	public void testFindAllNegative() {
		Iterable<VehicleDetails> it=vehicleDetailsRepository.findAll();
		assertTrue(!it.iterator().hasNext());
	}
	@Test
	public void testFindByIdPositive() {
		
		VehicleDetails vehicledetails=new  VehicleDetails();
		
		vehicledetails.setRegistrationNo("number");
	    vehicledetails.setRTOName("rto");
		vehicledetails.setRegistrationDate(LocalDate.now());
		vehicledetails.setRegistrationExpiresOn(LocalDate.now());
		vehicledetails.setRCDocURL("rcdoc");
		vehicledetails.setInsuranceCompanyName("name");
		vehicledetails.setInsuraceNo(78);
		vehicledetails.setInsurancedOn(LocalDate.now());
		vehicledetails.setInsuranceExpiresOn(LocalDate.now());
		vehicledetails.setInsuranceCertificateDOCURL("certificate");
		vehicledetails.setPUCCertificateNo(98);
		vehicledetails.setPUCIssuedOn(LocalDate.now());
		vehicledetails.setPUCValidUntil(LocalDate.now());
		vehicledetails.setPUCDOCURL("url");
		vehicleDetailsRepository.save(vehicledetails);
		Optional<VehicleDetails> vehicleDetails=vehicleDetailsRepository.findById("number");
		assertTrue(vehicleDetails.isPresent());
	}
	@Test
	public void testFindByIdNegative() {
		Optional<VehicleDetails> vehicleDetails=vehicleDetailsRepository.findById("number");
		assertFalse(vehicleDetails.isPresent());
	}
	@Test
	public void testSavePositive() {
		
        VehicleDetails vehicledetails=new  VehicleDetails();
        
        vehicledetails.setRegistrationNo("number");
        vehicledetails.setRTOName("rto");
        vehicledetails.setRegistrationDate(LocalDate.now());
        vehicledetails.setRegistrationExpiresOn(LocalDate.now());
        vehicledetails.setRCDocURL("rcdoc");
        vehicledetails.setInsuranceCompanyName("name");
        vehicledetails.setInsuraceNo(78);
        vehicledetails.setInsurancedOn(LocalDate.now());
        vehicledetails.setInsuranceExpiresOn(LocalDate.now());
        vehicledetails.setInsuranceCertificateDOCURL("certificate");
        vehicledetails.setPUCCertificateNo(98);
        vehicledetails.setPUCIssuedOn(LocalDate.now());
        vehicledetails.setPUCValidUntil(LocalDate.now());
        vehicledetails.setPUCDOCURL("url");
		vehicleDetailsRepository.save(vehicledetails);
		Optional<VehicleDetails> vehicleDetails=vehicleDetailsRepository.findById("number");
		assertTrue(vehicleDetails.isPresent());
	}
	@Test
	public void testDeletePositive() {
   
		VehicleDetails vehicledetails=new  VehicleDetails();
		
		vehicledetails.setRegistrationNo("number");
		vehicledetails.setRTOName("rto");
		vehicledetails.setRegistrationDate(LocalDate.now());
		vehicledetails.setRegistrationExpiresOn(LocalDate.now());
		vehicledetails.setRCDocURL("rcdoc");
		vehicledetails.setInsuranceCompanyName("name");
		vehicledetails.setInsuraceNo(78);
		vehicledetails.setInsurancedOn(LocalDate.now());
		vehicledetails.setInsuranceExpiresOn(LocalDate.now());
		vehicledetails.setInsuranceCertificateDOCURL("certificate");
		vehicledetails.setPUCCertificateNo(98);
		vehicledetails.setPUCIssuedOn(LocalDate.now());
		vehicledetails.setPUCValidUntil(LocalDate.now());
		vehicledetails.setPUCDOCURL("url");
		vehicleDetailsRepository.delete(vehicledetails);
		Optional<VehicleDetails>vehicleDetails=vehicleDetailsRepository.findById("number");
		assertFalse(vehicleDetails.isPresent());
	}
}
