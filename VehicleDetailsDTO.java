package com.cognizant.dto;

import java.time.LocalDate;

import lombok.Data;
@Data

public class VehicleDetailsDTO {
	private String RegistrationNo;
	private String RTOName;
	private LocalDate RegistrationDate;
	private LocalDate RegistrationExpiresOn;
	private String RCDocURL;
	private String InsuranceCompanyName;
	private int InsuraceNo;
	private LocalDate InsurancedOn;
	private LocalDate InsuranceExpiresOn;
	private String InsuranceCertificateDOCURL;
	private int PUCCertificateNo;
	private LocalDate PUCIssuedOn;
	private LocalDate PUCValidUntil;
	private String PUCDOCURL;
	
}
