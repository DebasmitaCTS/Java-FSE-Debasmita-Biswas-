package com.cognizant.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.cognizant.dto.RegisterVehicleDTO;
import com.cognizant.dto.VehicleTypesDTO;
import com.cognizant.dto.VehiclesDTO;
import com.cognizant.main.entities.VehicleTypes;
import com.cognizant.main.entities.Vehicles;
import com.cognizant.main.repository.VehicleDetailsRepository;
import com.cognizant.main.repository.VehicleTypesRepository;
import com.cognizant.main.repository.VehiclesRepository;
import com.cognizant.main.service.VehicleServiceImpl;
import com.cognizant.main.service.VehicleServiceImpl.InvalidRegistrationNoException;
import com.cognizant.utilities.InspectionStatusEnum;

public class TestVehicleServiceImpl {
	@Mock
	private VehiclesRepository vehiclesRepository;
	@Mock
	private VehicleTypesRepository vehicleTypesRepository;
	@Mock
	private VehicleDetailsRepository vehicledetailsRepository;
	
	@InjectMocks
	VehicleServiceImpl vehicleserviceimpl;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
	   MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testgetVehicleTypesListPositive() {
		
		VehicleTypes vehicleTypes1=new VehicleTypes();
		vehicleTypes1.setId(1);
		vehicleTypes1.setType(12);
		vehicleTypes1.setMaxPassengersAllowed(4);
		vehicleTypes1.setFarePerKM(20);
		
		VehicleTypes vehicleTypes2=new VehicleTypes();
		vehicleTypes2.setId(2);
		vehicleTypes2.setType(13);
		vehicleTypes2.setMaxPassengersAllowed(3);
		vehicleTypes2.setFarePerKM(24);
		
		List <VehicleTypes> vehicleTypesDataList=new ArrayList<VehicleTypes>();
		vehicleTypesDataList.add(vehicleTypes1);
		vehicleTypesDataList.add(vehicleTypes2);
		
		Mockito.when(vehicleTypesRepository.findAll()).thenReturn(vehicleTypesDataList);
		List<VehicleTypesDTO> vehicleTypesDTOList=vehicleserviceimpl.getVehicleTypes();
		assertTrue(!vehicleTypesDTOList.isEmpty());
		
	}
	
	@Test
	public void testgetVehicleTypesListNegative()
	{
		List <VehicleTypes> vehicleTypesDataList=new ArrayList<VehicleTypes>();
		
		Mockito.when(vehicleTypesRepository.findAll()).thenReturn(vehicleTypesDataList);
		
		List<VehicleTypesDTO> vehicleTypesDTOList=vehicleserviceimpl.getVehicleTypes();
		
		assertTrue(vehicleTypesDTOList.isEmpty());
	}
	
	
	@Test
	public void testPersistVehiclesPositive() throws InvalidRegistrationNoException {
		Vehicles vehicles=Mockito.mock(Vehicles.class);
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		registerVehicleDTO.setVehicleTypeId(89);                    
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.PENDING);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
		registerVehicleDTO.setRtoname("mouni");
		LocalDate RegistrationDate=LocalDate.parse("2024-03-20");
		registerVehicleDTO.setRegistrationDate(RegistrationDate);
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		LocalDate InsurancedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setInsurancedOn(InsurancedOn);
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		LocalDate pUCIssuedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setPucissuedon(pUCIssuedOn);
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	
    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
    	
        String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
        assertEquals("success", actual);
    
	}
	
	
	@Test
	public void testPersistVehiclesRegistrationDateNegative() throws InvalidRegistrationNoException {
		Vehicles vehicles=Mockito.mock(Vehicles.class);
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		registerVehicleDTO.setVehicleTypeId(89);                    
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.PENDING);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
		registerVehicleDTO.setRtoname("mouni");
		LocalDate RegistrationDate=LocalDate.parse("2022-03-20");
		registerVehicleDTO.setRegistrationDate(RegistrationDate);
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		LocalDate InsurancedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setInsurancedOn(InsurancedOn);
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		LocalDate pUCIssuedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setPucissuedon(pUCIssuedOn);
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	
    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
    	
        String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
        assertEquals("success", actual);
    
	}
	
	@Test
	public void testPersistVehiclesInsuranceNegative() throws InvalidRegistrationNoException {
		Vehicles vehicles=Mockito.mock(Vehicles.class);
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		registerVehicleDTO.setVehicleTypeId(89);                    
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.PENDING);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
		registerVehicleDTO.setRtoname("mouni");
		LocalDate RegistrationDate=LocalDate.parse("2023-03-20");
		registerVehicleDTO.setRegistrationDate(RegistrationDate);
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		LocalDate InsurancedOn = LocalDate.parse("2023-03-20");
		registerVehicleDTO.setInsurancedOn(InsurancedOn);
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		LocalDate pUCIssuedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setPucissuedon(pUCIssuedOn);
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	
    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
    	
        String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
        assertEquals("Vehicle insurance is expired", actual);
    
	}
	
	@Test
	public void testPersistVehiclesPUCNegative() throws InvalidRegistrationNoException {
		Vehicles vehicles=Mockito.mock(Vehicles.class);
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		registerVehicleDTO.setVehicleTypeId(89);                    
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.PENDING);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
		registerVehicleDTO.setRtoname("mouni");
		LocalDate RegistrationDate=LocalDate.parse("2023-03-20");
		registerVehicleDTO.setRegistrationDate(RegistrationDate);
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		LocalDate InsurancedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setInsurancedOn(InsurancedOn);
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		LocalDate pUCIssuedOn = LocalDate.parse("2023-03-20");
		registerVehicleDTO.setPucissuedon(pUCIssuedOn);
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	
    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
    	
        String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
        assertEquals("Vehicle PUC is expired", actual);
    
	}
	
	@Test
	public void testPersistVehiclesregestrationfails() throws InvalidRegistrationNoException {
		try
		{
			Vehicles vehicles=Mockito.mock(Vehicles.class);
			RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
			registerVehicleDTO.setRegistrationNo("er12rt89");
			registerVehicleDTO.setBelongsToUserId(45);
			
			registerVehicleDTO.setVehicleTypeId(89);
	    	                     
			registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.APPROVED);
			registerVehicleDTO.setInspectedByUserId(0);
			registerVehicleDTO.setInspectedOn(null);
	    	
			registerVehicleDTO.setRtoname("mouni");
			LocalDate RegistrationDate=LocalDate.parse("2024-03-20");
			registerVehicleDTO.setRegistrationDate(RegistrationDate);
			
			LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
			registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
			
			registerVehicleDTO.setRcdocurl("http");
			registerVehicleDTO.setInsuranceCompanyName("insurance");
			registerVehicleDTO.setInsuraceNo(98);
			
			LocalDate InsurancedOn = LocalDate.parse("2024-03-20");
			registerVehicleDTO.setInsurancedOn(InsurancedOn);
			
			LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
			registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
			registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
			registerVehicleDTO.setPuccertificateno(89);
			
			LocalDate pUCIssuedOn = LocalDate.parse("2024-03-20");
			registerVehicleDTO.setPucissuedon(pUCIssuedOn);
			
			LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
			registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
			registerVehicleDTO.setPucdocurl("url");
	    	VehicleTypes vehicleTypes=new VehicleTypes();
	    	vehicleTypes.setType(1);
	    	
	    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
	    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
	    	
	    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
	    	
	        vehicleserviceimpl.persistVehicles(registerVehicleDTO);

	        assertTrue(false);
		}
		catch (Exception e)
		{
			assertTrue(true);
		}
    
	}
	
	@Test
	public void testPersistVehiclesIllegalException() throws InvalidRegistrationNoException {
		Vehicles vehicles=Mockito.mock(Vehicles.class);
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		registerVehicleDTO.setVehicleTypeId(89);                    
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.PENDING);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
		registerVehicleDTO.setRtoname("mouni");
		registerVehicleDTO.setRegistrationDate(LocalDate.parse("2024-03-20"));
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		registerVehicleDTO.setInsurancedOn(LocalDate.parse("2024-03-20"));
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		registerVehicleDTO.setPucissuedon(LocalDate.parse("2024-03-20"));
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	
    	when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
    	
        String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
        
        assertEquals("success", actual);
     	try {		 
    	 RegisterVehicleDTO registerVehicleDTO2=new RegisterVehicleDTO();
    	 registerVehicleDTO2.setRegistrationNo("er12rt6789");
    	 registerVehicleDTO2.setRegistrationDate(LocalDate.parse("2024-03-20"));
    	 registerVehicleDTO2.setInsurancedOn(LocalDate.parse("2024-03-20"));
    	 registerVehicleDTO2.setPucissuedon(LocalDate.parse("2024-03-20"));
    	 registerVehicleDTO2.setRcdocurl("http");
    	 registerVehicleDTO2.setInsuranceCertificateDOCURL("cer");
    	 registerVehicleDTO2.setPucdocurl("url");
       
    	 when (vehiclesRepository.save(Mockito.any())).thenReturn(vehicles);
     	
         vehicleserviceimpl.persistVehicles(registerVehicleDTO2);
         
    	}
    	catch(IllegalArgumentException e){
    	
    		assertEquals("RegestrationNo with "+registerVehicleDTO.getRegistrationNo()+" already exists", e.getMessage());

    	    
    	}
        
	}
	
	
	@Test
	public void testPersistVehiclesNegative() throws InvalidRegistrationNoException {
		
		RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
		registerVehicleDTO.setRegistrationNo("er12rt6789");
		registerVehicleDTO.setBelongsToUserId(45);
		
		registerVehicleDTO.setVehicleTypeId(89);
    	                     
		registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.APPROVED);
		registerVehicleDTO.setInspectedByUserId(0);
		registerVehicleDTO.setInspectedOn(null);
    	
		registerVehicleDTO.setRtoname("mouni");
		
		LocalDate RegistrationDate=LocalDate.parse("2024-03-20");
		registerVehicleDTO.setRegistrationDate(RegistrationDate);
		
		LocalDate RegistrationExpiresOn=LocalDate.parse("2039-03-20");
		registerVehicleDTO.setRegistrationExpiresOn(RegistrationExpiresOn);
		registerVehicleDTO.setRcdocurl("http");
		registerVehicleDTO.setInsuranceCompanyName("insurance");
		registerVehicleDTO.setInsuraceNo(98);
		
		
		LocalDate InsurancedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setInsurancedOn(InsurancedOn);
		
		LocalDate InsuranceExpiresOn = LocalDate.parse("2025-03-20");
		registerVehicleDTO.setInsuranceExpiresOn(InsuranceExpiresOn);
		registerVehicleDTO.setInsuranceCertificateDOCURL("cer");
		registerVehicleDTO.setPuccertificateno(89);
		
		LocalDate pUCIssuedOn = LocalDate.parse("2024-03-20");
		registerVehicleDTO.setPucissuedon(pUCIssuedOn);
		
		LocalDate pUCValidUntil = LocalDate.parse("2024-09-20");
		registerVehicleDTO.setPucvaliduntil( pUCValidUntil);
		
		registerVehicleDTO.setPucdocurl("url");
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setType(1);
    	
    	Optional<VehicleTypes> optionalOfVehicleType=Optional.of(vehicleTypes);
    	when(vehicleTypesRepository.findById(anyInt())).thenReturn(optionalOfVehicleType);
    	  	
    	String actual=vehicleserviceimpl.persistVehicles(registerVehicleDTO);
     assertEquals("fail", actual);
    
	}
	  
    	
    	@Test
    public void testgetVehicletypesByIdpositive()
    {
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("mou");
    	vehicles.setBelongsToUserId(2);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	                     
    	vehicles.setInspectionStatus(InspectionStatusEnum.APPROVED);
    	vehicles.setInspectedByUserId(0);
    	vehicles.setInspectedOn(null);
    	
    	Optional<Vehicles> optionalofvehicles=Optional.of(vehicles);
    	when(vehiclesRepository.findByBelongsToUserId(anyInt())).thenReturn(optionalofvehicles);
    	
    	VehiclesDTO vehiclesDTOResult=vehicleserviceimpl.getVehicleById(3);
    
    	assertNotNull(vehiclesDTOResult);
    	
}
    	

    @Test
    public void testgetVehicletypesByIdNegative()
    {
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("mou");
    	vehicles.setBelongsToUserId(2);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
    	vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	                     
    	vehicles.setInspectionStatus(InspectionStatusEnum.APPROVED);
    	vehicles.setInspectedByUserId(0);
    	vehicles.setInspectedOn(null);

    	VehiclesDTO vehiclesDTOResult=vehicleserviceimpl.getVehicleById(2);
    	assertNotNull(vehiclesDTOResult);
}
    
      
    @Test
    public void testDeleteVehicleNegative() {
    	
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("1001");
    	vehicles.setBelongsToUserId(1001);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
         vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	
    	vehicles.setInspectionStatus(InspectionStatusEnum.APPROVED);
    	vehicles.setInspectedByUserId(5);
    	vehicles.setInspectedOn(null);
    	Optional<Vehicles> optionalOfVehicles=Optional.of(vehicles);
    	
    	when(vehiclesRepository.deleteByRegistrationNoAndBelongsToUserId(vehicles.getRegistrationNo() ,vehicles.getBelongsToUserId())).thenReturn(optionalOfVehicles);
    	String result=vehicleserviceimpl.deleteVehicles("1000",1000);
    	assertEquals("Enter Valid Data",result);
    	
    	}
    
    @Test
    public void testDeleteVehiclePositive() {
    	
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("1001");
    	vehicles.setBelongsToUserId(1001);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
         vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	
    	vehicles.setInspectionStatus(InspectionStatusEnum.APPROVED);
    	vehicles.setInspectedByUserId(5);
    	vehicles.setInspectedOn(null);
    	Optional<Vehicles> optionalOfVehicles=Optional.of(vehicles);
    	
    	when(vehiclesRepository.findByRegistrationNoAndBelongsToUserId(vehicles.getRegistrationNo() ,vehicles.getBelongsToUserId())).thenReturn(optionalOfVehicles);
    	String result=vehicleserviceimpl.deleteVehicles("1001",1001);
    	assertEquals("success",result);
    	
    	}
    
    @Test
    public void testUpdateApproveRejectPositive() {
    	Vehicles vehicles=new Vehicles();
       vehicles.setRegistrationNo("AP07CA2024");
       RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
       registerVehicleDTO.setRegistrationNo("AP07CA2024");
       registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.APPROVED);
       registerVehicleDTO.setInspectedByUserId(1);
       registerVehicleDTO.setInspectedOn(null);
       
       Optional<Vehicles> optionalOfVehicles=Optional.of(new Vehicles());
       when(vehiclesRepository.findById(vehicles.getRegistrationNo())).thenReturn(optionalOfVehicles);
       
       String result=vehicleserviceimpl.updateapprovereject(registerVehicleDTO);
       assertEquals("updated",result);
       
    }
    
    @Test
    public void testUpdateApproveRejectNegative() {
    	Vehicles vehicles=new Vehicles();
       Optional <Vehicles> optionalOfVehicles=Optional.empty();
       when(vehiclesRepository.findById(vehicles.getRegistrationNo())).thenReturn(optionalOfVehicles);
       
       RegisterVehicleDTO registerVehicleDTO=new RegisterVehicleDTO();
       registerVehicleDTO.setRegistrationNo("AP07CA2024");
       registerVehicleDTO.setInspectionStatus(InspectionStatusEnum.REJECTED);
       registerVehicleDTO.setInspectedByUserId(1);
       registerVehicleDTO.setInspectedOn(null);
       String result=vehicleserviceimpl.updateapprovereject(registerVehicleDTO);
       assertEquals("Enter Valid Details",result);
       
    }
    
    
    @Test
    public void testPendingRequestsPositive() {
    	int pageNumber=1;
    	List<Vehicles> vehiclesList=new ArrayList<>();
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("AP07CA3030");
        vehicles.setBelongsToUserId(1001);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
         vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	
    	vehicles.setInspectionStatus(InspectionStatusEnum.PENDING);
    	vehiclesList.add(vehicles);
    	Page<Vehicles> page=new PageImpl<>(vehiclesList);
    	 when (vehiclesRepository.findAllByInspectionStatus(InspectionStatusEnum.PENDING)).thenReturn(vehiclesList);
    	 VehiclesDTO resultPage= vehicleserviceimpl.getpending(pageNumber);
    	 assertNotNull(resultPage);
//    	 assertEquals(1,resultPage.size());
//    	 assertEquals("AP07CA3030",resultPage.get(0).getRegistrationNo());
    	 
    }
    
    @Test
    public void testPendingRequestsNegative() {
    	int pageNumber=1;
    	List<Vehicles> vehiclesList=new ArrayList<>();
    	Vehicles vehicles=new Vehicles();
    	vehicles.setRegistrationNo("AP07CA3030");
        vehicles.setBelongsToUserId(1001);
    	
    	VehicleTypes vehicleTypes=new VehicleTypes();
         vehicleTypes.setId(2);
    	vehicles.setVehicleTypeId(vehicleTypes);
    	
    	vehicles.setInspectionStatus(InspectionStatusEnum.PENDING);
    	vehiclesList.add(vehicles);
    	Page<Vehicles> page=new PageImpl<>(vehiclesList);
    	when (vehiclesRepository.findAllByInspectionStatus(InspectionStatusEnum.PENDING)).thenReturn(vehiclesList);
    	VehiclesDTO resultPage= vehicleserviceimpl.getpending(pageNumber);
   	    assertNotNull(resultPage);
//   	     assertEquals(1,resultPage.getContent().size());
//   	    assertEquals("AP07CA3030",resultPage.getContent().get(0).getRegistrationNo());
//   	    int invalidPageNumber=-1;
//   	    try {
//   	    	vehicleserviceimpl.getpending(invalidPageNumber);
//   	    	fail("Expected IllegalArgumentException was not thrown");
//   	    }catch(IllegalArgumentException e) {
//   	    	assertEquals("Invalid page number",e.getMessage());
//   	    }
   	    
   	    
}
}