package com.cognizant.main.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = " Vechile_Details")
public class VehicleDetails {

	@Id
	@Column(name="Registration_No")
	private String registrationNo;
    
	@Column(name=" RTOName")
	private String RTOName;
	
	@Column(name="Registration_Date")
	private LocalDate RegistrationDate;
	
	@Column(name="Registration_Expires_On")
	private LocalDate RegistrationExpiresOn;
	
	@Column(name="RCDocURL")
	private String RCDocURL;
	
	@Column(name="Insurance_Company_Name")
	private String InsuranceCompanyName;
	
	@Column(name="Insurance_No")
	private int InsuraceNo;
	
	@Column(name="Insuranced_On")
	private LocalDate InsurancedOn;
	
	@Column(name="Insurance_Expires_On")
	private LocalDate InsuranceExpiresOn;
	
	@Column(name="Insurance_CertificateDOCURL")
	private String InsuranceCertificateDOCURL;
	
	@Column(name="PUCCertificate_No")
	private int PUCCertificateNo;
	
	@Column(name="PUCIssued_On")
	private LocalDate PUCIssuedOn;
	
	@Column(name="PUCValid_Until")
	private LocalDate PUCValidUntil;
	
	@Column(name="PUCDOCURL")
	private String PUCDOCURL;
	

//	public String getRTOName() {
//		return RTOName;
//	}
//	public void setRTOName(String rTOName) {
//		RTOName = rTOName;
//	}
//	public LocalDate getRegistrationDate() {
//		return RegistrationDate;
//	}
//	public void setRegistrationDate(LocalDate registrationDate) {
//		RegistrationDate = registrationDate;
//	}
//	public LocalDate getRegistrationExpiresOn() {
//		return RegistrationExpiresOn;
//	}
//	public void setRegistrationExpiresOn(LocalDate registrationExpiresOn) {
//		RegistrationExpiresOn = registrationExpiresOn;
//	}
//	public String getRCDocURL() {
//		return RCDocURL;
//	}
//	public void setRCDocURL(String rCDocURL) {
//		RCDocURL = rCDocURL;
//	}
//	public String getInsuranceCompanyName() {
//		return InsuranceCompanyName;
//	}
//	public void setInsuranceCompanyName(String insuranceCompanyName) {
//		InsuranceCompanyName = insuranceCompanyName;
//	}
//	public int getInsuraceNo() {
//		return InsuraceNo;
//	}
//	public void setInsuraceNo(int insuraceNo) {
//		InsuraceNo = insuraceNo;
//	}
//	public LocalDate getInsurancedOn() {
//		return InsurancedOn;
//	}
//	public void setInsurancedOn(LocalDate insurancedOn) {
//		InsurancedOn = insurancedOn;
//	}
//	public LocalDate getInsuranceExpiresOn() {
//		return InsuranceExpiresOn;
//	}
//	public void setInsuranceExpiresOn(LocalDate insuranceExpiresOn) {
//		InsuranceExpiresOn = insuranceExpiresOn;
//	}
//	public String getInsuranceCertificateDOCURL() {
//		return InsuranceCertificateDOCURL;
//	}
//	public void setInsuranceCertificateDOCURL(String insuranceCertificateDOCURL) {
//		InsuranceCertificateDOCURL = insuranceCertificateDOCURL;
//	}
//	public int getPUCCertificateNo() {
//		return PUCCertificateNo;
//	}
//	public void setPUCCertificateNo(int pUCCertificateNo) {
//		PUCCertificateNo = pUCCertificateNo;
//	}
//	public LocalDate getPUCIssuedOn() {
//		return PUCIssuedOn;
//	}
//	public void setPUCIssuedOn(LocalDate pUCIssuedOn) {
//		PUCIssuedOn = pUCIssuedOn;
//	}
//	public LocalDate getPUCValidUntil() {
//		return PUCValidUntil;
//	}
//	public void setPUCValidUntil(LocalDate pUCValidUntil) {
//		PUCValidUntil = pUCValidUntil;
//	}
//	public String getPUCDOCURL() {
//		return PUCDOCURL;
//	}
//	public void setPUCDOCURL(String pUCDOCURL) {
//		PUCDOCURL = pUCDOCURL;
//	}
//	public String getRegistrationNo() {
//		return registrationNo;
//	}
//	public void setRegistrationNo(String registrationNo) {
//		this.registrationNo = registrationNo;
//	}
//	@Override
//	public String toString() {
//		return "VehicleDetails [registrationNo=" + registrationNo + ", RTOName=" + RTOName + ", RegistrationDate="
//				+ RegistrationDate + ", RegistrationExpiresOn=" + RegistrationExpiresOn + ", RCDocURL=" + RCDocURL
//				+ ", InsuranceCompanyName=" + InsuranceCompanyName + ", InsuraceNo=" + InsuraceNo + ", InsurancedOn="
//				+ InsurancedOn + ", InsuranceExpiresOn=" + InsuranceExpiresOn + ", InsuranceCertificateDOCURL="
//				+ InsuranceCertificateDOCURL + ", PUCCertificateNo=" + PUCCertificateNo + ", PUCIssuedOn=" + PUCIssuedOn
//				+ ", PUCValidUntil=" + PUCValidUntil + ", PUCDOCURL=" + PUCDOCURL + "]";
//	}
	
}
