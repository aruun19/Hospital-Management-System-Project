import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../service/doctor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PatiserviceService } from '../service/patiservice.service';
import { Appointment, BookingDoctor } from '../model/appointment';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrl: './view-appointments.component.css'
})
export class ViewAppointmentsComponent implements OnInit {
  hasSearchName: boolean;
  searchName: string;
  doctor: any;
  result:BookingDoctor[];
  docList:Appointment[]=[];
  p:number=1;
  count:number=5;


  constructor(
    private doctorService: DoctorService,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private pservice: PatiserviceService
  ) {}

ngOnInit(): void {
  this.activateRoute.paramMap.subscribe(() => this.getAllDoctor());
}
getAllDoctor() {
  let pid=localStorage.getItem("pid");
  this.pservice.viewApp(parseInt(pid)).subscribe((data: any)=>{
    this.result=data;
    this.result.forEach(ele => {
      let app:Appointment=new Appointment(
      ele.bookingid,
      ele.doctor.dname,
      ele.doctor.specilization,
      ele.doctor.contactno
      )
      this.docList.push(app);
    }); 
    console.log(this.docList);
  })
}
goBack(){
  this.router.navigateByUrl("/book-doctor")
}

}
