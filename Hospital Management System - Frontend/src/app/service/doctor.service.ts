import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { Doctor } from "../model/doctor";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class DoctorService {
  getDoctorBydname(searchName: any) {
    throw new Error('Method not implemented.');
  }
    private doctlisturl="http://localhost:8080/doct/list";
  private doctsaveurl="http://localhost:8080/doct/plusdoct";
  private doctdeleteurl="http://localhost:8080/doct/delete";
  private doctfindIdurl="http://localhost:8080/doct/find";
  private doctUpdate="http://localhost:8080/doct/update";
  private doctsearch="http://localhost:8080/doct/search";

  constructor(private http:HttpClient) { }

  getAllDoctor():Observable<any>
  {
    return this.http.get(this.doctlisturl); 
   }

   SaveDoctor(doctor:Doctor):Observable<any>
   {
     const httpOptions = {
       headers : new HttpHeaders({
           'Content-Type' : 'application/json',
           'Authorization' : 'auth-token',
           'Access-Control-Allow-Origin' : '*'
       })
     };
     return  this.http.post<Doctor>(this.doctsaveurl,doctor,httpOptions);
   }
   deleteDoctor(dId: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Doctor>(this.doctdeleteurl+`/${dId}`,httpOptions);
  }
  getDoctorByID(dId1:number):Observable<Doctor>
  {
    const dIDURl=this.doctfindIdurl+"/"+dId1;
    return  this.http.get<Doctor>(dIDURl);
  }
  updateDoctor(doctor:Doctor):Observable<any>
  {
    const headers={'content-type':'application/json'};
    const body=JSON.stringify(doctor);
    return this.http.put(this.doctUpdate,body,{'headers':headers});
  }
  getDoctorByDname(dname:any):Observable<Doctor>
  {
    const searchURL =   "http://localhost:8080/doct/search/findByDnameIgnoreCase?dname=" + dname;
  
    return  this.http.get<Doctor>(searchURL);
  }
}
