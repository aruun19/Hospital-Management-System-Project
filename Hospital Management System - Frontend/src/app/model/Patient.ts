export class Patient
{
    pId: number; 
    pName: string;
    diseaseName: string;
    contactNumber: string;
    gender: string;
    address: string;
    username: string;
    password: string;
    email: string;
    
    constructor(pId:number, pName:string,diseaseName:string,contactNumber:string,gender:string,address:string,username:string,password:string,email:string)
    {
        this.pId=pId;
        this.pName=pName;
        this.diseaseName=diseaseName;
        this.contactNumber=contactNumber;
        this.gender=gender;
        this.address=address;
        this.username=username;
        this.password=password;
        this.email=email;
    }

}
