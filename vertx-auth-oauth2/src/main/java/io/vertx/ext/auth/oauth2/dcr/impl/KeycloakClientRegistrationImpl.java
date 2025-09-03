package io.vertx.ext.auth.oauth2.dcr.impl;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.auth.impl.http.SimpleHttpClient;
import io.vertx.ext.auth.impl.http.SimpleHttpResponse;
import io.vertx.ext.auth.oauth2.DCROptions;
import io.vertx.ext.auth.oauth2.DCRRequest;
import io.vertx.ext.auth.oauth2.DCRResponse;
import io.vertx.ext.auth.oauth2.dcr.KeycloakClientRegistration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class KeycloakClientRegistrationImpl implements KeycloakClientRegistration {

  private final Vertx vertx;
  private final SimpleHttpClient simpleHttpClient;

  private final DCROptions dcrOptions;

  public KeycloakClientRegistrationImpl(Vertx vertx, DCROptions dcrOptions) {
    this.vertx = vertx;
    this.dcrOptions = dcrOptions;
    this.simpleHttpClient = new SimpleHttpClient(vertx, "dcr-client",
      dcrOptions.getHttpClientOptions());
  }

  @Override
  public DCRResponse create(DCRRequest dcrRequest) throws TimeoutException {
    final Future<SimpleHttpResponse> response = simpleHttpClient.fetch(HttpMethod.POST,
      dcrOptions.resourceUri(), dcrOptions.bearerToken(), dcrRequest.toJson().toBuffer());
    final SimpleHttpResponse simpleHttpResponse = response.await(30, TimeUnit.SECONDS);
    return new DCRResponse(simpleHttpResponse.body().toJsonObject());
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
