package io.vertx.ext.auth.oauth2;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.http.HttpClientOptions;

@DataObject
@JsonGen(publicConverter = false)
public final class DCROptions {

  /**
   * The base url of the OIDC provider like Keycloak.
   */
  private String site;

  /**
   * Name of the tenant if any. Keycloak call this realm.
   */
  private String tenant;

  /**
   * Client registration operations path.
   * In Keycloak it's clients-registrations/default
   */
  private String path;


  /**
   * Initial access token to authenticate with the OIDC provider.
   */
  private String initialAccessToken;


}
