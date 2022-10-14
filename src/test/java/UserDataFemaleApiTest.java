import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class UserDataFemaleApiTest {
    private final int id;
    static Date curDate = new Date();
    static Date oldDate = new Date(946728000000L);

    public UserDataFemaleApiTest(int id) {
        this.id = id;
    }

    //@Before
    @Parameterized.Parameters
    //Получение списка пользователей, gender=female
    public static List<Integer> userDataMaleTestBefore() {
        List<Integer> listFemale = given()
                .when().contentType(ContentType.JSON)
                .get(Spec.URL+"users?gender=female")
                .then().log().all()
                .extract().response().as(UserIdList.class).getIdList();
        System.out.println(listFemale);
        return listFemale;
    }

    @Test
    //Отправляем GET-запрос по каждому юзеру
    public void userDataMaleTest(){
        System.out.println("userId="+id);
        User user = given()
                .when().contentType(ContentType.JSON)
                .get(Spec.URL + "user/" + id)
                .then().log().all()
                .statusCode(200)
                .extract()
                .body().as(User.class);
        Date regDate = user.getUser().getRegistrationDate();
        Integer age = user.getUser().getAge();
        Assert.assertSame(true, user.getSuccess());
        Assert.assertSame(0, user.getErrorCode());
        Assert.assertSame(null, user.getErrorMessage());
        Assert.assertNotNull(user.getUser().getName());
        assert "female".equals(user.getUser().getGender()) : "Error: gender!=female";
        Assert.assertSame(id, user.getUser().getId());
        Assert.assertNotNull(age);
        assert id != age: "Error: id=age"; //проверяем возможную ошибку совпадения id и age
        Assert.assertNotNull(user.getUser().getCity());
        //проверки на дату регистрации
        Assert.assertNotNull(regDate);
        assert regDate.before(curDate) : "Invalid date: regDate after current date";
        assert regDate.after(oldDate) : "Invalid date: regDate before 2000 year";

    }
}
