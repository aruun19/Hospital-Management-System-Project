import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../service/doctor.service';


@Component({
  selector: 'app-view-doct',
  templateUrl: './view-doct.component.html',
  styleUrl: './view-doct.component.css'
})
export class ViewDoctComponent implements OnInit{
  
  
  doctor: any;
  hasSearchName: any;
  searchName: string;
  status:boolean=false;
  p: number = 1;
  count: number = 5;

  
  constructor(
    private doctorService: DoctorService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    // Subscribe to changes in the route parameters
    /* if(localStorage.getItem("plogin")=="true")
    this.status=true; */
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
addDoct():void{
 this.router.navigateByUrl("/doctform");

}

updateDoctor(dId: number): void {
  this.router.navigateByUrl("/updateDoctor/" + dId);
}

deleteDoct(id: number): void {
  console.log(id);
  if (confirm("Do you want to delete?")) {
    this.doctorService.deleteDoctor(id).subscribe((data: any) => {
      console.log(data);
      this.getAllDoctor();
    });
  }
}


goBack(){
  this.router.navigateByUrl("/admin-details");
}
}

