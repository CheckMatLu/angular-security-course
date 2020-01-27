import { TestBed } from '@angular/core/testing';

import { KeycloakUtilsService } from './keycloak-utils.service';

describe('KeycloakUtilsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KeycloakUtilsService = TestBed.get(KeycloakUtilsService);
    expect(service).toBeTruthy();
  });
});
