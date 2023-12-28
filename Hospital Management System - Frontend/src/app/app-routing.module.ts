import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { WelcomeComponent } from './welcome/welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddpatientComponent } from './addpatient/addpatient.component';
import { ViewDoctComponent } from './view-doct/view-doct.component';
import { ViewStaffComponent } from './view-staff/view-staff.component';
import { AddDoctorComponent } from './addDoct/add-doctor/add-doctor.component';
import { AddStaffComponent } from './addStaff/add-staff/add-staff.component';
import { RegisterComponent } from './register/register.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { BookDoctorComponent } from './book-doctor/book-doctor.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';
import { SignupComponent } from './signup/signup.component';
import { ViewPaymentComponent } from './view-payment/view-payment.component';
import { AddPaymemtComponent } from './add-paymemt/add-paymemt.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomeComponent },
  { path: 'admin-details', component: AdminDetailsComponent },
  { path: 'login', component: LoginComponent },
  //{ path: 'doctor-details', component: DoctorDetailsComponent },
  { path: 'patient-details', component: PatientDetailsComponent },
  { path: 'update/:id', component: AddpatientComponent },
  { path: 'patientform', component: AddpatientComponent },
  { path: '', redirectTo: '/welcome', pathMatch: "full" },
  { path: 'doctlist', component: ViewDoctComponent },
  { path: 'doctform', component: AddDoctorComponent },
  { path: 'updateDoctor/:id', component: AddDoctorComponent },
  { path: 'search/:dname', component: ViewDoctComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'plogin', component: PatientLoginComponent },
  { path: 'stafflist', component: ViewStaffComponent },
  { path: 'staffform', component: AddStaffComponent },
  { path: 'updateStaff/:id', component: AddStaffComponent },
  { path: 'search/:sName', component: ViewStaffComponent },
  { path: 'book-doctor', component: BookDoctorComponent },
  { path: 'viewappointments', component: ViewAppointmentsComponent },
  { path: 'signupform', component: SignupComponent },
  { path: 'paymentlist', component: ViewPaymentComponent },
  { path: 'paymentform', component: AddPaymemtComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
