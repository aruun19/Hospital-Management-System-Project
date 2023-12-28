import { Component, OnInit } from '@angular/core';
import { PatiserviceService } from '../service/patiservice.service';
import { Patient } from '../model/Patient';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit{
  patient: Patient=new Patient(0,"","","","","","","","");
  
  constructor(private pservice:PatiserviceService,private router:Router){}
  ngOnInit(): void {
    
  }
  onSubmit()
  {
    console.log("data",this.patient);
    
      this.pservice.signupPatient(this.patient).subscribe((data: any) =>{
      if(data.status=="success")
      alert("you have registered Successfully!! Please login again");
      this.router.navigateByUrl("/plogin")});
     
  }



}

