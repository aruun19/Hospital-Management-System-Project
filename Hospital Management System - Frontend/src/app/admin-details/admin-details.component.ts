import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-details',
  templateUrl: './admin-details.component.html',
  styleUrl: './admin-details.component.css'
})
export class AdminDetailsComponent implements OnInit{
  constructor(private router:Router){}
  ngOnInit(): void {
    
  }
  logout(){
    if (confirm("Are you sure to logout?")) {
      this.router.navigateByUrl("/login")
      
    }
  }

}
