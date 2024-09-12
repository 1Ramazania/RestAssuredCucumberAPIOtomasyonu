import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAlBookingsTests {
    //Cagriyi olsturmamız
    //Response kontrolleri
    //curl -i https://restful-booker.herokuapp.com/booking

    @Test
    public void getAlBookingTest(){
        given()
                .when()
                .get( "https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);

    }


}
