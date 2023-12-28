
import { Staff } from "./staff";

describe('staff', () => {
  it('should create an instance', () => {
    // Provide appropriate values for the constructor parameters
    const StaffInstance = new Staff(
      1,             // Example ID
      'John Doe',    // Example name
      'staff',        // Example jobrole
      25000,            // Example salary
      5,    // Example experience
      new Date(),  // Example Date                        
      '12th',            // Example qualification
      '9957281345',  //contact num
      'Chennai'  //dept address
      
    );

    expect(StaffInstance).toBeTruthy();
  });
});
