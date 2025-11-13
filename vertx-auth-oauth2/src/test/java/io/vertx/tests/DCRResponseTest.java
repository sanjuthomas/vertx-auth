package io.vertx.tests;

import io.vertx.core.json.JsonArray;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import io.vertx.core.json.JsonObject;

import io.vertx.ext.auth.oauth2.DCRResponse;


public class DCRResponseTest {

  private static final String DCR_RESPONSE_STRING = "{\n"
    + "    \"id\": \"f3660894-1efc-4f4d-9de3-c92340cd1dc3\",\n"
    + "    \"clientId\": \"my-client-id\",\n"
    + "    \"enabled\": true,\n"
    + "    \"clientAuthenticatorType\": \"client-secret\",\n"
    + "    \"secret\": \"my-secret\",\n"
    + "    \"registrationAccessToken\": \"my-registration-access-token\",\n"
    + "    \"defaultRoles\": [],\n"
    + "    \"redirectUris\": [\"https://app.example.com/callback\",\n"
    + "    \"https://app.example.com/alt/callback\"],\n"
    + "    \"webOrigins\": [],\n"
    + "    \"bearerOnly\": false,\n"
    + "    \"consentRequired\": false,\n"
    + "    \"standardFlowEnabled\": true,\n"
    + "    \"implicitFlowEnabled\": false,\n"
    + "    \"publicClient\": true,\n"
    + "    \"protocol\": \"openid-connect\",\n"
    + "    \"attributes\": {\n"
    + "        \"client.secret.creation.time\": \"1763052775\"\n"
    + "    },\n"
    + "    \"authenticationFlowBindingOverrides\": {},\n"
    + "    \"fullScopeAllowed\": true,\n"
    + "    \"nodeReRegistrationTimeout\": -1,\n"
    + "    \"defaultClientScopes\": [\n"
    + "        \"web-origins\",\n"
    + "        \"acr\",\n"
    + "        \"roles\",\n"
    + "        \"profile\",\n"
    + "        \"basic\",\n"
    + "        \"email\"\n"
    + "    ],\n"
    + "    \"optionalClientScopes\": [\n"
    + "        \"address\",\n"
    + "        \"phone\",\n"
    + "        \"offline_access\",\n"
    + "        \"microprofile-jwt\"\n"
    + "    ]\n"
    + "}";
  private DCRResponse dcrResponse;

  @Before
  public void setup() {
    this.dcrResponse = new DCRResponse(new JsonObject(DCR_RESPONSE_STRING));
  }

  @Test
  public void testCreateFromJson() {
    assertEquals("f3660894-1efc-4f4d-9de3-c92340cd1dc3", dcrResponse.getId());
    assertEquals("my-client-id", dcrResponse.getClientId());
    assertTrue(dcrResponse.isEnabled());
    assertEquals("client-secret", dcrResponse.getClientAuthenticatorType());
    assertEquals("my-secret", dcrResponse.getSecret());
    assertEquals("my-registration-access-token", dcrResponse.getRegistrationAccessToken());
    assertEquals(
      List.of("https://app.example.com/callback", "https://app.example.com/alt/callback"),
      dcrResponse.getRedirectUris());
  }

  @Test
  public void testNonCoreAttributes() {
    assertFalse(dcrResponse.getBoolean("implicitFlowEnabled"));
    assertFalse(dcrResponse.getBoolean("consentRequired"));
    assertEquals("openid-connect", dcrResponse.getString("protocol"));
    assertEquals(JsonArray.of("address", "phone", "offline_access", "microprofile-jwt"),
      dcrResponse.getArray("optionalClientScopes"));
  }

  @Test
  public void testSerializationToJson() {
    JsonObject json = dcrResponse.toJson();
    assertEquals("f3660894-1efc-4f4d-9de3-c92340cd1dc3", json.getString("id"));
    assertEquals("my-client-id", json.getString("clientId"));
    assertTrue(json.getBoolean("enabled"));
    assertEquals("client-secret", json.getString("clientAuthenticatorType"));
    assertEquals("my-secret", json.getString("secret"));
    assertEquals("my-registration-access-token", json.getString("registrationAccessToken"));
    assertEquals(
      List.of("https://app.example.com/callback", "https://app.example.com/alt/callback"),
      dcrResponse.getRedirectUris());
  }
}
