package io.vertx.ext.auth.oauth2.dcr;

import io.vertx.core.Vertx;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.oauth2.ClientRegistrationProvider;
import io.vertx.ext.auth.oauth2.DCRRequest;
import io.vertx.ext.auth.oauth2.DCRResponse;
import io.vertx.ext.auth.oauth2.dcr.impl.KeycloakClientRegistrationImpl;

public interface KeycloakClientRegistration extends ClientRegistrationProvider {

  static DCRResponse create(Vertx vertx, TokenCredentials tokenCredentials, DCRRequest dcrRequest) {
    return new KeycloakClientRegistrationImpl(vertx, tokenCredentials).create(dcrRequest);
  }
}
