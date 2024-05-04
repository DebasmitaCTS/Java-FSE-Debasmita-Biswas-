import { TestBed } from '@angular/core/testing';

import { AuthenticateAdminGuardService } from './authenticate-admin-guard.service';

describe('AuthenticateAdminGuardService', () => {
  let service: AuthenticateAdminGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticateAdminGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
