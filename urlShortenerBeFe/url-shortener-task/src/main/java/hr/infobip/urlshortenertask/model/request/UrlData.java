package hr.infobip.urlshortenertask.model.request;

import hr.infobip.urlshortenertask.validator.RedirectTypeConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

/**
 * Url data model used as a request model.
 */
public class UrlData {
    @NotBlank(message = "This field is mandatory")
    @URL
    String url;

    @RedirectTypeConstraint
    @JsonProperty(required = false)
    int redirectType = 302;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(int redirectType) {
        this.redirectType = redirectType;
    }
}
