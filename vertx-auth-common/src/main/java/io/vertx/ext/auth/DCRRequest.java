package io.vertx.ext.auth;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;

@DataObject
@JsonGen(publicConverter = false)
public class DCRRequest {
  private String clientId;

  public DCRRequest(String clientId) {
    this.clientId = clientId;
  }

  public DCRRequest(JsonObject json) {
    DCRRequestConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    final JsonObject json = new JsonObject();
    DCRRequestConverter.toJson(this, json);
    return json;
  }

  public String getClientId() {
    return clientId;
  }
}
