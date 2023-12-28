export class Staff {
    sId:number;
    sName:string;
    jobrole:string;
    salary:number;
    exp:number;
    doj:Date;
    qualification:string;
    contact:string;
    address:string;

    constructor(sId:number, sName:string,jobrole:string,salary:number, exp:number,doj:Date,qualification:string,contact:string, address:string)
    {
        this.sId=sId;
        this.sName=sName;
        this.jobrole=jobrole;
        this.salary=salary;
        this.exp=exp;
        this.doj=doj;
        this.qualification=qualification;
        this.contact=contact;
        this.address=address;
    }
}
