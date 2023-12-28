
import { Doctor } from './doctor';

describe('Doctor', () => {
  it('should create an instance', () => {
    // Provide appropriate values for the constructor parameters
    const DoctorInstance = new Doctor(
      1,             // Example ID
      'John Doe',    // Example name
      'Male',        // Example gender
      'Specialist',            // Example diseasename
      995624566,    // Example contact num
      'Sailu123',  // Example username                        
      'Sailaja1234@',            // Example password
      '10AM',  //available time
      'dept'  //dept num
      
    );

    expect(DoctorInstance).toBeTruthy();
  });
});


