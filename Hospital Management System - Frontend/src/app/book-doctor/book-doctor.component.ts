import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../service/doctor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PatiserviceService } from '../service/patiservice.service';

@Component({
  selector: 'app-book-doctor',
  templateUrl: './book-doctor.component.html',
  styleUrl: './book-doctor.component.css'
})
export class BookDoctorComponent implements OnInit{
  result:any;
  doctor: any;
  hasSearchName: any;
  searchName: string;
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
    this.hasSearchName = this.activateRoute.snapshot.paramMap.has("dname");
    if(this.hasSearchName)
    {
     this.searchName  = this.activateRoute.snapshot.paramMap.get("dname");
     console.log(this.searchName)
   this.doctorService.getDoctorByDname(this.searchName).subscribe((data: any)=>{
     console.log(data);
     this.doctor= data;
   })
 }
 else{

 
 this.doctorService.getAllDoctor().subscribe((data: any)=>{
   console.log(data);
   this.doctor=data;
 });
}
  }
  viewAppointments(){
   
        this.router.navigateByUrl("/viewappointments");

      
  }

  book(did:number){
    let pid=localStorage.getItem("pid");
    console.log(pid);
    this.pservice.bookDoctor(did,parseInt(pid)).subscribe(data=>{
      this.result=data;
      if(this.result.status=="success"){
        alert("doctor booked successfully!");
        this.router.navigateByUrl("/paymentform")
      }
    })
  }
  logout(){
    if (confirm("Are you sure to logout?")) {
      this.router.navigateByUrl("/plogin")
      
    }
    
  }

}
