import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Order;
import org.example.OrderClient;
import org.example.OrderGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderDifferentColorsTest {
    private OrderClient orderClient;
    private Order order;
    private int statusCode;
    private List<String> color;
    private int track;

    public CreateOrderDifferentColorsTest (int statusCode, Order order, List<String> color){
        this.order = order;
        this.color= color;
        this.statusCode = statusCode;
            }

    @Before
    public void setUp(){
        orderClient = new OrderClient();

    }



    @Parameterized.Parameters
    public static  Object[][] getTestData(){
        return new Object[][]{
               // {List.of()},
               // {List.of(null)},
                {List.of("GREY")},
               // {List.of("GREY","BLACK")}
        };
    }

    @Test
    @DisplayName("Order can be created with different colors")
    public void orderCanBeCreatedWithDifferentColorsTest() {
        order.setColor(List.of());
        ValidatableResponse responseCreate = null;
        track = responseCreate.extract().path("track");
        responseCreate = orderClient.createOrder(order);
        int actualStatusCode = responseCreate.extract().statusCode();
        assertEquals(statusCode, actualStatusCode);

    }
}
