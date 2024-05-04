import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { UserDTO } from '../datatransferobject/user-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  constructor(private http:HttpClient) { }
  authenticatedUrl: string = "http://localhost:8077/authenticate";
  authentiCatedUser !: UserDTO;
  authentiCatedUserBacked! : UserDTO;
  authenticated !: boolean;

  getAuthenticatedUser(user:UserDTO){
    return firstValueFrom(this.http.post<UserDTO>(this.authenticatedUrl,user));
  }

  async authenticate(userName:string, password:string){
    this.authentiCatedUser = new UserDTO();
    this.authentiCatedUser.userName = userName;
    this.authentiCatedUser.password = password;

  // this.authentiCatedUserBacked = await this.getAuthenticatedUser(this.authentiCatedUser)

  if(this.authentiCatedUser.userName === "Debasmita" && this.authentiCatedUser.password === "25102000"){
    this.authenticated = true;
    sessionStorage.setItem('username',this.authentiCatedUser.userName);
  }
  else{
    this.authenticated = false;
  }
  return this.authenticated;
}
  isUserLoggedIn(){
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

  logOut(){
    sessionStorage.removeItem('username');
  }
}
