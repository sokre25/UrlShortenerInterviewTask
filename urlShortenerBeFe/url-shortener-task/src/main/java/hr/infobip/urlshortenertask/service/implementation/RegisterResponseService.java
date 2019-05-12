package hr.infobip.urlshortenertask.service.implementation;

import static hr.infobip.urlshortenertask.util.AccountNameUtil.getAuthUserAccountId;
import static hr.infobip.urlshortenertask.util.PasswordOrUrlShortCodeGenerator.*;
import static hr.infobip.urlshortenertask.util.TextConstants.BASE_SHORT_URL;

import hr.infobip.urlshortenertask.model.response.RegisterUrlResponse;
import hr.infobip.urlshortenertask.model.db.Statistic;
import hr.infobip.urlshortenertask.model.db.Url;
import hr.infobip.urlshortenertask.model.request.UrlData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * Service for generating register response.
 */
@Service
public class RegisterResponseService {

    private final UrlServiceImpl urlService;
    private final StatisticServiceImpl statisticService;

    @Autowired
    public RegisterResponseService(UrlServiceImpl urlService, StatisticServiceImpl statisticService) {
        this.urlService = urlService;
        this.statisticService = statisticService;
    }

    public RegisterUrlResponse createRegisterUrlResponse(UrlData urlData, HttpServletResponse response) {

        String shortUrlCode = getGeneratedString(6);
        String shortUrl = BASE_SHORT_URL + shortUrlCode;

        Statistic urlAndAccountAlreadyExist = null;
        Url newUrlObject = null;
        RegisterUrlResponse registerUrlResponse = null;

        Url databaseUrlObject = urlService.getUrlByFullUrlValue(urlData.getUrl());

        if(databaseUrlObject == null) {
            newUrlObject = new Url();
            newUrlObject.setFullUrl(urlData.getUrl());
            urlService.saveUrlData(newUrlObject);
        } else {
            urlAndAccountAlreadyExist = statisticService.getStatisticDataByFullUrlAndAccountId(getAuthUserAccountId(), databaseUrlObject.getId());
        }

        if(urlAndAccountAlreadyExist != null) {
            response.setStatus(HttpStatus.CONFLICT.value());
            registerUrlResponse = new RegisterUrlResponse("Short url is not generated because Account id and full url already exists");
        } else {
            Statistic statistic = new Statistic();
            statistic.setAccountId(getAuthUserAccountId());
            if(databaseUrlObject == null) {
                statistic.setFullUrlId(newUrlObject.getId());
            } else {
                statistic.setFullUrlId(databaseUrlObject.getId());
            }
            statistic.setShortUrlCode(shortUrlCode);
            statistic.setRedirectType(urlData.getRedirectType());
            statistic.setNumberOfRedirects(0);

            statisticService.saveStatistic(statistic);

            registerUrlResponse = new RegisterUrlResponse(shortUrl);
            response.setStatus(HttpStatus.CREATED.value());
        }
        return registerUrlResponse;
    }
}
