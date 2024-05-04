import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewVehicleComponent } from './add-new-vehicle.component';

describe('AddNewVehicleComponent', () => {
  let component: AddNewVehicleComponent;
  let fixture: ComponentFixture<AddNewVehicleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddNewVehicleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddNewVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
