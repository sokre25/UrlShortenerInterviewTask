package hr.infobip.urlshortenertask.service.implementation;

import static hr.infobip.urlshortenertask.util.AccountNameUtil.*;

import hr.infobip.urlshortenertask.model.db.Statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * Service for redirection after user goes to short url.
 */
@Service
public class RedirectService {
    private final UrlServiceImpl urlService;
    private final StatisticServiceImpl statisticService;

    @Autowired
    public RedirectService(UrlServiceImpl urlService, StatisticServiceImpl statisticService) {
        this.urlService = urlService;
        this.statisticService = statisticService;
    }

    public void redirectToUrl(String shortUrlCode, HttpServletResponse response) {
        Statistic statistic = statisticService.getStatisticByAccountIdAndShortCodeUrl(getAuthUserAccountId(), shortUrlCode);

        if (statistic == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            String fullUrl = urlService.getUrlByUrlId(statistic.getFullUrlId());

            response.setStatus(statistic.getRedirectType());
            response.setHeader(HttpHeaders.LOCATION, fullUrl);
            response.setHeader(HttpHeaders.CONNECTION, "close");

            statistic.setNumberOfRedirects(statistic.getNumberOfRedirects() + 1);

            statisticService.saveStatistic(statistic);
        }
    }
}
