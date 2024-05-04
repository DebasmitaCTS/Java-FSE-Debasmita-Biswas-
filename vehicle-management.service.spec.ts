import { TestBed } from '@angular/core/testing';

import { VehicleManagementService } from './vehicle-management.service';

describe('VehicleManagementService', () => {
  let service: VehicleManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
