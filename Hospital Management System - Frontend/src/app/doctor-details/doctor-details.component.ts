import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../Hospital.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrl: './doctor-details.component.css'
})
export class DoctorDetailsComponent implements OnInit{
  doctorData:any;

  constructor(private service:HospitalService){}

  ngOnInit() {
    this.service.getAllDoctors().subscribe(data=>{
      this.doctorData=data;
      console.log("doctor data",this.doctorData);
    })

  }

  addDoctor(){

  }


  deletedoctor(){

  }

}
