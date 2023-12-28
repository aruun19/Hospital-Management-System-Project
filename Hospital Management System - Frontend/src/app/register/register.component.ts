import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Doctor } from '../model/doctor';
import { DoctorService } from '../service/doctor.service';
import { Patient } from '../model/Patient';
import { PatiserviceService } from '../service/patiservice.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{
  patient: Patient=new Patient(0,"","","","","","","","");


SaveUsers() {
throw new Error('Method not implemented.');
}
Doctor: Doctor = new Doctor(0, "dName", "specialization", "City", 0, "username", "passwars", "availabletime", "department");
  isEditable: any;

  user: any;
  constructor(private doctorService: DoctorService, private router: Router, private pservice: PatiserviceService) { }

ngOnInit(): void {
}

  SavePatients() {
    if (this.isEditable) {
      this.doctorService.updateDoctor(this.Doctor).subscribe((data: any) => {
        alert("Successfully updated " + this.Doctor.dname);
        sessionStorage.clear();
        localStorage.clear();
        this.router.navigateByUrl("");
      });
    } else {
      this.doctorService.updateDoctor(this.Doctor).subscribe((data: any) => {
          alert("Successfully Register ");
          this.router.navigateByUrl("/login");
        },
        (error: any) => alert("enter the Doctor data ")
      );
    }
  }

  onSubmit()
  {
   
  
      this.pservice.SavePatient(this.patient).subscribe((data: any) =>
      console.log(data));
      this.router.navigateByUrl("/plogin");

}

}
