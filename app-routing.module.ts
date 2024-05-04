import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewVehicleComponent } from './add-new-vehicle/add-new-vehicle.component';
import { HttpClientModule } from '@angular/common/http';
import { ViewVehicletypesComponent } from './view-vehicletypes/view-vehicletypes.component';
import { ViewVehiclesbyUseridComponent } from './view-vehiclesby-userid/view-vehiclesby-userid.component';
import { DeleteVehicleComponent } from './delete-vehicle/delete-vehicle.component';
import { ApproveRejectVehicleComponent } from './approve-reject-vehicle/approve-reject-vehicle.component';
import { UpdateInspectionStatusComponent } from './update-inspection-status/update-inspection-status.component';
import { AuthenticateAdminGuardService } from './Service/authenticate-admin-guard.service';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';
// import { LogoutComponent } from './logout/logout.component';
const routes: Routes = [
  { path : 'home',component : HomeComponent, canActivate:[AuthenticateAdminGuardService] },
  { path : 'login',component : LoginComponent },
  // { path : 'logout',component : LogoutComponent},
  { path : '', redirectTo : "login", pathMatch : "full" },
  {path:'AddNewVehicle',component: AddNewVehicleComponent},
  {path:'vehicletypes',component:ViewVehicletypesComponent},
  {path:'viewvehiclesbyuserid',component:ViewVehiclesbyUseridComponent},
  {path:'viewvehiclesbyuserid/DeleteVehicle',component:DeleteVehicleComponent},
  {path:'ApproveRejectVehicle',component:ApproveRejectVehicleComponent},
  {path:'ApproveRejectVehicle/updateInspectionStatus',component:UpdateInspectionStatusComponent},
  {path:'navigation',component:NavigationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
