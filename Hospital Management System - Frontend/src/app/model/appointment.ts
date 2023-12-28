import { Doctor } from "./doctor";

export class Appointment{
    bookingid:number;
    dname:string;
    specilization:string;
    contactno:number;

    constructor(bookingid:number, dname:string,specilization:string, contactno:number)
    {
        this.bookingid=bookingid;
        this.dname=dname;
        this.specilization=specilization;
        this.contactno=contactno;
       

       
    }
}

export class BookingDoctor{
    bookingid:number;
    doctor:Doctor;

    constructor(bookingid:number, doctor:Doctor)
    {
        this.bookingid=bookingid;
        this.doctor=doctor;
    }
}