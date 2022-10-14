import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest {

    @Test
    //Получение списка пользователей, gender=male
    public void usersMaleTest() {
        Spec.specification(Spec.req(), Spec.res200());
        ValidatableResponse usersMale = given()
                .when()
                .get("users?gender=male")
                .then().log().all()
                .body("isSuccess", equalTo(true))
                .body("errorCode", equalTo(0))
                .body("errorMessage", nullValue())
                .body("idList", notNullValue());
        JsonPath jsonPath = usersMale.extract().jsonPath();
        List<Integer> idList = jsonPath.get("idList");
        System.out.println("Users, gender=male:"+idList);
    }

    @Test
    //Получение списка пользователей, gender=female
    public void usersFemaleTest() {
        Spec.specification(Spec.req(), Spec.res200());
        ValidatableResponse usersFemale = given()
                .when()
                .get("users?gender=female")
                .then().log().all()
                .body("isSuccess", equalTo(true))
                .body("errorCode", equalTo(0))
                .body("errorMessage", nullValue())
                .body("idList", notNullValue());
        JsonPath jsonPath = usersFemale.extract().jsonPath();
        List<Integer> idList = jsonPath.get("idList");
        System.out.println("Users, gender=female:"+idList);
    }

    @Test
    //Получение списка пользователей, gender=any
    public void usersAnyTest() {
        Spec.specification(Spec.req(), Spec.res200());
        ValidatableResponse usersAny = given()
                .when()
                .get("users?gender=any")
                .then().log().all()
                .body("isSuccess", equalTo(true))
                .body("errorCode", equalTo(0))
                .body("errorMessage", nullValue())
                .body("idList", notNullValue());
        JsonPath jsonPath = usersAny.extract().jsonPath();
        List<Integer> idList = jsonPath.get("idList");
        System.out.println("Users, gender=any:"+idList);
    }

    @Test
    //Проверить негативные коды ответов
    public void users500Test() {
        Spec.specification(Spec.req(), Spec.res500());
        ValidatableResponse users = given()
                .when()
                .get("users?gender=test")
                .then().log().all();
    }
}
