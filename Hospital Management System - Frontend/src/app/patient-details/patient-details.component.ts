import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../Hospital.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PatiserviceService } from '../service/patiservice.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrl: './patient-details.component.css'
})
export class PatientDetailsComponent implements OnInit {
  [x: string]: any;
  patientData:any;
  patient:any;
  hasSearchName: any;
  searchName: any;
  p:number=1;
  count:number=5;
  constructor(private service:PatiserviceService,private router:Router,private activateRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.getAllPatient());
  }
     
    
  
  getAllPatient()
  {
    this.hasSearchName = this.activateRoute.snapshot.paramMap.has("pname");
       if(this.hasSearchName)
       {
        this.searchName  = this.activateRoute.snapshot.paramMap.get("pname");
        console.log(this.searchName)
      this.service.getPatientByPname(this.searchName).subscribe(data=>{
        console.log(data);
        this.patient= data;
      })
    }
    else{
  
    
    this.service.getAllPatient().subscribe(data=>{
      console.log(data);
      this.patient=data;
    });
  }
}
addPatient():void{
  this.router.navigateByUrl("/patientform");

}
updatePatient(id:number)
{
  this.router.navigateByUrl("/update/"+id);

}
deletePatient(id:number)
{
  console.log(id);
  if(confirm("Do you want to delete ?"))
  {
    this.service.deletePatient(id).subscribe(data=>{
      console.log(data);
      this.getAllPatient();
    })
  };
}
goBack(){
  this.router.navigateByUrl("/admin-details");
}
}


