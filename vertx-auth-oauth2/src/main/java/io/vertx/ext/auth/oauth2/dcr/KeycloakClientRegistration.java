package io.vertx.ext.auth.oauth2.dcr;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.ext.auth.oauth2.ClientRegistrationProvider;
import io.vertx.ext.auth.oauth2.DCRRequest;
import io.vertx.ext.auth.oauth2.DCRResponse;
import io.vertx.ext.auth.oauth2.dcr.impl.KeycloakClientRegistrationImpl;

public interface KeycloakClientRegistration extends ClientRegistrationProvider {

  static DCRResponse create(Vertx vertx, DCRRequest dcrRequest) {
    return new KeycloakClientRegistrationImpl(vertx, new HttpClientOptions()).create(dcrRequest);
  }
}
