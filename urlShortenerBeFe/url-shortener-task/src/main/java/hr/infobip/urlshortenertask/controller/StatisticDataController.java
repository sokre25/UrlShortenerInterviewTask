package hr.infobip.urlshortenertask.controller;

import hr.infobip.urlshortenertask.service.implementation.StatisticServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * StatisticDataController controller that handles "statistic/{AccountId}" endpoint.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class StatisticDataController {
    private static final Logger log = LoggerFactory.getLogger(StatisticDataController.class);

    private final StatisticServiceImpl statisticService;

    @Autowired
    public StatisticDataController(StatisticServiceImpl statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(path = "statistic/{AccountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Integer> getStatistic(@PathVariable String AccountId, HttpServletResponse response) {
        log.info("Account id is <{}>", AccountId);
        return statisticService.createStatisticResponse(AccountId, response);
    }

}
