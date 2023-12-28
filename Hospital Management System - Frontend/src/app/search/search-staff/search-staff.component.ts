import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-staff',
  templateUrl: './search-staff.component.html',
  styleUrl: './search-staff.component.css'
})
export class SearchStaffComponent implements OnInit{
  sName: any;
  constructor(private router:Router) { }
ngOnInit(): void {
}
searchstaff() {
  this.router.navigateByUrl("/search/"+this.sName);
}


}
