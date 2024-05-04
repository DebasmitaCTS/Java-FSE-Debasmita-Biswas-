import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../Service/authentication-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  invalidCredentials = true;
  authenticated : boolean = false;
  constructor(private router : Router, private authenticateUsersService:AuthenticationServiceService){}

  loginForm !: FormGroup;

  ngOnInit() : void{
    // this.authenticated = sessionStorage.getItem("authenticated");
    // this.router.navigate(['login']);
    this.loginForm = new FormGroup(
      {
        userName : new FormControl('',[Validators.required]),
        password : new FormControl('',[Validators.required]),
      }
    )
  }

  authenticateUser(){
    return this.authenticateUsersService.authenticate(this.loginForm.get('userName')?.value, this.loginForm.get('password')?.value)
  }
  async checkLogin(){
    // this.router.navigate(['home']);
    let valid =await this.authenticateUser();
    console.log(valid);
   if(valid){
    console.log(this.loginForm.get('userName')?.value);
    console.log(this.loginForm.get('password')?.value)
    sessionStorage.setItem('authenticated','true');
    this.router.navigate(['navigation']);
    // this.loginForm = new FormGroup(
    //   {
    //     userName : new FormControl('',[Validators.required]),
    //     password : new FormControl('',[Validators.required]),
    //   }
    // )
   }
   else{
    this.invalidCredentials = false;
    console.log("fef");
   }
   }
}
