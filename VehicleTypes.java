package com.cognizant.main.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity(name="Vechicle_Types")
public class VehicleTypes {
	
	@OneToMany(mappedBy="vehicleTypeId",targetEntity=Vehicles.class)
	private List<Vehicles> vechicles;
	@Id
	@Column(name="Id")
    private int id;	
	
	@Column(name="Type")
    private int Type;
	
	@Column(name="Max_Passengers_Allowed")
    private int MaxPassengersAllowed;
	
	@Column(name="Fare_PerKM")
    private int FarePerKM;
	
//	public List<Vehicles> getVechicles() {
//		return vechicles;
//	}
//	public void setVechicles(List<Vehicles> vechicles) {
//		this.vechicles = vechicles;
//	}
//	
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public int getType() {
//	return Type;
//}
//public void setType(int type) {
//	Type = type;
//}
//public int getMaxPassengersAllowed() {
//	return MaxPassengersAllowed;
//}
//public void setMaxPassengersAllowed(int maxPassengersAllowed) {
//	MaxPassengersAllowed = maxPassengersAllowed;
//}
//public int getFarePerKM() {
//	return FarePerKM;
//}
//public void setFarePerKM(int farePerKM) {
//	FarePerKM = farePerKM;
//}
//public VehicleTypes(int id, int type, int maxPassengersAllowed, int farePerKM) {
//	super();
//	this.id = id;
//	Type = type;
//	MaxPassengersAllowed = maxPassengersAllowed;
//	FarePerKM = farePerKM;
//}
//public VehicleTypes()
//{
//	
//}
//@Override
//public String toString() {
//	return "VehicleTypes [id=" + id + ", Type=" + Type + ", MaxPassengersAllowed=" + MaxPassengersAllowed
//			+ ", FarePerKM=" + FarePerKM + "]";
//}




}
