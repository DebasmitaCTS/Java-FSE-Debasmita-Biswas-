import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddNewVehicleComponent } from './add-new-vehicle/add-new-vehicle.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ViewVehicletypesComponent } from './view-vehicletypes/view-vehicletypes.component';
import { ViewVehiclesbyUseridComponent } from './view-vehiclesby-userid/view-vehiclesby-userid.component';
import { DeleteVehicleComponent } from './delete-vehicle/delete-vehicle.component';
import { ApproveRejectVehicleComponent } from './approve-reject-vehicle/approve-reject-vehicle.component';
import { UpdateInspectionStatusComponent } from './update-inspection-status/update-inspection-status.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    AddNewVehicleComponent,
    NavigationComponent,
    ViewVehicletypesComponent,
    ViewVehiclesbyUseridComponent,
    DeleteVehicleComponent,
    ApproveRejectVehicleComponent,
    UpdateInspectionStatusComponent,
    LoginComponent,
    // LogoutComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
