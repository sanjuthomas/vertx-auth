package io.vertx.ext.auth.dcr;

import io.vertx.ext.auth.DCRRequest;
import io.vertx.ext.auth.DCRResponse;
import io.vertx.ext.auth.authentication.TokenCredentials;

public class KeycloakClientRegistrationProvider implements ClientRegistrationProvider {

  private final DCRRequest request;
  private final TokenCredentials tokenCredentials;

  public KeycloakClientRegistrationProvider(DCRRequest request, TokenCredentials tokenCredentials) {
    this.request = request;
    this.tokenCredentials = tokenCredentials;
  }

  @Override
  public DCRResponse create(DCRRequest dcrRequest) {
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
