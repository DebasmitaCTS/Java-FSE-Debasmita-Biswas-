package com.cognizant.utilities;

public enum InspectionStatusEnum {
	PENDING("pending"),
	APPROVED("approved"),
	REJECTED("rejected");
	String val;
	private InspectionStatusEnum(String val) {
		this.val=val;
	}
	public String getVal() {
		return val;
	}
	

}
