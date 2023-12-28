import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../Hospital.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  password:any;
  username:any;
  result:any;

  constructor(private service:HospitalService,private router:Router) { }

  ngOnInit() {

  }



  checkLogin(username:string,password:string){
    console.log("username and password is"+username+password)
    this.service.checkLogin(username,password).subscribe(data=>{
      this.result=data;
      console.log("result",this.result);
      if(this.result.status==="success"){
        alert("You have Successfully Loggedin!")
        this.router.navigate(['/admin-details'])
      }
    });
  }

}
