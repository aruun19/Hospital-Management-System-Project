import { Component } from '@angular/core';
import { PatiserviceService } from '../service/patiservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-login',
  templateUrl: './patient-login.component.html',
  styleUrl: './patient-login.component.css'
})
export class PatientLoginComponent {
  password:any;
  username:any;
  result:any;

  constructor(private service:PatiserviceService,private router:Router) { }

  ngOnInit() {

  }
  checkPatientLogin(username:string,password:string){
    console.log("username and password is"+username+" "+password)
    this.service.checkPatientLogin(username,password).subscribe(data=>{
      this.result=data;
      console.log("result",this.result);
      if(this.result.status==="success"){
        localStorage.setItem("pid",this.result.pid);
        alert("You have Successfully Logedin!")
        this.router.navigate(['/book-doctor'])
      }
    });
  }
  signupPatient(){
    this.router.navigateByUrl("/signupform");
  }

}
