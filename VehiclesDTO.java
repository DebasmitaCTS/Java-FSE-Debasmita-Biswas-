package com.cognizant.dto;

import java.time.LocalDate;

import com.cognizant.utilities.InspectionStatusEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class VehiclesDTO {
	
	private String registrationNo;
	private int belongsToUserId;
	private int vehicleTypeId;
	@Enumerated(EnumType.STRING)
	private InspectionStatusEnum inspectionStatus;
	private int inspectedByUserId;
	private LocalDate inspectedOn;
	
	
}
