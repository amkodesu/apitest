import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CheckAllUserResponsesTest {

    @Test
    public void logResponses() {
        for(int id = -1; id<=1000; id++) {
            System.out.println("userId="+id);
            ValidatableResponse response = given()
                    .when().contentType(ContentType.JSON)
                    .get(Spec.URL + "user/" + id)
                    .then().log().body();
            System.out.println("________________________________________________________");
        }
    }
}
