package hr.infobip.urlshortenertask.service;

import hr.infobip.urlshortenertask.model.db.Url;

/**
 * Interface that contains methods for easy communication with Url table.
 * These methods will be implemented in UrlServiceImpl class.
 */
public interface UrlService {
    void saveUrlData(Url url);
    Url getUrlByFullUrlValue(String fullUrlValue);
    String getUrlByUrlId(int urlId);
}
