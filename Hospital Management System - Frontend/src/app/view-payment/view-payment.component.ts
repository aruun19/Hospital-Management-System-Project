import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../service/payment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-payment',
  templateUrl: './view-payment.component.html',
  styleUrl: './view-payment.component.css'
})
export class ViewPaymentComponent implements OnInit{
  payment: any;
  hasSearchName: any;
  searchName: any;
  p:number=1;
  count:number=5;

  constructor(
    private paymentService: PaymentService,
    private router: Router,
    private activateRoute: ActivatedRoute
  ) {}
ngOnInit(): void {
  this.activateRoute.paramMap.subscribe(() => this.getAllPayment());
}
  getAllPayment() {
    /* this.hasSearchName = this.activateRoute.snapshot.paramMap.has("paymentId");
    if(this.hasSearchName)
    {
     this.searchName  = this.activateRoute.snapshot.paramMap.get("paymentId");
     console.log(this.searchName)
   this.paymentService.getPaymentByID(this.searchName).subscribe(data=>{
     console.log(data);
     this.payment= data;
   })
 }
 else{ */

 
 this.paymentService.getAllPAyment().subscribe(data=>{
   console.log("data",data);
   this.payment=data;
 });

}

addpayment() {
  this.router.navigateByUrl("/paymentform");
}

deletepayment(id: number) {
  console.log(id);
  if (confirm("Do you want to delete?")) {
    this.paymentService.deletePayment(id).subscribe((data: any) => {
      console.log(data);
      this.getAllPayment();
    });
  }
}

}
