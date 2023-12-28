import { HttpClient,HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Staff } from "../model/staff";
import { splitNsName } from "@angular/compiler";




@Injectable({
    providedIn: 'root'
  })
  

export class StaffService {
    getStaffBysName(searchName: any){
        throw new Error('Method not implemented.');
    }
    private stafflisturl="http://localhost:8080/Staff/list";
    private staffsaveurl="http://localhost:8080/Staff/addstaff";
    private staffdeleteurl="http://localhost:8080/Staff/delete";
    private stafffindIdurl="http://localhost:8080/Staff/find";
    private staffUpdate="http://localhost:8080/Staff/update";
    private staffsearch="http://localhost:8080/Staff/search";

    constructor(private http:HttpClient) { }

    getAllStaff():Observable<any>
    {
      return this.http.get(this.stafflisturl); 
     }

     SaveStaff(staff:Staff):Observable<any>
   {
     const httpOptions = {
       headers : new HttpHeaders({
           'Content-Type' : 'application/json',
           'Authorization' : 'auth-token',
           'Access-Control-Allow-Origin' : '*'
       })
     };
     return  this.http.post<Staff>(this.staffsaveurl,staff,httpOptions);
   }
   deleteStaff(sId: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.http.delete<Staff>(this.staffdeleteurl+`/${sId}`,httpOptions);
  }

  getStaffByID(sId1:number):Observable<Staff>
  {
    const dIDURl=this.stafffindIdurl+"/"+sId1;
    return  this.http.get<Staff>(dIDURl);
  }
  updateStaff(staff:Staff):Observable<any>
  {
    const headers={'content-type':'application/json'};
    const body=JSON.stringify(staff);
    return this.http.put(this.staffUpdate,body,{'headers':headers});
  }
  getStaffBySName(sName:any):Observable<Staff>
  {
    const searchURL =   "http://localhost:8080/staff/search/findBysNameIgnoreCase?sName=" + sName;
  
    return  this.http.get<Staff>(searchURL);
  }
}

