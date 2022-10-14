import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserIdList {
    public Boolean isSuccess;
    public Integer errorCode;
    public String errorMessage;
    public List<Integer> idList;

    @JsonCreator
    public UserIdList(@JsonProperty("isSuccess") Boolean isSuccess,
                      @JsonProperty("errorCode") Integer errorCode,
                      @JsonProperty("errorMessage") String errorMessage,
                      @JsonProperty("idList") List<Integer> idList) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.idList = idList;
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

    public List<Integer> getIdList() { return idList;}
}
