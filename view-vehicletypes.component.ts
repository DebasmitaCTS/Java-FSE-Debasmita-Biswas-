import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicletypesdto } from '../datatransferobject/vehicletypesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';

@Component({
  selector: 'app-view-vehicletypes',
  templateUrl: './view-vehicletypes.component.html',
  styleUrl: './view-vehicletypes.component.css'
})
export class ViewVehicletypesComponent implements OnInit{

 vehicletypes !: Vehicletypesdto[];


constructor(private router: Router, private vehicleManagementService:VehicleManagementService)  {
  this.vehicleManagementService.getvehicletypes()
  .subscribe( data => {
    this.vehicletypes=data;
  });
}

ngOnInit() {
   

};


}

