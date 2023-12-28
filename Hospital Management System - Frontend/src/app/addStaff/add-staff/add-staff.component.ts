import { Component, OnInit } from '@angular/core';
import { Staff } from '../../model/staff';
import { StaffService } from '../../service/staff.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrl: './add-staff.component.css'
})
export class AddStaffComponent implements OnInit {
  staff:Staff =new Staff(0,"","",0,0,new Date(),"","","");
  isEditable!: boolean;
  constructor(private staffService:StaffService,private router:Router,private activateRoute:ActivatedRoute) { }
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.staff);
    this.getStaffById();
  }
 
  onSubmit()
{
  console.log(this.staff);
  if(this.isEditable){
    this.staffService.updateStaff(this.staff).subscribe(data=>
      this.router.navigateByUrl("/stafflist"));

  }
  else{

  
  this.staffService.SaveStaff(this.staff).subscribe(data =>
    console.log(data));
    this.router.navigateByUrl("/stafflist");
}}

getStaffById() {
  const sId  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));

console.log(sId);
if(sId > 0)
{
  this.isEditable = true;
  this.staffService.getStaffByID(sId).subscribe(data=>{
    this.staff = data;
    console.log(this.staff)
  });
}
}
}


