package hr.infobip.urlshortenertask.customException;

import hr.infobip.urlshortenertask.model.response.CreateAccountResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for situation of "already existing user".
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class AccountAlreadyExistsException extends RuntimeException {
    private boolean success;
    private String description;

    public AccountAlreadyExistsException(String account, boolean b) {
    }

    public CreateAccountResponse AccountAlreadyExistsException(boolean success, String description) {
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setSuccess(success);
        createAccountResponse.setDescription(description);

        return createAccountResponse;
    }

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
}
