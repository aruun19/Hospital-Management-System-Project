import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDoctComponent } from './view-doct.component';

describe('ViewDoctComponent', () => {
  let component: ViewDoctComponent;
  let fixture: ComponentFixture<ViewDoctComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewDoctComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewDoctComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
