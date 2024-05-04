import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vehiclesdto } from '../datatransferobject/vehiclesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';

@Component({
  selector: 'app-approve-reject-vehicle',
  templateUrl: './approve-reject-vehicle.component.html',
  styleUrl: './approve-reject-vehicle.component.css'
})
export class ApproveRejectVehicleComponent {
  formData:any; 
  vehiclebyuser: Vehiclesdto=new Vehiclesdto();
 
 submitted = false;
  noRecordFound=false;
  pageno!:number;
  responseData: Boolean = false;
  responseError: Boolean = false;
 
  constructor(private router: Router, private vehiclemanagementservice:VehicleManagementService) {
  }

  // search() {
  //   this.vehiclemanagementservice.getbyPageNo(this.pageno)
  //   .subscribe( data => {
  //     this.vehiclebyuser = data;
  //     console.log(this.vehiclebyuser);
  //   });

  search() {
    this.vehiclemanagementservice.getbyPageNo(this.pageno)
    .subscribe( data => {
      this.vehiclebyuser = data;
      this.responseData= true;
      console.log(this.vehiclebyuser);
    },
    error => {
      this.responseError = true;
    });
    // if(this.pageno.length==0){
    //   console.log("in if");
    //   this.noRecordFound=true;
    // }
}

// update() {
//   this.vehiclemanagementservice.updateRegistration(this.Registerdto)
//     .subscribe(data => {console.log(data); this.submit = true}, 
//         error => { this.errorMessage=error;
//           this.ifError=true;this.submitted=false});
//           console.log(this.errorMessage);
//   this.Registerdto = new Registervehicledto();
// }

ngOnInit() {
  this.formData=new FormGroup(
    {
      pagenoNew: new FormControl("",Validators.compose(
            [
              Validators.required
            ]
      )),  
  
    }
  );
}

onSubmit( data: any) {
  console.log(JSON.stringify(this.pageno));
  this.submitted = true;
  this.search();
  }
  
 
  get pagenoNew():FormControl
  {
    return this.formData.get('pagenoNew');
  }

 }

