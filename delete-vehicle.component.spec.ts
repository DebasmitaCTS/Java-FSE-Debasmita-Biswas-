import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteVehicleComponent } from './delete-vehicle.component';

describe('DeleteVehicleComponent', () => {
  let component: DeleteVehicleComponent;
  let fixture: ComponentFixture<DeleteVehicleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeleteVehicleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeleteVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
