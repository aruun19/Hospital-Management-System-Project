import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPaymemtComponent } from './add-paymemt.component';

describe('AddPaymemtComponent', () => {
  let component: AddPaymemtComponent;
  let fixture: ComponentFixture<AddPaymemtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddPaymemtComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddPaymemtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
