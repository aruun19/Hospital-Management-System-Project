import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome/welcome.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddpatientComponent } from './addpatient/addpatient.component';
import { ViewDoctComponent } from './view-doct/view-doct.component';
import { AddDoctorComponent } from './addDoct/add-doctor/add-doctor.component';
import { SearchComponent } from './search/search/search.component';
import { RegisterComponent } from './register/register.component';
import { AddStaffComponent } from './addStaff/add-staff/add-staff.component';
import { SearchStaffComponent } from './search/search-staff/search-staff.component';
import { ViewStaffComponent } from './view-staff/view-staff.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { BookDoctorComponent } from './book-doctor/book-doctor.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';
import { SignupComponent } from './signup/signup.component';
import { ViewPaymentComponent } from './view-payment/view-payment.component';
import { AddPaymemtComponent } from './add-paymemt/add-paymemt.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    AdminDetailsComponent,
    LoginComponent,
    DoctorDetailsComponent,
    PatientDetailsComponent,
    AddpatientComponent,
    ViewDoctComponent,
    AddDoctorComponent,
    SearchComponent,
    RegisterComponent,
    AddStaffComponent,
    SearchStaffComponent,
    ViewStaffComponent,
    PatientLoginComponent,
    BookDoctorComponent,
    ViewAppointmentsComponent,
    SignupComponent,
    ViewPaymentComponent,
    AddPaymemtComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
