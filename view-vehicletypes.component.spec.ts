import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVehicletypesComponent } from './view-vehicletypes.component';

describe('ViewVehicletypesComponent', () => {
  let component: ViewVehicletypesComponent;
  let fixture: ComponentFixture<ViewVehicletypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewVehicletypesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewVehicletypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
