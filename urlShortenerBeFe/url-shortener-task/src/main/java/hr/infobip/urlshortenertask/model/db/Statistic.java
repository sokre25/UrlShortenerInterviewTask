package hr.infobip.urlshortenertask.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Data model for Statistic database table.
 */
@Entity
public class Statistic {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private int id;
    private String accountId;
    private int fullUrlId;
    private String shortUrlCode;
    private int redirectType;
    int numberOfRedirects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getFullUrlId() {
        return fullUrlId;
    }

    public void setFullUrlId(int fullUrlId) {
        this.fullUrlId = fullUrlId;
    }

    public int getNumberOfRedirects() {
        return numberOfRedirects;
    }

    public void setNumberOfRedirects(int numberOfRedirects) {
        this.numberOfRedirects = numberOfRedirects;
    }

    public String getShortUrlCode() {
        return shortUrlCode;
    }

    public void setShortUrlCode(String shortUrlCode) {
        this.shortUrlCode = shortUrlCode;
    }

    public int getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(int redirectType) {
        this.redirectType = redirectType;
    }
}
