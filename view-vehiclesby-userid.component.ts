import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vehiclesdto } from '../datatransferobject/vehiclesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';
//import { ViewVehiclebyUseridService } from '../Service/view-vehicleby-userid.service';
//import {ViewVehiclebyUseridService} from '..'

@Component({
  selector: 'app-view-vehiclesby-userid',
  templateUrl: './view-vehiclesby-userid.component.html',
  styleUrl: './view-vehiclesby-userid.component.css'
})
export class ViewVehiclesbyUseridComponent implements OnInit{
 formData:any; 
 vehiclebyuser: Vehiclesdto=new Vehiclesdto();
 vehiclebyuserid!:Vehiclesdto[];
 submitted = false;
  noRecordFound=false;
  belongstouserid!:number;
  submit=false;
  errorMessage ! :'';
  ifError=false;
  responseData: Boolean = false;
  responseError: Boolean = false;

  constructor(private router: Router, private vehiclemanagementservice:VehicleManagementService) {
  }
  // search() {
  //   this.vehiclemanagementservice.getVehicleById(this.vehiclebyuser)
  //   .subscribe( data => {
  //     this.vehiclebyuser = data;
  //     console.log(this.vehiclebyuserid);
  //   });
  search() {
    this.vehiclemanagementservice.getVehicleById(this.vehiclebyuser)
    .subscribe( data => {
      this.vehiclebyuser = data;
      this.responseData= true;
      console.log(this.vehiclebyuserid);
    },error => {
      this.responseError = true;
    });
    if(this.vehiclebyuserid.length==0){
      console.log("in if");
      this.noRecordFound=true;
    }
  }

  // save() {
  //   this.vehiclemanagementservice.registervehicle(this.addNewVehicleTest)
  //     .subscribe(data => {console.log(data); this.submit = true}, 
  //     error => { this.errorMessage=error;
  //       this.ifError=true;this.submitted=false});
  //       console.log(this.errorMessage);
  //   this.addNewVehicleTest = new Registervehicledto();
  // }

  ngOnInit() {
    this.formData=new FormGroup(
      {
        belongsToUserIdNew: new FormControl("",Validators.compose(
              [
                Validators.required
              ]
        )),  
    
      }
    );
  }


//   ngOnInit(): void {

//     this.formData=new FormGroup(
// {
//  registrationNo: new FormControl("",Validators.compose(
//    [
//      Validators.required,
//      Validators.pattern(/^[A-Za-z]{2}\d{2}[A-Za-z]{2}\d{4}$/)
//    ]
//  )),
  onSubmit(data: any ) {
     console.log(JSON.stringify(this.vehiclebyuser.belongsToUserId));
    // this.submitted = true;
    // this.search();
    this.submitted = true;
    //this.vehiclebyuser.belongsToUserId=data.belongsToUserId;
    this.search();

   }
   get belongsToUserIdNew():FormControl
  {
    return this.formData.get('belongsToUserIdNew');
  }
}
