export class Doctor {
    dId:number;
    dname:string;
    specilization:string;
    city:string;
    contactno:number;
    availableTime:string;   
    username:string;
    password:string;
    department:string;

    constructor(dId:number, dname:string,specilization:string,city:string, contactno:number,username:string,password:string,availableTime:string,department:string)
    {
        this.dId=dId;
        this.dname=dname;
        this.specilization=specilization;
        this.department=department;
        this.city=city;
        this.contactno=contactno;
        this.username=username;
        this.password=password;
        this.availableTime=availableTime;
       

       
    }

}
