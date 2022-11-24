package org.example;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class CourierClient extends Client{
    private static final String CREATE_COURIER_PATH = "api/v1/courier";
    private static final String LOGIN_COURIER_PATH = "api/v1/courier/login";
    private static final String DELETE_COURIER_PATH = "api/v1/courier";
  @Step("creating courier")
    public ValidatableResponse create(Courier courier){
        return  given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(CREATE_COURIER_PATH)
                .then();
     }
  @Step("login courier")
     public ValidatableResponse login(Credentials credentials){
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(LOGIN_COURIER_PATH)
                .then();
    }
  @Step("delete courier")
    public ValidatableResponse delete(int id){
        return given()
                .spec(getSpec())
                .when()
                .post(DELETE_COURIER_PATH + "id")
                .then();
    }
}
