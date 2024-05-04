import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Registervehicledto } from '../datatransferobject/Registervehicledto';
import { Vehicletypesdto } from '../datatransferobject/vehicletypesdto';
import { VehicleManagementService } from '../Service/vehicle-management.service';
@Component({
  selector: 'app-add-new-vehicle',
  templateUrl: './add-new-vehicle.component.html',
  styleUrl: './add-new-vehicle.component.css'
})
export class AddNewVehicleComponent implements OnInit {
//   formData: any;
//   submitted = false;
//   addNewVehicleTest : Registervehicledto = new Registervehicledto();

//   constructor(private vehiclemanagementservice: VehicleManagementService){}


//   ngOnInit(): void {

//     this.formData=new FormGroup(
// {
//   registrationNo : new FormControl("",Validators.compose(
//    [
//      Validators.required,
//      Validators.pattern(/^[A-Za-z]{2}\d{2}[A-Za-z]{2}\d{4}$/)
//    ]
//  )),

//   save()
//   {
//     this.vehiclemanagementservice.registervehicle(this.addNewVehicleTest).subscribe(data => console.log(data),error => console.log(error));
//     console.log("In save")
//   }

//   onSubmit()
//   {
//     this.submitted = true;
//     this.save();
//   }
// //   Vehiclesvalid = new FormGroup(
// //     {
// //       registrationNo : new FormControl('',Validators.required),
// //       belongsToUserId : new FormControl('',Validators.required),
// //       vehicleTypeId: new FormControl('',Validators.required),
// //       rtoname: new FormControl('',Validators.required),
// //       registrationDate: new FormControl('',Validators.required),
// //       rcdocurl: new FormControl('',Validators.required),
// //       insuranceCompanyName: new FormControl('',Validators.required),
// //       insuraceNo: new FormControl('',Validators.required),
// //       insurancedOn: new FormControl('',Validators.required),
// //      // insuranceExpiresOn: new FormControl('',Validators.required),
// //       insuranceCertificateDOCURL: new FormControl('',Validators.required),
// //       puccertificateno: new FormControl('',Validators.required),
// //       pucissuedon: new FormControl('',Validators.required),
// //       //pucvaliduntil: new FormControl('',Validators.required),
// //       pucdocurl: new FormControl('',Validators.required),

// // }
// //   )


// get registrationNo():FormControl{
//   // get registrationNo()
  
//     return this.Vehiclesvalid.get('registrationNo')
//   }
//   get belongsToUserId()
//   {
//     return this.Vehiclesvalid.get('belongsToUserId')
//   }
//   get vehicleTypeId()
//   {
//     return this.Vehiclesvalid.get('vehicleTypeId')
//   }
//   get rtoname()
//   {
//     return this.Vehiclesvalid.get('rtoname')
//   }
//   get registrationDate()
//   {
//     return this.Vehiclesvalid.get('registrationDate')
//   }
//   get rcdocurl()
//   {
//     return this.Vehiclesvalid.get('rcdocurl')
//   }
//   get insuranceCompanyName()
//   {
//     return this.Vehiclesvalid.get('insuranceCompanyName')
//   }
//   get insuraceNo()
//   {
//     return this.Vehiclesvalid.get('insuraceNo')
//   }
//   get insurancedOn()
//   {
//     return this.Vehiclesvalid.get('insurancedOn')
//   }
//   get insuranceCertificateDOCURL()
//   {
//     return this.Vehiclesvalid.get('insuranceCertificateDOCURL')
//   }
//   get puccertificateno()
//   {
//     return this.Vehiclesvalid.get('puccertificateno')
//   }
//   get pucissuedon()
//   {
//     return this.Vehiclesvalid.get('pucissuedon')
//   }
//   get pucdocurl()
//   {
//     return this.Vehiclesvalid.get('pucdocurl')
//   }


formData: any;
addNewVehicleTest : Registervehicledto = new Registervehicledto();
  submitted = false;
  submit=false;
  errorMessage ! :'';
  ifError=false;
  addNewVehicle!:Vehicletypesdto[];
  text='VehicleRegistration Form page';
// today: string|number|Date;
  constructor(private vehiclemanagementservice: VehicleManagementService ) { }

  ngOnInit(): void {



this.vehiclemanagementservice.getvehicletypes().subscribe(
  data =>{
    this.addNewVehicle = data;

  },
  error =>{
    console.log(error);
    
  }
)






    this.formData=new FormGroup(
{
 registrationNo: new FormControl("",Validators.compose(
   [
     Validators.required,
     Validators.pattern(/^[A-Za-z]{2}\d{2}[A-Za-z]{2}\d{4}$/)
   ]
 )),
 belongsToUserId:new FormControl("",Validators.compose(
   [
     Validators.required,
     
   ]
 )),
 vehicleTypeId:new FormControl("",Validators.compose(
   [
     Validators.required,
     
   ]
 )),
 rtoname:new FormControl("",Validators.compose(
   [
     Validators.required
   ]
 )),

//  twoYearsAgo : Date ;
//  twoYearsAgo.setFullYear(new Date().getFullYear() -2),

 registrationDate:new FormControl("",Validators.compose(
  [
    Validators.required,
    // Validators.min(twoYearsAgo)
  ]
)),
rcdocurl:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
insuranceCompanyName:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
insuraceNo:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
insurancedOn:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),

insuranceCertificateDOCURL:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
puccertificateno:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
pucissuedon:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
pucdocurl:new FormControl("",Validators.compose(
  [
    Validators.required
  ]
)),
}
);
  }


  // newIntern(): void {
  //   this.submitted = false;
  //   this.addNewVehicleTest = new Registervehicledto();
  // }
  save() {
    this.vehiclemanagementservice.registervehicle(this.addNewVehicleTest)
      .subscribe(data => {console.log(data); this.submit = true}, 
      error => { this.errorMessage=error;
        this.ifError=true;this.submitted=false});
        console.log(this.errorMessage);
    this.addNewVehicleTest = new Registervehicledto();
  }

  onSubmit(data:any) {
    this.submitted = true;
    this.addNewVehicleTest.registrationNo=data.registrationNo;
    this.addNewVehicleTest.belongsToUserId=data.belongsToUserId;
    this.addNewVehicleTest.vehicleTypeId=data.vehicleTypeId;
    this.addNewVehicleTest.rtoname=data.rtoname;
    this.addNewVehicleTest.registrationDate=data.registrationDate;
    this.addNewVehicleTest.rcdocurl=data.rcdocurl;
    this.addNewVehicleTest.insuranceCompanyName=data.insuranceCompanyName;
    this.addNewVehicleTest.insuraceNo=data.insuraceNo;
    this.addNewVehicleTest.insurancedOn=data.insurancedOn
    this.addNewVehicleTest.insuranceCertificateDOCURL=data.insuranceCertificateDOCURL;
    this.addNewVehicleTest.puccertificateno=data.puccertificateno;
    this.addNewVehicleTest.pucissuedon=data.pucissuedon;
    this.addNewVehicleTest.pucdocurl=data.pucdocurl;
    this.save();
  }
  get registrationNo():FormControl{
    return this.formData.get('registrationNo');
  }
  get belongsToUserId():FormControl
  {
    return this.formData.get('belongsToUserId')
  }
  get vehicleTypeId():FormControl
  {
    return this.formData.get('vehicleTypeId')
  }
  get rtoname():FormControl
  {
    return this.formData.get('rtoname')
  }
  get registrationDate():FormControl
  {
    return this.formData.get('registrationDate')
  }
  get rcdocurl():FormControl
  {
    return this.formData.get('rcdocurl')
  }
  get insuranceCompanyName():FormControl
  {
    return this.formData.get('insuranceCompanyName')
  }
  get insuraceNo():FormControl
  {
    return this.formData.get('insuraceNo')
  }
  get insurancedOn():FormControl
  {
    return this.formData.get('insurancedOn')
  }
  get insuranceCertificateDOCURL():FormControl
  {
    return this.formData.get('insuranceCertificateDOCURL')
  }
  get puccertificateno():FormControl
  {
    return this.formData.get('puccertificateno')
  }
  get pucissuedon():FormControl
  {
    return this.formData.get('pucissuedon')
  }
  get pucdocurl():FormControl
  {
    return this.formData.get('pucdocurl')
  }

  maxDate(){
    return new Date().toISOString().split('T')[0];
  }
}