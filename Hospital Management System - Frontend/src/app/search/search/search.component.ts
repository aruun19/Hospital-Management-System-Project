import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent implements OnInit{
  dname: any
  constructor(private router:Router) { }
ngOnInit(): void {
}
search()
{
  this.router.navigateByUrl("/search/"+this.dname);
}


}
