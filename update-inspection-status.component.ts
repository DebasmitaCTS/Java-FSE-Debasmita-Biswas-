import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Registervehicledto } from '../datatransferobject/Registervehicledto';
import { Vehiclesdto } from '../datatransferobject/vehiclesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';

@Component({
  selector: 'app-update-inspection-status',
  templateUrl: './update-inspection-status.component.html',
  styleUrl: './update-inspection-status.component.css'
})
export class UpdateInspectionStatusComponent implements OnInit{
  formData: any;
   Registerdto: Registervehicledto = new Registervehicledto();
   submitted = false;
   submit=false;
  errorMessage ! :'';
  ifError=false;
//   vehiclesdto: Vehiclesdto=new Vehiclesdto();
   RegistrationNo!:Registervehicledto[];

  constructor(private vehiclemanagementservice: VehicleManagementService) {
//       this.Registerdto.registrationNo=vehiclemanagementservice.getregistrationNo();

//       this.vehiclemanagementservice.getVehicleById(this.Registerdto)
// .subscribe( data => {
//   this.RegistrationNo = data;
//   console.log(data);

//   this.employee.empId=data['empId'];
//   this.employee.empName=data['empName'];
//   this.employee.empSalary=data['empSalary'];
//   this.employee.empDesignation=data['empDesignation'];
    
// });
  }
// this.Registerdto.inspectionStatus=vehiclemanagementservice.getregistrationNo();
// this.vehiclemanagementservice.getbelongsToUserId(this.vehiclesdto)
// .subscribe( data => {
//   this.RegistrationNo = data;
//   console.log(data);

 // this.Registerdto.inspectionStatus=data['inspectionStatus'];
//   this.Registerdto.inspectedByUserId=data['inspectedByUserId'];
//   this.Registerdto.inspectedOn=data['inspectedOn']
    
ngOnInit() {
  this.formData=new FormGroup(
    {
      registrationNo: new FormControl("",Validators.compose(
            [
              Validators.required
            ]
      )),  
      inspectionStatus: new FormControl("",Validators.compose(
        [
          Validators.required
        ]
  )), 
  inspectedByUserId: new FormControl("",Validators.compose(
    [
      Validators.required
    ]
)), 
inspectedOn: new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)), 
    }
  );
}

// updateEmployee(): void {
//   this.submitted = false;
//   this.Registerdto = new Registervehicledto();
// }
update() {
  this.vehiclemanagementservice.updateRegistration(this.Registerdto)
    .subscribe(data => {console.log(data); this.submit = true}, 
        error => { this.errorMessage=error;
          this.ifError=true;this.submitted=false});
          console.log(this.errorMessage);
  this.Registerdto = new Registervehicledto();
}

onSubmit() {
  this.submitted = true;
  this.update();
}
get registrationNo():FormControl
  {
    return this.formData.get('registrationNo');
  }

  get inspectionStatus():FormControl
  {
    return this.formData.get('registrationNo');
  }
  get inspectedByUserId():FormControl
  {
    return this.formData.get('registrationNo');
  }
  get inspectedOn():FormControl
  {
    return this.formData.get('registrationNo');
  }

  todayDate(){
    return new Date().toISOString().split('T')[0];
  }
}
