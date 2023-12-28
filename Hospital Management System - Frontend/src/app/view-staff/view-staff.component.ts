import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { StaffService } from '../service/staff.service';

@Component({
  selector: 'app-view-staff',
  templateUrl:   './view-staff.component.html',
  styleUrl: './view-staff.component.css'
})
export class ViewStaffComponent implements OnInit{
  staff: any;
  hasSearchName: any;
  searchName: string;
  p:number=1;
  count:number=5;

  constructor(
    private staffService: StaffService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {}
ngOnInit(): void {
  this.activateRoute.paramMap.subscribe(() => this.getAllStaff());
}
  getAllStaff(): void {
    this.hasSearchName = this.activateRoute.snapshot.paramMap.has("sName");
    if(this.hasSearchName)
    {
     this.searchName  = this.activateRoute.snapshot.paramMap.get("sName");
     console.log(this.searchName)
   this.staffService.getStaffBySName(this.searchName).subscribe(data=>{
     console.log(data);
     this.staff= data;
   })
 }
 else{

 
 this.staffService.getAllStaff().subscribe(data=>{
   console.log(data);
   this.staff=data;
 });
}
}


addstaff():void {
  this.router.navigateByUrl("/staffform");
}

updateStaff(sId: number): void {
  this.router.navigateByUrl("/updateStaff/" + sId);
}

deletestaff(id: number): void {
  console.log(id);
  if (confirm("Do you want to delete?")) {
    this.staffService.deleteStaff(id).subscribe((data: any) => {
      console.log(data);
      this.getAllStaff();
    });
  }
}
goBack(){
  this.router.navigateByUrl("/admin-details");
}
}
