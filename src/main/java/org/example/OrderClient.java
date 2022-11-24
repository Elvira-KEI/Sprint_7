package org.example;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class OrderClient extends Client{
    private static final String PATH = "api/v1/orders";
    @Step("return List Order")
    public ValidatableResponse returnOrderList(){
        return given()
                .spec(getSpec())
                 .when()
                .get(PATH)
                .then();
    }
    @Step("creating Order")
    public ValidatableResponse createOrder(Order order){
        return  given()
                .spec(getSpec())
                .body(order)
                .when()
                .post(PATH)
                .then();
    }
}
