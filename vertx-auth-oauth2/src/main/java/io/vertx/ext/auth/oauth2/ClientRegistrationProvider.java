package io.vertx.ext.auth.oauth2;

public interface ClientRegistrationProvider {

  DCRResponse create(DCRRequest dcrRequest); //POST 201
  DCRResponse get(String clientId); //GET 200
  DCRResponse update(DCRRequest dcrRequest); //PUT  200
  void delete(String clientId); //DELETE 204

}