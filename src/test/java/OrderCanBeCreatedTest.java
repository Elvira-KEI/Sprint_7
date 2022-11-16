import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Order;
import org.example.OrderClient;
import org.example.OrderGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class OrderCanBeCreatedTest {
    private OrderClient orderClient;
    private Order order;
    private int statusCode;

    @Before
    public void setUp() {
        orderClient = new OrderClient();

    }

    @Test
    @DisplayName("Checking if the body of the response contains track")
    public void orderCanBeCreated(){
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        int actualStatusCode = responseCreate.extract().statusCode();
        int track = responseCreate.extract().path("track");
        assertThat("Expected track number",track, notNullValue());

        assertEquals("Status Code incorrect",statusCode,actualStatusCode);
    }
}
