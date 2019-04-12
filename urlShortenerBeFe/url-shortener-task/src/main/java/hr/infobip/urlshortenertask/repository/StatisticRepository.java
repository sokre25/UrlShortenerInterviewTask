package hr.infobip.urlshortenertask.repository;

import hr.infobip.urlshortenertask.model.db.Statistic;
import hr.infobip.urlshortenertask.model.response.StatisticResponse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Statistic CRUD repository.
 */
@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
    @Query("SELECT new hr.infobip.urlshortenertask.model.response.StatisticResponse(u.fullUrl, s.numberOfRedirects) FROM Url u INNER JOIN u.urlStatistics as s on u.id = s.fullUrlId where s.accountId =:accountId")
    List<StatisticResponse> getStatisticByAccountId(@Param("accountId") String accountId);

    Statistic findByAccountIdAndShortUrlCode(String accountId, String shortCodeUrl);

    Statistic findByAccountIdAndFullUrlId(String accountId, int fullUrlId);
}
