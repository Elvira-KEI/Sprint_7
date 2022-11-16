import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Order;
import org.example.OrderClient;
import org.example.OrderGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private OrderClient orderClient;
    private Order order;
    private int statusCode;

    public CreateOrderTest(Order order, int statusCode) {
        this.order = order;
        this.statusCode = statusCode;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {OrderGenerator.getWithBlackColor(), SC_CREATED},
                {OrderGenerator.getWithGreyColor(), SC_CREATED},
                {OrderGenerator.getWithBlackAndGrayColors(), SC_CREATED},
                {OrderGenerator.getWithoutColor(), SC_CREATED}
        };
    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Order can be created with different colors")
    public void orderCanBeCreated(){
        ValidatableResponse responseCreate = orderClient.createOrder(order);
        int actualStatusCode = responseCreate.extract().statusCode();
        int track = responseCreate.extract().path("track");
        assertThat("Expected track number",track, notNullValue());
        assertEquals("Status Code incorrect",statusCode,actualStatusCode);
    }

}
