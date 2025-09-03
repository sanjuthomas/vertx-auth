package io.vertx.ext.auth.oauth2;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.json.JsonObject;

@DataObject
@JsonGen(publicConverter = false)
public final class DCROptions {

  /**
   * The base url of the OIDC provider like Keycloak.
   */
  private final String site;

  /**
   * Name of the tenant if any. Keycloak call this realm.
   */
  private final String tenant;


  /**
   * Initial access token to authenticate with the OIDC provider.
   */
  private final String initialAccessToken;

  private HttpClientOptions httpClientOptions = new HttpClientOptions();

  public DCROptions(String site, String tenant, String initialAccessToken) {
    this.site = site;
    this.tenant = tenant;
    this.initialAccessToken = initialAccessToken;
  }

  public HttpClientOptions getHttpClientOptions() {
    return httpClientOptions;
  }

  public String resourceUri() {
    return String.format("%s/%s/%s", site, tenant, "clients-registrations/default/");
  }

  public JsonObject bearerToken() {
    return JsonObject.of("Authorization", String.format("Bearer %s", initialAccessToken));
  }

}
