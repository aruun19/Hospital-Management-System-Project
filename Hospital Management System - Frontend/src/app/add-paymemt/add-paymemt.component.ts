import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../service/payment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Payment } from '../model/Payment';

@Component({
  selector: 'app-add-paymemt',
  templateUrl: './add-paymemt.component.html',
  styleUrl: './add-paymemt.component.css'
})
export class AddPaymemtComponent implements OnInit {
  payment:Payment =new Payment();
  isEditable!: boolean;
  //payment: any;
  constructor(private paymentService:PaymentService,private router:Router,private activateRoute:ActivatedRoute) { }
ngOnInit(): void {
  this.activateRoute.paramMap.subscribe(()=>this.payment);
  this.payment.consultationFee=500;
  this.getPaymentById();
  
}
onSubmit()
  {
    console.log(this.payment);
    let pid=localStorage.getItem("pid");
    this.payment.pId=parseInt(pid);
    if(this.isEditable){
      this.paymentService.SavePayment(this.payment).subscribe(data=>{
        //this.router.navigateByUrl("/paymentlist")
        console.log(data);
       
      });
  
    }
    else{
  
    
    this.paymentService.SavePayment(this.payment).subscribe(data =>
      console.log(data));
      alert("Payment Successfully done.Thank You!");
      this.router.navigateByUrl("plogin");
  }}


  getPaymentById() {
    const paymentId  = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));

    console.log(paymentId);
if(paymentId > 0)
{
  this.isEditable = true;
  this.paymentService.getPaymentByID(paymentId).subscribe(data=>{
    this.payment = data;
    console.log(this.payment)
  });
}
}

}
