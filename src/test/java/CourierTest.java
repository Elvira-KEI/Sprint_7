import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Courier;
import org.example.CourierClient;
import org.example.CourierGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class CourierTest {
    private CourierClient courierClient;
    private Courier courier;
    private int statusCode;
    private String message;
    private  int id;
    @Before
    public void setUp(){
        courierClient = new CourierClient();
    }
    @After
    public void cleanUp(){
            courierClient.delete(id);
    }
    public CourierTest (Courier courier, int statusCode, String message){
        this.courier = courier;
        this.statusCode = statusCode;
        this.message = message;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {CourierGenerator.getWithPasswordOnly(), SC_BAD_REQUEST, "Недостаточно данных для создания учетной записи"},
                {CourierGenerator.getWithLoginOnly(), SC_BAD_REQUEST, "Недостаточно данных для создания учетной записи"},
                {CourierGenerator.getWithPasswordNull(), SC_BAD_REQUEST, "Недостаточно данных для создания учетной записи"},
                {CourierGenerator.getWithPasswordEmpty(), SC_BAD_REQUEST, "Недостаточно данных для создания учетной записи"},
                {CourierGenerator.getWithIdenticalCourier(), SC_BAD_REQUEST, "Этот логин уже используется. Попробуйте другой."},
                {CourierGenerator.getWithExistingLogin(), SC_BAD_REQUEST, "Этот логин уже используется. Попробуйте другой."}
                     };
    }
    @Test
    @DisplayName("Courier can be created")
    public void courierCanBeCreated(){
        ValidatableResponse responseCreate = courierClient.create(courier);
       int actualStatusCode = responseCreate.extract().statusCode();
       assertEquals(statusCode, actualStatusCode);
        String actualMessage = responseCreate.extract().path("message");
        assertEquals(message, actualMessage);
         }
}
