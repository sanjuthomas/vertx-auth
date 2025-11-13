/*
 * Copyright (c) 2025 Sanju Thomas
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */
package io.vertx.ext.auth.oauth2;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
@JsonGen(publicConverter = false)
public class DCRResponse {

  private final JsonObject data;

  public DCRResponse() {
    this.data = new JsonObject();
  }

  public DCRResponse(DCRResponse other) {
    this.data = other == null ? new JsonObject() : other.data.copy();
  }

  public DCRResponse(JsonObject json) {
    this.data = json == null ? new JsonObject() : json.copy();
  }

  public JsonObject toJson() {
    return data.copy();
  }

  public Object get(String key) {
    return data.getValue(key);
  }

  public String getString(String key) {
    return data.getString(key);
  }

  public Boolean getBoolean(String key) {
    return data.getBoolean(key);
  }

  public Number getNumber(String key) {
    Object n = get(key);
    return (n instanceof Number) ? (Number) n : null;
  }

  public JsonObject getObject(String key) {
    return data.getJsonObject(key);
  }

  public JsonArray getArray(String key) {
    return data.getJsonArray(key);
  }

  public JsonObject asJson() {
    return data.copy();
  }

  public String getId() {
    return data.getString("id");
  }

  public String getClientId() {
    return data.getString("clientId");
  }

  public String getSecret() {
    return data.getString("secret");
  }

  public String getRegistrationAccessToken() {
    return data.getString("registrationAccessToken");
  }

  public Boolean isEnabled() {
    return data.getBoolean("enabled");
  }

  public JsonArray getRedirectUris() {
    return data.getJsonArray("redirectUris");
  }

  public JsonObject getDefaultClientScopes() {
    return data.getJsonObject("defaultClientScopes");
  }

  public String getClientAuthenticatorType() {
    return data.getString("clientAuthenticatorType");
  }

}
