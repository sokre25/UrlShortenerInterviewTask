package hr.infobip.urlshortenertask.repository;

import hr.infobip.urlshortenertask.model.db.Url;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Url CRUD repository.
 */
@Repository
public interface UrlRepository extends CrudRepository<Url, Integer> {
    Url findByFullUrl(String url);
}
