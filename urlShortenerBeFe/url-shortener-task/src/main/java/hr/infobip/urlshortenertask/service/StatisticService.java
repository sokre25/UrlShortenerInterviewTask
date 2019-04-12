package hr.infobip.urlshortenertask.service;

import hr.infobip.urlshortenertask.model.db.Statistic;
import hr.infobip.urlshortenertask.model.response.StatisticResponse;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface that contains methods for easy communication with Statistic table.
 * These methods will be implemented in StatisticServiceImpl class.
 */
public interface StatisticService {
    void saveStatistic(Statistic statistic);
    List<StatisticResponse> getStatisticByAccountId(String accountId);
    Statistic getStatisticByAccountIdAndShortCodeUrl(String accountId, String shortCodeUrl);
    Map<String,Integer> createStatisticResponse(String AccountId, HttpServletResponse response);
    Statistic getStatisticDataByFullUrlAndAccountId(String accountId, int fullUrl);
}
