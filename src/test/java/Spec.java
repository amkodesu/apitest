import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Date;

public class Spec {
    public static final String URL = "https://hr-challenge.interactivestandard.com/api/test/";
    static Date curDate = new Date();
    static Date oldDate = new Date(946728000000L);

    public static RequestSpecification req(){
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification res200(){
        return new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    public static ResponseSpecification res500(){
        return new ResponseSpecBuilder().expectStatusCode(500).build();
    }

    public static void specification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
