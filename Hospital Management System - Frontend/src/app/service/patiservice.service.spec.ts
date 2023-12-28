import { TestBed } from '@angular/core/testing';

import { PatiserviceService } from './patiservice.service';

describe('PatiserviceService', () => {
  let service: PatiserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatiserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
