package hr.infobip.urlshortenertask.service.implementation;

import hr.infobip.urlshortenertask.model.db.Statistic;
import hr.infobip.urlshortenertask.model.response.StatisticResponse;
import hr.infobip.urlshortenertask.repository.StatisticRepository;
import hr.infobip.urlshortenertask.service.StatisticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of StatisticService methods.
 */
@Service
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void saveStatistic(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticResponse> getStatisticByAccountId(String accountId) {
        return statisticRepository.getStatisticByAccountId(accountId);
    }

    @Override
    public Statistic getStatisticByAccountIdAndShortCodeUrl(String accountId, String shortCodeUrl) {
        return statisticRepository.findByAccountIdAndShortUrlCode(accountId, shortCodeUrl);
    }

    @Override
    public Map<String, Integer> createStatisticResponse(String AccountId, HttpServletResponse response) {
        List<StatisticResponse> list = statisticRepository.getStatisticByAccountId(AccountId);

        if(list.size() == 0) response.setStatus(HttpStatus.NOT_FOUND.value());

        Map<String, Integer> mapStatisticResponse = new HashMap<>();

        list.forEach(listElement -> {
            mapStatisticResponse.put(listElement.getFullUrl(), listElement.getNumber_of_redirects());
        });
        return mapStatisticResponse;
    }

    @Override
    public Statistic getStatisticDataByFullUrlAndAccountId(String accountId, int fullUrl) {
        return statisticRepository.findByAccountIdAndFullUrlId(accountId, fullUrl);
    }

}
