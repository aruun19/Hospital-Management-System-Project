import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatiserviceService } from '../service/patiservice.service';
import { Patient } from '../model/Patient';

@Component({
  selector: 'app-addpatient',
  templateUrl: './addpatient.component.html',
  styleUrl: './addpatient.component.css'
})
export class AddpatientComponent implements OnInit {
  isEditable: boolean;
  patient: Patient=new Patient(0,"","","","","","","","");

  constructor(private router: Router, private activateRoute: ActivatedRoute, private pservice: PatiserviceService) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(() => this.patient);
    this.getPatientById();
  }

  getPatientById() {
    const pId = parseFloat(this.activateRoute.snapshot.paramMap.get("id"));
    if (pId > 0) {
      this.isEditable = true;
      this.pservice.getPatientByID(pId).subscribe(data => {
        this.patient = data;
        console.log(this.patient)
      });
    }
  }

  onSubmit()
  {
    console.log(this.patient);
    if(this.isEditable){
      this.pservice.updatePatient(this.patient).subscribe(data=>
        this.router.navigateByUrl("/patient-details"));

    }
    else{
      this.pservice.SavePatient(this.patient).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/patient-details");
  }}

}
