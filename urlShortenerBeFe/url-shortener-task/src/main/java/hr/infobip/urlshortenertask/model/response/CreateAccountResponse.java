package hr.infobip.urlshortenertask.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Response model used after user account creation.
 */
public class CreateAccountResponse {
    private boolean success;
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
