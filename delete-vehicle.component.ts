import { Component } from '@angular/core';
import { Vehiclesdto } from '../datatransferobject/vehiclesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';

@Component({
  selector: 'app-delete-vehicle',
  templateUrl: './delete-vehicle.component.html',
  styleUrl: './delete-vehicle.component.css'
})
export class DeleteVehicleComponent {

  vehiclesdto: Vehiclesdto = new Vehiclesdto();
  submitted = false;
  submit=false;
  errorMessage ! :'';
  ifError=false;  
  constructor(private vehiclemanagementservice: VehicleManagementService) {
    this.vehiclesdto.registrationNo=vehiclemanagementservice.getregistrationNo();
    this.vehiclesdto.belongsToUserId=vehiclemanagementservice.belongsToUserId;
    
  }
  ngOnInit() {
  }

  // delete() {

  //   this.vehiclemanagementservice.deletevehicle(this.vehiclesdto)
  //     .subscribe(data => console.log(data), error => console.log(error));
  //   this.vehiclesdto = new Vehiclesdto();
  // }
  delete() {

    this.vehiclemanagementservice.deletevehicle(this.vehiclesdto)
      .subscribe(data => {console.log(data); this.submit = true}, 
          error => { this.errorMessage=error;
            this.ifError=true;this.submitted=false});
            console.log(this.errorMessage);
    this.vehiclesdto = new Vehiclesdto();
  }

  

  onSubmit() {
    this.submitted = true;
    this.delete();
    
  }
}
