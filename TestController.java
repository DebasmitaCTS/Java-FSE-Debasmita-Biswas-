package com.cognizant.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.cognizant.dto.RegisterVehicleDTO;
import com.cognizant.dto.VehicleTypesDTO;
import com.cognizant.dto.VehiclesDTO;
import com.cognizant.dto.status;
import com.cognizant.main.controller.VehicleController;
import com.cognizant.main.repository.VehiclesRepository;
import com.cognizant.main.service.VehicleServiceImpl;
import com.cognizant.main.service.VehicleServiceImpl.InvalidRegistrationNoException;
import com.cognizant.utilities.InspectionStatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestController {
	private MockMvc mockMvc;
	@Mock
	private VehicleServiceImpl vehicleserviceimpl;
	@InjectMocks
	private VehicleController vehicleController;
	@Mock
	private VehiclesRepository vehiclesRepository;
	@Mock
    private RestTemplate restTemplate;
	
	private MockRestServiceServer mockServer;
    private RestTemplate template;
    private ObjectMapper mapper=new ObjectMapper();
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
        template = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(template); 
    }
    
    @Test
	public void getVehicleTypes_positiveReturnValue() {
    	List<VehicleTypesDTO> vehicletypesDTOList = new ArrayList<>();
    	VehicleTypesDTO vehicletypesdto=new VehicleTypesDTO();
    	vehicletypesdto.setId(0);
    	vehicletypesdto.setType(0);
    	vehicletypesdto.setMaxPassengersAllowed(0);
    	vehicletypesdto.setFarePerKM(0);
    	vehicletypesDTOList.add(vehicletypesdto);
    	Mockito.when(vehicleserviceimpl.getVehicleTypes()).thenReturn(vehicletypesDTOList);
        List<VehicleTypesDTO> responseVehicleTypesList  =  (List<VehicleTypesDTO>) vehicleController.GetAllVehicletypes().getBody();
        assertTrue(!responseVehicleTypesList.isEmpty());
        assertEquals(vehicletypesDTOList.size(), responseVehicleTypesList.size());
    }
    
    @Test
    public void getVehicleTypes_NegativeReturnValue()
    {
    	List<VehicleTypesDTO> vehicletypesDTOList = new ArrayList<>();
    	Mockito.when(vehicleserviceimpl.getVehicleTypes()).thenReturn(vehicletypesDTOList);
    	 ResponseEntity<List<VehicleTypesDTO>>  responseVehicleTypesList = (ResponseEntity<List<VehicleTypesDTO>>) vehicleController.GetAllVehicletypes();
    	 assertTrue(vehicletypesDTOList.isEmpty());

    }
    
    @Test
	public void getVehicleTypesURLpositiveReturnValue() {
    	List<VehicleTypesDTO> vehicletypesDTOList = new ArrayList<>();
    	VehicleTypesDTO vehicletypesdto=new VehicleTypesDTO();
    	vehicletypesdto.setId(0);
    	vehicletypesdto.setType(0);
    	vehicletypesdto.setMaxPassengersAllowed(0);
    	vehicletypesdto.setFarePerKM(0);
    	vehicletypesDTOList.add(vehicletypesdto);
    	Mockito.when(vehicleserviceimpl.getVehicleTypes()).thenReturn(vehicletypesDTOList);
    	try {
            MvcResult mockMvcResult = mockMvc.perform(get("http://localhost:8088/api/vehicles/vehicletypes")).andExpect(status().isOk()).andReturn();
        } catch (Exception e) {
            
            assertTrue(false);
        }
    }
    
    @Test
    public void testUriReturnAllSprintsNegative()
    {
        
        
    	Mockito.when(vehicleserviceimpl.getVehicleTypes()).thenReturn(null);
    	try {
            MvcResult mockMvcResult = mockMvc.perform(get("http://localhost:8088/api/vehicles/vehicletypes")).andExpect(status().isOk()).andReturn();
        } catch (Exception e) {
            
            assertTrue(true);
        }
}
    @Test
    public void testGetVehicleByBelongsToUserIdPositive()
    {
    VehiclesDTO vehiclesdto=new VehiclesDTO();
    vehiclesdto.setRegistrationNo("AP07CA3034");
    vehiclesdto.setBelongsToUserId(9);
    vehiclesdto.setVehicleTypeId(4);
    vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
    vehiclesdto.setInspectedByUserId(6);
    vehiclesdto.setInspectedOn(null);
    when(vehicleserviceimpl.getVehicleById(9)).thenReturn(vehiclesdto);
    ResponseEntity<?> responseEntity = vehicleController.GetVehicleByBelongsToUserId(9);
    assertEquals(200,responseEntity.getStatusCodeValue());
    
    }
    
    @Test
    public void testGetVehicleByBelongsToUserIdNegative()
    {
    	VehiclesDTO vehiclesdto=new VehiclesDTO();
    	when(vehicleserviceimpl.getVehicleById(9)).thenReturn(vehiclesdto);
        ResponseEntity<?> responseEntity = vehicleController.GetVehicleByBelongsToUserId(9);
        assertEquals(400,responseEntity.getStatusCodeValue());
    }
    
    @Test
    public void testGetVehicleURLByBelongsToUserIdPositive()
    {
    VehiclesDTO vehiclesdto=new VehiclesDTO();
    vehiclesdto.setRegistrationNo("AP07CA3034");
    vehiclesdto.setBelongsToUserId(9);
    vehiclesdto.setVehicleTypeId(4);
    vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
    vehiclesdto.setInspectedByUserId(6);
    vehiclesdto.setInspectedOn(null);
    when(vehicleserviceimpl.getVehicleById(9)).thenReturn(vehiclesdto);
    try {
        mockMvc.perform(get("http://localhost:8088/api/vehicle/9"))
                .andExpect(status().isOk())
                .andReturn();

    } catch (Exception e) {
        assertTrue(false);
    }
    }
    
    @Test
    public void testGetVehicleURLByBelongsToUserIdNegative()
    {
    VehiclesDTO vehiclesdto=new VehiclesDTO();
    vehiclesdto.setRegistrationNo("AP07CA3034");
    vehiclesdto.setBelongsToUserId(9);
    vehiclesdto.setVehicleTypeId(4);
    vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
    vehiclesdto.setInspectedByUserId(6);
    vehiclesdto.setInspectedOn(null);
    when(vehicleserviceimpl.getVehicleById(9)).thenReturn(vehiclesdto);
    try {
    	mockMvc.perform(get("http://localhost:8088/api/vehicle/8"))
    			.andExpect(status().isNotFound()).andReturn();

    } catch (Exception e) {
        assertTrue(true);
    }
    }
    
    @Test
    public void testDeleteVehiclesPositive() {
    	
    	VehiclesDTO vehiclesdto=new VehiclesDTO();
        vehiclesdto.setRegistrationNo("AP07CA3034");
        vehiclesdto.setBelongsToUserId(9);
        vehiclesdto.setVehicleTypeId(4);
        vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
        vehiclesdto.setInspectedByUserId(6);
        vehiclesdto.setInspectedOn(null);
    	when(vehicleserviceimpl.deleteVehicles("AP07CA3034",9)).thenReturn("success");
    	ResponseEntity<?> responseEntity = vehicleController.DeleteVehicle("AP07CA3034",9);
        assertEquals(200,responseEntity.getStatusCodeValue());
    	
    }
    
    @Test
    public void testDeleteVehiclesNegative() {

    	when(vehicleserviceimpl.deleteVehicles("AP07CA3033",9)).thenReturn("fail");
    	ResponseEntity<?> responseEntity = vehicleController.DeleteVehicle("AP07CA3033",9);
    	assertEquals(400,responseEntity.getStatusCodeValue());
    }
    @Test
    public void testURLDeleteVehiclesPositive() {

    	VehiclesDTO vehiclesdto=new VehiclesDTO();
        vehiclesdto.setRegistrationNo("AP07CA3034");
        vehiclesdto.setBelongsToUserId(9);
        vehiclesdto.setVehicleTypeId(4);
        vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
        vehiclesdto.setInspectedByUserId(6);
        vehiclesdto.setInspectedOn(null);
    	when(vehicleserviceimpl.deleteVehicles("AP07CA3034",9)).thenReturn("success");
    	
    	 try {
    	        mockMvc.perform(delete("http://localhost:8080/api/vehicles/delete/AP07CA3034/9"))
    	                .andExpect(status().isOk())
    	                .andReturn();
    	    } catch (Exception e) {
    	        assertTrue(false);
    	    }
}
    
    @Test
    public void testURLDeleteVehiclesNegative() {
    	VehiclesDTO vehiclesdto=new VehiclesDTO();
        vehiclesdto.setRegistrationNo("AP07CA3034");
        vehiclesdto.setBelongsToUserId(9);
        vehiclesdto.setVehicleTypeId(4);
        vehiclesdto.setInspectionStatus(InspectionStatusEnum.APPROVED);
        vehiclesdto.setInspectedByUserId(6);
        vehiclesdto.setInspectedOn(null);
    	when(vehicleserviceimpl.deleteVehicles("AP07CA3034",9)).thenReturn("success");
    	
    	 try {
    	    	mockMvc.perform(delete("http://localhost:8088/api/vehicles/delete/AP07CA3034/8"))
    	    			.andExpect(status().isNotFound()).andReturn();

    	    } catch (Exception e) {
    	        assertTrue(true);
    	    }
    }

    @Test
    public void testUpdateApproveRejectPositive() {
    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
    	registervehicledto.setRegistrationNo("AP07CA3034");
    	registervehicledto.setInspectionStatus(InspectionStatusEnum.APPROVED);
    	registervehicledto.setInspectedByUserId(8);
    	registervehicledto.setInspectedOn(null);
    	status stas=new status();
    	stas.setStatus("updated");
    	
    	when(vehicleserviceimpl.updateapprovereject(registervehicledto)).thenReturn("updated");
    	ResponseEntity<?> responseEntity = vehicleController.updateapprovereject( registervehicledto);
    	assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    	assertEquals(stas,responseEntity.getBody());
    	
    }
    
    @Test
    public void testUpdateApproveRejectNegative() {
    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
    	when(vehicleserviceimpl.updateapprovereject(registervehicledto)).thenReturn("fail");
    	ResponseEntity<?> responseEntity = vehicleController.updateapprovereject( registervehicledto);
    	assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    	assertEquals("fail",responseEntity.getBody());
    }
    
//    @Test
//    public void testURLUpdateApproveRejectPositive() {
//    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
//    	registervehicledto.setRegistrationNo("AP07CA3034");
//    	registervehicledto.setInspectionStatus(InspectionStatusEnum.APPROVED);
//    	registervehicledto.setInspectedByUserId(8);
//    	registervehicledto.setInspectedOn(null);
//    	when(vehicleserviceimpl.updateapprovereject(registervehicledto)).thenReturn("updated");
//    	ResponseEntity<?> responseEntity = vehicleController.updateapprovereject( registervehicledto);
//    	assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
//    	assertEquals("updated",responseEntity.getBody());
//    	try {
//	        mockMvc.perform(put("http://localhost:8080/api/vehicles/approveorreject"))
//	                .andExpect(status().isCreated())
//	                .andReturn();
//	    } catch (Exception e) {
//	        assertTrue(false);
//	    }
//    }
    
//    @Test
//    public void testURLUpdateApproveRejectNegative() {
//    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
//    	when(vehicleserviceimpl.updateapprovereject(registervehicledto)).thenReturn("fail");
//    	ResponseEntity<?> responseEntity = vehicleController.updateapprovereject( registervehicledto);
//    	assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
//    	assertEquals("fail",responseEntity.getBody());
//    	try {
//        	mockMvc.perform(get("http://localhost:8080/api/vehicles/approveorreject"))
//        			.andExpect(status().isNotFound()).andReturn();
//
//        } catch (Exception e) {
//            assertTrue(true);
//        }
//}
    
//    @Test
//    public void testGetAllRequestsPositive() {
//    	List<VehiclesDTO> vehiclesDtoList=new ArrayList<>();
//    	VehiclesDTO vehiclesDto=new VehiclesDTO();
//    	vehiclesDto.setRegistrationNo("AP07CA3034");
//    	vehiclesDtoList.add(vehiclesDto);
////    	VehiclesDTO page=new PageImpl<>(vehiclesDtoList);
//    	VehiclesDTO page=new VehiclesDTO();
//    	when (vehicleserviceimpl.getpending(0)).thenReturn(page);
//    	ResponseEntity<VehiclesDTO> responseEntity = vehicleController.getPendingRequests(0);
//    	assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
//    	assertNotNull(responseEntity .getBody());
//    	assertEquals(1,responseEntity .getBody().getContent().size());
//    	assertEquals("AP07CA3034",responseEntity.getBody().getContent().get(0).getRegistrationNo());
//    }
    
//    @Test
//    public void testGetAllRequestsNegative() {
//    	List<VehiclesDTO> vehiclesDtoList=new ArrayList<>();
//    	//VehiclesDTO vehiclesDto=new VehiclesDTO();
////    	vehiclesDto.setRegistrationNo("AP07CA3034");
//    	//vehiclesDtoList.add(vehiclesDto);
//    	//Page<VehiclesDTO> page=new PageImpl<>(vehiclesDtoList);
//    	//when (vehicleserviceimpl.getpending(0)).thenReturn(page);
//    	ResponseEntity<Page<VehiclesDTO>> responseEntity = vehicleController.getPendingRequests(0);
//    	//System.out.println("page"+page);
//    	assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
//    	assertNotNull(responseEntity .getBody());
//    	assertEquals(1,responseEntity .getBody().getContent().size());
//    	assertEquals("AP07CA3034",responseEntity.getBody().getContent().get(4).getRegistrationNo());
//    }
    
//    @Test
//    public void testGetAllRequestsNegative() {
//    	
//    	when (vehicleserviceimpl.getpending(-1)).thenReturn(page);
//    	ResponseEntity<Page<VehiclesDTO>> responseEntity = vehicleController.getPendingRequests(-1);
//    	assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
//    	assertNotNull(responseEntity .getBody());
//    	assertEquals(1,responseEntity .getBody().getContent().size());
//    	assertEquals("AP07CA3034",responseEntity.getBody().getContent().get(0).getRegistrationNo());
//    }
    
    @Test
    public void testpersistVehiclePositive() throws InvalidRegistrationNoException {
    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
    	registervehicledto.setRegistrationNo("AP07CA3034");
    	registervehicledto.setBelongsToUserId(9);
    	registervehicledto.setVehicleTypeId(5);
    	registervehicledto.setInspectionStatus(InspectionStatusEnum.PENDING);
    	registervehicledto.setInspectedByUserId(4);
    	registervehicledto.setInspectedOn(null);
    	registervehicledto.setRtoname("mounika");
    	registervehicledto.setRegistrationDate(null);
    	registervehicledto.setRegistrationExpiresOn(null);
    	registervehicledto.setRcdocurl("rc");
    	registervehicledto.setInsuranceCompanyName("insurance");
    	registervehicledto.setInsuraceNo(2);
    	registervehicledto.setInsurancedOn(null);
    	registervehicledto.setInsuranceExpiresOn(null);
    	registervehicledto.setInsuranceCertificateDOCURL("url");
    	registervehicledto.setPuccertificateno(8);
    	registervehicledto.setPucissuedon(null);
    	registervehicledto.setPucvaliduntil(null);
    	registervehicledto.setPucdocurl("puc");
    	
    	
    	when(vehicleserviceimpl. persistVehicles(registervehicledto)).thenReturn("success");
        ResponseEntity<?> responseEntity = vehicleController.postAddMethod(registervehicledto);
        assertEquals(201, responseEntity.getStatusCodeValue());    	
    	
    }
    
    @Test
    public void testpersistVehicleNegative() throws InvalidRegistrationNoException {
    	RegisterVehicleDTO registervehicledto=new RegisterVehicleDTO();
    	when(vehicleserviceimpl. persistVehicles(registervehicledto)).thenReturn("fail");
        ResponseEntity<?> responseEntity = vehicleController.postAddMethod(registervehicledto);
        assertEquals(400, responseEntity.getStatusCodeValue());  
    }
}

