import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../model/Patient';
import { Doctor } from '../model/doctor';

@Injectable({
  providedIn: 'root'
})
export class PatiserviceService {
  private patlisturl="http://localhost:8080/Patient/list";
  private patsaveurl="http://localhost:8080/Patient/addpatient";
  private patdeleteurl="http://localhost:8080/Patient/delete";
  private patfindIdurl="http://localhost:8080/Patient/find";
  private patUpdate="http://localhost:8080/Patient/update";
  private patsearch="http://localhost:8080/Patient/search";
  private patapp="http://localhost:8080/Patient/viewpatientAppointments";
  private patsignup="http://localhost:8080/Patient/signup"

  constructor(private http:HttpClient) { }
  getAllPatient():Observable<any>
  {
    return this.http.get(this.patlisturl); 
   }

   SavePatient(patient:Patient):Observable<any>
   {
     const httpOptions = {
       headers : new HttpHeaders({
           'Content-Type' : 'application/json',
           'Authorization' : 'auth-token',
           'Access-Control-Allow-Origin' : '*'
       })
     };
     return  this.http.post<Patient>(this.patsaveurl,patient,httpOptions);
   }
   deletePatient(pId: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Patient>(this.patdeleteurl+`/${pId}`,httpOptions);
  }
  getPatientByID(id:number):Observable<Patient>
  {
    const patIDURl=this.patfindIdurl+"/"+id;
    return  this.http.get<Patient>(patIDURl);
  }
  updatePatient(patient:Patient):Observable<any>
  {
    const headers={'content-type':'application/json'};
    const body=JSON.stringify(patient);
    return this.http.put(this.patUpdate,body,{'headers':headers});
  }
  getPatientByPname(pname:any):Observable<Patient>
  {
    const searchURL =   "http://localhost:8080/Patient/search/findByPnameIgnoreCase?pname=" + pname;
  
    return  this.http.get<Patient>(searchURL);
  } 

  checkPatientLogin(username:string,pwd:string){
    let patientData={
      "username":username,
      "password":pwd
    }
    return this.http.post("http://localhost:8080/Patient/login",patientData);
}
signupPatient(patient:Patient){
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.http.post<Patient>(this.patsignup,patient,httpOptions);

}

bookDoctor(did: number,pid: number){
  let data={
    "patientId":pid,
    "doctorId":did
  }
  const httpOptions = {
    headers : new HttpHeaders({
      'Access-Control-Allow-Origin' : 'http://localhost:4200/',
      'Content-Type' : 'application/json',
      'Authorization' : 'auth-token'
       

  })
};

  return this.http.post("http://localhost:8080/BookingDoctor/savebooking",data,httpOptions);
}
viewApp(pId: Number):Observable<any>{
  const patappoint=this.patapp+"/"+pId;
    return  this.http.get<any>(patappoint);
  
}
}





