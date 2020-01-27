import { KeycloakConfig, KeycloakInitOptions, KeycloakOptions } from 'keycloak-angular';

const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:8180/auth',
  realm: 'myshop-realm',
  clientId: 'myshop-web'
};

const keycloakInitOptions: KeycloakInitOptions = {
  onLoad: 'check-sso', // 'login-required',
  checkLoginIframe: false
};

const keycloakOptions: KeycloakOptions = {
  config: keycloakConfig,
  initOptions: keycloakInitOptions,
  enableBearerInterceptor: true
  // bearerExcludedUrls: ['/']
};

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080',
  keycloak: keycloakOptions
};
