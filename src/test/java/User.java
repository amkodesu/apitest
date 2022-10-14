import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    public Boolean isSuccess;
    public Integer errorCode;
    public String errorMessage;
    public UserData user;

    @JsonCreator
    public User(
        @JsonProperty("isSuccess") Boolean isSuccess,
        @JsonProperty("errorCode") Integer errorCode,
        @JsonProperty("errorMessage") String errorMessage,
        @JsonProperty("user") UserData user){
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.user = user;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserData getUser() {
        return user;
    }
}

class UserData {
    public Integer id;
    public String name;
    public String gender;
    public Integer age;
    public String city;
    public Date registrationDate;

    @JsonCreator
    public UserData(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("gender") String gender,
            @JsonProperty("age") Integer age,
            @JsonProperty("city") String city,
            @JsonProperty("registrationDate") Date registrationDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

}