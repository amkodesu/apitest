import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Spec {
    public static final String URL = "https://hr-challenge.interactivestandard.com/api/test/";
    //static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

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

    public static void main(String[] args) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(dateformat.format(timestamp));
//        SimpleDateFormat currDate = dateformat.format(timestamp);
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        System.out.println(cal.getTimeInMillis());
        System.out.println(cal.getTimeInMillis()-200);

    }

}
