import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateInspectionStatusComponent } from './update-inspection-status.component';

describe('UpdateInspectionStatusComponent', () => {
  let component: UpdateInspectionStatusComponent;
  let fixture: ComponentFixture<UpdateInspectionStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateInspectionStatusComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateInspectionStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
