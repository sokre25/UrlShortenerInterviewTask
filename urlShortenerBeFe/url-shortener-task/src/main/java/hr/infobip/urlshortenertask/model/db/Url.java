package hr.infobip.urlshortenertask.model.db;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Data model for url database table.
 */
@Entity
public class Url {
    @Id
    @Column(unique = true)
    @GeneratedValue
    private int id;
    private String fullUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fullUrlId", referencedColumnName = "id")
    private List<Statistic> urlStatistics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public List<Statistic> getUrlStatistics() {
        return urlStatistics;
    }


}
