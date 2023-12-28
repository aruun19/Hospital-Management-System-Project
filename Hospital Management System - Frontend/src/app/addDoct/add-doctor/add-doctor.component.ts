import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../model/doctor';
import { ActivatedRoute,Router } from '@angular/router';
import { DoctorService } from '../../service/doctor.service';
import { identifierName } from '@angular/compiler';


@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrl: './add-doctor.component.css'
})
export class AddDoctorComponent implements OnInit{
  doctor:Doctor =new Doctor(0,"","","",0,"","","","");
  isEditable!: boolean;
  constructor(private doctService:DoctorService,private router:Router,private activateRoute:ActivatedRoute) { }
ngOnInit(): void {
  this.activateRoute.paramMap.subscribe(()=>this.doctor);
  this.getDoctorById();
}
onSubmit()
{
  console.log(this.doctor);
  if(this.isEditable){
    this.doctService.updateDoctor(this.doctor).subscribe(data=>
      this.router.navigateByUrl("/doctlist"));

  }
  else{

  
  this.doctService.SaveDoctor(this.doctor).subscribe(data =>
    console.log(data));
    this.router.navigateByUrl("/doctlist");
}}

getDoctorById(){
  const dId  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));

console.log(dId);
if(dId > 0)
{
  this.isEditable = true;
  this.doctService.getDoctorByID(dId).subscribe(data=>{
    this.doctor = data;
    console.log(this.doctor)
  });
}
}


}
