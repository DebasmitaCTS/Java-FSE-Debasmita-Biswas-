package com.cognizant.main.entities;

import java.time.LocalDate;

import com.cognizant.utilities.InspectionStatusEnum;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Vechicles")
public class Vehicles {

	@Id
	@Column(name = "Registration_No")
	private String registrationNo;

	@Column(name = "Belongs_To_User_Id")
	private int belongsToUserId;
	
	@ManyToOne
	@JoinColumn(name = "Vechicle_Type_Id", referencedColumnName = "Id")
	private VehicleTypes vehicleTypeId;

	@Enumerated(EnumType.STRING)
	@Column(name = "Inspection_Status")
	private InspectionStatusEnum inspectionStatus;

	@Column(name = "Inspected_By_User_Id")
	private int inspectedByUserId;

	@Column(name = "Inspected_On")
	private LocalDate inspectedOn;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn(name="Registration_No",referencedColumnName="Registration_No")
	private VehicleDetails vehicleDetails; 

//	public VehicleDetails getVehicleDetails() {
//			return vehicleDetails;
//	}
//
//	public void setVehicleDetails(VehicleDetails vehicleDetails) {
//			this.vehicleDetails = vehicleDetails;
//	}
//
//
//	public int getBelongsToUserId() {
//		return belongsToUserId;
//	}
//
//	public void setBelongsToUserId(int belongsToUserId) {
//		this.belongsToUserId = belongsToUserId;
//	}
//
//	public VehicleTypes getVehicleTypeId() {
//		return vehicleTypeId;
//	}
//
//	public void setVehicleTypeId(VehicleTypes vehicleTypeId) {
//		this.vehicleTypeId = vehicleTypeId;
//	}
//
//	public InspectionStatusEnum getInspectionStatus() {
//		return inspectionStatus;
//	}
//
//	public void setInspectionStatus(InspectionStatusEnum inspectionStatus) {
//		this.inspectionStatus = inspectionStatus;
//	}
//
//	public int getInspectedByUserId() {
//		return inspectedByUserId;
//	}
//
//	public void setInspectedByUserId(int inspectedByUserId) {
//		this.inspectedByUserId = inspectedByUserId;
//	}
//
//	public LocalDate getInspectedOn() {
//		return inspectedOn;
//	}
//
//	public void setInspectedOn(LocalDate inspectedOn) {
//		this.inspectedOn = inspectedOn;
//	}
//
//	public String getRegistrationNo() {
//		return registrationNo;
//	}
//
//	public void setRegistrationNo(String registrationNo) {
//		this.registrationNo = registrationNo;
//	}
//
//	@Override
//	public String toString() {
//		return "Vehicles [registrationNo=" + registrationNo + ", vehicleDetails=" + vehicleDetails
//				+ ", belongsToUserId=" + belongsToUserId + ", vehicleTypeId=" + vehicleTypeId + ", inspectionStatus="
//				+ inspectionStatus + ", inspectedByUserId=" + inspectedByUserId + ", inspectedOn=" + inspectedOn + "]";
//	}
   
}
