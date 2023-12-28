import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../model/Payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  [x: string]: any;

    getPaymenyBypId(searchName: any){
        throw new Error('Method not implemented.');
    }
    private paymentlisturl="http://localhost:8080/Payment/list";
    private paymentsaveurl="http://localhost:8080/Payment/addpayment";
    private paymentdeleteurl="http://localhost:8080/Payment/delete";
    private paymentfindIdurl="http://localhost:8080/Payment/find";

  constructor(private http:HttpClient) { }

  getAllPAyment():Observable<any>
    {
      return this.http.get(this.paymentlisturl); 
     }

     getPaymentByID(paymentId:number):Observable<Payment>
  {
    const dIDURl=this.paymentfindIdurl+"/"+paymentId;
    return  this.http.get<Payment>(dIDURl);
  }

  SavePayment(payment:Payment):Observable<any>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.post<Payment>(this.paymentsaveurl,payment,httpOptions);
  }

  deletePayment(paymentId: number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Payment>(this.paymentdeleteurl+`/${paymentId}`,httpOptions);
  }
}
