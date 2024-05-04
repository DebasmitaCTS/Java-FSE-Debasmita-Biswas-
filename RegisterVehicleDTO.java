package com.cognizant.dto;

import java.time.LocalDate;
import com.cognizant.utilities.InspectionStatusEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class RegisterVehicleDTO {
	
	private String registrationNo;
	private int belongsToUserId;
	private int vehicleTypeId;
	@Enumerated(EnumType.STRING)
	private InspectionStatusEnum inspectionStatus;
	private int inspectedByUserId;
	private LocalDate inspectedOn;
	private String rtoname;
	private LocalDate registrationDate;
	private LocalDate registrationExpiresOn;
	private String rcdocurl;
	private String insuranceCompanyName;
	private int insuraceNo;
	private LocalDate insurancedOn;
	private LocalDate insuranceExpiresOn;
	private String insuranceCertificateDOCURL;
	private int puccertificateno;
	private LocalDate pucissuedon;
	private LocalDate pucvaliduntil;
	private String pucdocurl;
	private String vehiclesDetailsregistrationNo;
	private String vehiclesregistrationNo;
//	public String getRegistrationNo() {
//		return registrationNo;
//	}
//	public void setRegistrationNo(String registrationNo) {
//		this.registrationNo = registrationNo;
//	}
//	public int getBelongsToUserId() {
//		return belongsToUserId;
//	}
//	public void setBelongsToUserId(int belongsToUserId) {
//		this.belongsToUserId = belongsToUserId;
//	}
//	public int getVehicleTypeId() {
//		return vehicleTypeId;
//	}
//	public void setVehicleTypeId(int vehicleTypeId) {
//		this.vehicleTypeId = vehicleTypeId;
//	}
//	public InspectionStatusEnum getInspectionStatus() {
//		return inspectionStatus;
//	}
//	public void setInspectionStatus(InspectionStatusEnum inspectionStatus) {
//		this.inspectionStatus = inspectionStatus;
//	}
//	public int getInspectedByUserId() {
//		return inspectedByUserId;
//	}
//	public void setInspectedByUserId(int inspectedByUserId) {
//		this.inspectedByUserId = inspectedByUserId;
//	}
//	public LocalDate getInspectedOn() {
//		return inspectedOn;
//	}
//	public void setInspectedOn(LocalDate inspectedOn) {
//		this.inspectedOn = inspectedOn;
//	}
//	public String getRTOName() {
//		return rTOName;
//	}
//	public void setRTOName(String RTOName) {
//		this.rTOName = RTOName;
//	}
//	public LocalDate getRegistrationDate() {
//		return registrationDate;
//	}
//	public void setRegistrationDate(LocalDate registrationDate) {
//		this.registrationDate = registrationDate;
//	}
//	public LocalDate getRegistrationExpiresOn() {
//		return registrationExpiresOn;
//	}
//	public void setRegistrationExpiresOn(LocalDate registrationExpiresOn) {
//		this.registrationExpiresOn = registrationExpiresOn;
//	}
//	public String getRCDocURL() {
//		return rCDocURL;
//	}
//	public void setRCDocURL(String rCDocURL) {
//		this.rCDocURL = rCDocURL;
//	}
//	public String getInsuranceCompanyName() {
//		return insuranceCompanyName;
//	}
//	public void setInsuranceCompanyName(String insuranceCompanyName) {
//		this.insuranceCompanyName = insuranceCompanyName;
//	}
//	public int getInsuraceNo() {
//		return insuraceNo;
//	}
//	public void setInsuraceNo(int insuraceNo) {
//		this.insuraceNo = insuraceNo;
//	}
//	public LocalDate getInsurancedOn() {
//		return insurancedOn;
//	}
//	public void setInsurancedOn(LocalDate insurancedOn) {
//		this.insurancedOn = insurancedOn;
//	}
//	public LocalDate getInsuranceExpiresOn() {
//		return insuranceExpiresOn;
//	}
//	public void setInsuranceExpiresOn(LocalDate insuranceExpiresOn) {
//		this.insuranceExpiresOn = insuranceExpiresOn;
//	}
//	public String getInsuranceCertificateDOCURL() {
//		return insuranceCertificateDOCURL;
//	}
//	public void setInsuranceCertificateDOCURL(String insuranceCertificateDOCURL) {
//		this.insuranceCertificateDOCURL = insuranceCertificateDOCURL;
//	}
//	public int getPUCCertificateNo() {
//		return pUCCertificateNo;
//	}
//	public void setPUCCertificateNo(int pUCCertificateNo) {
//		this.pUCCertificateNo = pUCCertificateNo;
//	}
//	public LocalDate getPUCIssuedOn() {
//		return pUCIssuedOn;
//	}
//	public void setPUCIssuedOn(LocalDate pUCIssuedOn) {
//		this.pUCIssuedOn = pUCIssuedOn;
//	}
//	public LocalDate getpUCValidUntil() {
//		return pUCValidUntil;
//	}
//	public void setpUCValidUntil(LocalDate pUCValidUntil) {
//		this.pUCValidUntil = pUCValidUntil;
//	}
//	public String getpUCDOCURL() {
//		return pUCDOCURL;
//	}
//	public void setpUCDOCURL(String pUCDOCURL) {
//		this.pUCDOCURL = pUCDOCURL;
//	}
//	public String getVehiclesDetailsregistrationNo() {
//		return vehiclesDetailsregistrationNo;
//	}
//	public void setVehiclesDetailsregistrationNo(String vehiclesDetailsregistrationNo) {
//		this.vehiclesDetailsregistrationNo = vehiclesDetailsregistrationNo;
//	}
//	public String getVehiclesregistrationNo() {
//		return vehiclesregistrationNo;
//	}
//	public void setVehiclesregistrationNo(String vehiclesregistrationNo) {
//		this.vehiclesregistrationNo = vehiclesregistrationNo;
//	}
//	@Override
//	public String toString() {
//		return "RegisterVehicleDTO [registrationNo=" + registrationNo + ", belongsToUserId=" + belongsToUserId
//				+ ", vehicleTypeId=" + vehicleTypeId + ", inspectionStatus=" + inspectionStatus + ", inspectedByUserId="
//				+ inspectedByUserId + ", inspectedOn=" + inspectedOn + ", rTOName=" + rTOName + ", registrationDate="
//				+ registrationDate + ", registrationExpiresOn=" + registrationExpiresOn + ", rCDocURL=" + rCDocURL
//				+ ", insuranceCompanyName=" + insuranceCompanyName + ", insuraceNo=" + insuraceNo + ", insurancedOn="
//				+ insurancedOn + ", insuranceExpiresOn=" + insuranceExpiresOn + ", insuranceCertificateDOCURL="
//				+ insuranceCertificateDOCURL + ", pUCCertificateNo=" + pUCCertificateNo + ", pUCIssuedOn=" + pUCIssuedOn
//				+ ", pUCValidUntil=" + pUCValidUntil + ", pUCDOCURL=" + pUCDOCURL + ", vehiclesDetailsregistrationNo="
//				+ vehiclesDetailsregistrationNo + ", vehiclesregistrationNo=" + vehiclesregistrationNo + "]";
//	}
//	
//	
//	private String registrationNo;
//	private int belongsToUserId;
//	private int vehicleTypeId;
//	@Enumerated(EnumType.STRING)
//	private InspectionStatusEnum inspectionStatus;
//	private int inspectedByUserId;
//	private LocalDate inspectedOn;
//	private String rTOName;
//	private LocalDate registrationDate;
//	private LocalDate registrationExpiresOn;
//	private String rCDocURL;
//	private String insuranceCompanyName;
//	private int insuraceNo;
//	private LocalDate insurancedOn;
//	private LocalDate insuranceExpiresOn;
//	private String insuranceCertificateDOCURL;
//	private int pUCCertificateNo;
//	private LocalDate pUCIssuedOn;
//	private LocalDate pUCValidUntil;
//	private String pUCDOCURL;
//	private String vehiclesDetailsregistrationNo;
//	private String vehiclesregistrationNo;
//	public String getRegistrationNo() {
//		return registrationNo;
//	}
//	public void setRegistrationNo(String registrationNo) {
//		this.registrationNo = registrationNo;
//	}
//	public int getBelongsToUserId() {
//		return belongsToUserId;
//	}
//	public void setBelongsToUserId(int belongsToUserId) {
//		this.belongsToUserId = belongsToUserId;
//	}
//	public int getVehicleTypeId() {
//		return vehicleTypeId;
//	}
//	public void setVehicleTypeId(int vehicleTypeId) {
//		this.vehicleTypeId = vehicleTypeId;
//	}
//	public InspectionStatusEnum getInspectionStatus() {
//		return inspectionStatus;
//	}
//	public void setInspectionStatus(InspectionStatusEnum inspectionStatus) {
//		this.inspectionStatus = inspectionStatus;
//	}
//	public int getInspectedByUserId() {
//		return inspectedByUserId;
//	}
//	public void setInspectedByUserId(int inspectedByUserId) {
//		this.inspectedByUserId = inspectedByUserId;
//	}
//	public LocalDate getInspectedOn() {
//		return inspectedOn;
//	}
//	public void setInspectedOn(LocalDate inspectedOn) {
//		this.inspectedOn = inspectedOn;
//	}
//	public String getrTOName() {
//		return rTOName;
//	}
//	public void setrTOName(String rTOName) {
//		this.rTOName = rTOName;
//	}
//	public LocalDate getRegistrationDate() {
//		return registrationDate;
//	}
//	public void setRegistrationDate(LocalDate registrationDate) {
//		this.registrationDate = registrationDate;
//	}
//	public LocalDate getRegistrationExpiresOn() {
//		return registrationExpiresOn;
//	}
//	public void setRegistrationExpiresOn(LocalDate registrationExpiresOn) {
//		this.registrationExpiresOn = registrationExpiresOn;
//	}
//	public String getrCDocURL() {
//		return rCDocURL;
//	}
//	public void setrCDocURL(String rCDocURL) {
//		this.rCDocURL = rCDocURL;
//	}
//	public String getInsuranceCompanyName() {
//		return insuranceCompanyName;
//	}
//	public void setInsuranceCompanyName(String insuranceCompanyName) {
//		this.insuranceCompanyName = insuranceCompanyName;
//	}
//	public int getInsuraceNo() {
//		return insuraceNo;
//	}
//	public void setInsuraceNo(int insuraceNo) {
//		this.insuraceNo = insuraceNo;
//	}
//	public LocalDate getInsurancedOn() {
//		return insurancedOn;
//	}
//	public void setInsurancedOn(LocalDate insurancedOn) {
//		this.insurancedOn = insurancedOn;
//	}
//	public LocalDate getInsuranceExpiresOn() {
//		return insuranceExpiresOn;
//	}
//	public void setInsuranceExpiresOn(LocalDate insuranceExpiresOn) {
//		this.insuranceExpiresOn = insuranceExpiresOn;
//	}
//	public String getInsuranceCertificateDOCURL() {
//		return insuranceCertificateDOCURL;
//	}
//	public void setInsuranceCertificateDOCURL(String insuranceCertificateDOCURL) {
//		this.insuranceCertificateDOCURL = insuranceCertificateDOCURL;
//	}
//	public int getpUCCertificateNo() {
//		return pUCCertificateNo;
//	}
//	public void setpUCCertificateNo(int pUCCertificateNo) {
//		this.pUCCertificateNo = pUCCertificateNo;
//	}
//	public LocalDate getpUCIssuedOn() {
//		return pUCIssuedOn;
//	}
//	public void setpUCIssuedOn(LocalDate pUCIssuedOn) {
//		this.pUCIssuedOn = pUCIssuedOn;
//	}
//	public LocalDate getpUCValidUntil() {
//		return pUCValidUntil;
//	}
//	public void setpUCValidUntil(LocalDate pUCValidUntil) {
//		this.pUCValidUntil = pUCValidUntil;
//	}
//	public String getpUCDOCURL() {
//		return pUCDOCURL;
//	}
//	public void setpUCDOCURL(String pUCDOCURL) {
//		this.pUCDOCURL = pUCDOCURL;
//	}
//	public String getVehiclesDetailsregistrationNo() {
//		return vehiclesDetailsregistrationNo;
//	}
//	public void setVehiclesDetailsregistrationNo(String vehiclesDetailsregistrationNo) {
//		this.vehiclesDetailsregistrationNo = vehiclesDetailsregistrationNo;
//	}
//	public String getVehiclesregistrationNo() {
//		return vehiclesregistrationNo;
//	}
//	public void setVehiclesregistrationNo(String vehiclesregistrationNo) {
//		this.vehiclesregistrationNo = vehiclesregistrationNo;
//	}
//	@Override
//	public String toString() {
//		return "RegisterVehicleDTO [registrationNo=" + registrationNo + ", belongsToUserId=" + belongsToUserId
//				+ ", vehicleTypeId=" + vehicleTypeId + ", inspectionStatus=" + inspectionStatus + ", inspectedByUserId="
//				+ inspectedByUserId + ", inspectedOn=" + inspectedOn + ", rTOName=" + rTOName + ", registrationDate="
//				+ registrationDate + ", registrationExpiresOn=" + registrationExpiresOn + ", rCDocURL=" + rCDocURL
//				+ ", insuranceCompanyName=" + insuranceCompanyName + ", insuraceNo=" + insuraceNo + ", insurancedOn="
//				+ insurancedOn + ", insuranceExpiresOn=" + insuranceExpiresOn + ", insuranceCertificateDOCURL="
//				+ insuranceCertificateDOCURL + ", pUCCertificateNo=" + pUCCertificateNo + ", pUCIssuedOn=" + pUCIssuedOn
//				+ ", pUCValidUntil=" + pUCValidUntil + ", pUCDOCURL=" + pUCDOCURL + ", vehiclesDetailsregistrationNo="
//				+ vehiclesDetailsregistrationNo + ", vehiclesregistrationNo=" + vehiclesregistrationNo + "]";
//	}
//	
	
	
	
}
	