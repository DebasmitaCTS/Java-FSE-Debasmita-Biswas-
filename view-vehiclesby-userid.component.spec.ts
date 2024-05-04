import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVehiclesbyUseridComponent } from './view-vehiclesby-userid.component';

describe('ViewVehiclesbyUseridComponent', () => {
  let component: ViewVehiclesbyUseridComponent;
  let fixture: ComponentFixture<ViewVehiclesbyUseridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewVehiclesbyUseridComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewVehiclesbyUseridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
