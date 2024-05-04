import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Registervehicledto } from '../datatransferobject/Registervehicledto';
import { Vehiclesdto } from '../datatransferobject/vehiclesdto';
import { Vehicletypesdto } from '../datatransferobject/vehicletypesdto';
import { catchError, throwError } from 'rxjs';
const httpOption = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class VehicleManagementService {
  belongsToUserId!:number;
  registrationNo!: string;
  pageno!:number;
  private url ='http://localhost:8077/api';
  

    constructor(private http:HttpClient) { }
    public registervehicle(Vehicle: any){
      console.log("in api call");
      console.log(this.http.post<Registervehicledto>(this.url+"/vehicles/addvehicle",Vehicle));
      return this.http.post<Registervehicledto>(this.url+"/vehicles/addvehicle",Vehicle).pipe(
        catchError(this.handleError)
      );
    }

    public getVehicleById(Vehiclesdto: any){
          this.belongsToUserId=Vehiclesdto.belongsToUserId;
        return this.http.get<Vehiclesdto>(this.url+"/vehicle/"+this.belongsToUserId).pipe(
          catchError(this.handleError));
        }

        public getvehicletypes() {
               return this.http.get<Vehicletypesdto[]>(this.url+"/vehicles/vehicletypes");
              
            }

        public deletevehicle(Vehiclesdto: any){
           this.registrationNo=Vehiclesdto.registrationNo;
           this.belongsToUserId=Vehiclesdto.belongsToUserId;
              return this.http.delete<Vehiclesdto>(this.url+"/vehicles/delete/"+this.registrationNo+"/"+this.belongsToUserId).pipe(
                catchError(this.handleError));
            }

            public getregistrationNo(){
               return this.registrationNo;
            }
            public getbelongsToUserId(){
              return this.belongsToUserId;
            }

        public getbyPageNo(pageno:number){
          
          return this.http.get<Vehiclesdto>(this.url+"/vehicles/pendingapprovals/"+pageno).pipe(
            catchError(this.handleError));
        }

        public updateRegistration(Vehiclesdto: any){
          return this.http.put<Vehiclesdto>(this.url+"/vehicles/approveorreject",Vehiclesdto).pipe(
            catchError(this.handleError));
        }

        private handleError(error: HttpErrorResponse) {
 
          let message = '';
       
          if (error.status === 0) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error);
          } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong.
            console.error(`Backend returned code ${error.status}, body was: `, error.error);
            message = `${error.error}`;
           
          }
          // Return an observable with a user-facing error message.
          return throwError(() => new Error(message));
        }
}
