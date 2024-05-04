export class Vehiclesdto {
     
    registrationNo!:string;
    belongsToUserId!:number;
    vehicleTypeId!:number;
    inspectionStatus!:string;
    inspectedByUserId!:number;
    inspectedOn!:Date;

    // private String registrationNo;
	// private int belongsToUserId;
	// private int vehicleTypeId;
	// @Enumerated(EnumType.STRING)
	// private InspectionStatusEnum inspectionStatus;
	// private int inspectedByUserId;
	// private LocalDate inspectedOn;
}
