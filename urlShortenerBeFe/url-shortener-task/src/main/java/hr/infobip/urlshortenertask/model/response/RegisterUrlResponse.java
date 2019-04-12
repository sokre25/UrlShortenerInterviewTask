package hr.infobip.urlshortenertask.model.response;

/**
 * Response model used after user url is registered.
 */
public class RegisterUrlResponse {
    private String shortUrl;

    public RegisterUrlResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
