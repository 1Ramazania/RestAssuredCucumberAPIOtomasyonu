import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests {

    @Test
    public void createBookingTests() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("firstname", "Ramazan");
        body.put("lastname", "Taş");
        body.put("totalprice", 150);
        body.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2024-08-08");
        bookingDates.put("checkout", "2023-08-09");

        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Kopek Yatagi");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

        Assertions.assertEquals("Ramazan", response.jsonPath().getString("booking.firstname"));
        Assertions.assertEquals("Taş", response.jsonPath().getString("booking.lastname"));
    }
}
