package hr.infobip.urlshortenertask.model.response;


/**
 * Response model used for final statistic data.
 */
public class StatisticResponse {
    String fullUrl;
    int number_of_redirects;

    public StatisticResponse(String fullUrl, int number_of_redirects) {
        this.fullUrl = fullUrl;
        this.number_of_redirects = number_of_redirects;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public int getNumber_of_redirects() {
        return number_of_redirects;
    }

    public void setNumber_of_redirects(int number_of_redirects) {
        this.number_of_redirects = number_of_redirects;
    }
}
