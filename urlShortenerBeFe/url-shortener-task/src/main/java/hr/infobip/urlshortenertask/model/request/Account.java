package hr.infobip.urlshortenertask.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

/**
 * User account model used as a request model.
 */
public class Account {
    @JsonProperty("AccountId")
    @NotBlank(message = "This field is mandatory")
    String AccountId;

    @JsonProperty("AccountId")
    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }
}
