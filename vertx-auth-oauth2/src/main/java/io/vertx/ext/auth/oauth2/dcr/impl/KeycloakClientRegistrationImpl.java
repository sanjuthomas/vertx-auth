package io.vertx.ext.auth.oauth2.dcr.impl;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.impl.http.SimpleHttpClient;
import io.vertx.ext.auth.oauth2.DCRRequest;
import io.vertx.ext.auth.oauth2.DCRResponse;
import io.vertx.ext.auth.oauth2.dcr.KeycloakClientRegistration;

public final class KeycloakClientRegistrationImpl implements KeycloakClientRegistration {
  private final Vertx vertx;
  private final SimpleHttpClient simpleHttpClient;

  public KeycloakClientRegistrationImpl(Vertx vertx, HttpClientOptions httpClientOptions) {
    this.vertx = vertx;
    this.simpleHttpClient = new SimpleHttpClient(vertx, "dcr-client", httpClientOptions);
  }

  @Override
  public DCRResponse create(DCRRequest dcrRequest) {
   // simpleHttpClient.fetch(HttpMethod.POST, )
    return null;
  }

  @Override
  public DCRResponse get(String clientId) {
    return null;
  }

  @Override
  public DCRResponse update(DCRRequest dcrRequest) {
    return null;
  }

  @Override
  public void delete(String clientId) {

  }
}
