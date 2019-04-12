package hr.infobip.urlshortenertask.service.implementation;

import hr.infobip.urlshortenertask.model.db.Url;
import hr.infobip.urlshortenertask.repository.UrlRepository;
import hr.infobip.urlshortenertask.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of UrlService methods.
 */
@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public void saveUrlData(Url url) {
        urlRepository.save(url);
    }

    @Override
    public Url getUrlIdByUrlValue(String urlValue) {
        return urlRepository.findByFullUrl(urlValue);
    }

    @Override
    public String getUrlByUrlId(int urlId) {
        return urlRepository.findById(urlId).get().getFullUrl();
    }

}
