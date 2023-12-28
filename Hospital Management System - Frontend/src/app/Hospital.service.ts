import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  constructor(private http:HttpClient) { }

  checkLogin(username:string,pwd:string){
    let adminData={
      "username":username,
      "adminpassword":pwd
    }
    return this.http.post("http://localhost:8080/admin/login/",adminData);
}

getAllDoctors(){
  
  return this.http.get("http://localhost:8080/doct/list");


}





}
