import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Courier;
import org.example.CourierClient;
import org.example.CourierGenerator;
import org.example.Credentials;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
public class LoginCourierTest {
    CourierClient courierClient;
    Courier courier;
    int courierId;
    Credentials courierCredentials;
    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = CourierGenerator.getRandomCourier();
        courierClient.create(courier);
        courierCredentials = new Credentials(courier.getLogin(), courier.getPassword());
    }
    @Test
    @DisplayName("Successful courier login")
    public void successLoginCourierTest() {
        ValidatableResponse loginResponse = courierClient.login(courierCredentials).statusCode(200);
        courierId = loginResponse.extract().path("id");
        loginResponse.assertThat().body("id", notNullValue());
        System.out.println(courierId);
    }
    @Test
    @DisplayName("Courier login with invalid login")
    public void failedLoginCourierIncorrectLoginTest() {
        ValidatableResponse loginResponse = courierClient.login(courierCredentials);
        courierId = loginResponse.extract().path("id");
        Credentials incorrectLoginCred = new Credentials(courier.getLogin() + "test", courier.getPassword());
        ValidatableResponse failedLoginResponse = courierClient.login(incorrectLoginCred).statusCode(404);
        failedLoginResponse.assertThat().body("message", equalTo("Учетная запись не найдена"));
    }
}
