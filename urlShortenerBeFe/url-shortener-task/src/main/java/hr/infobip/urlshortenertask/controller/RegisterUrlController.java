package hr.infobip.urlshortenertask.controller;

import hr.infobip.urlshortenertask.model.response.RegisterUrlResponse;
import hr.infobip.urlshortenertask.model.request.UrlData;
import hr.infobip.urlshortenertask.service.implementation.RedirectService;
import hr.infobip.urlshortenertask.service.implementation.RegisterResponseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * RegisterUrlController controller that handles "/register" and "/red/{shortUrlCode}" endpoint.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class RegisterUrlController {

    private static final Logger log = LoggerFactory.getLogger(RegisterUrlController.class);

    private final RegisterResponseService registerResponseService;
    private final RedirectService redirectService;

    @Autowired
    public RegisterUrlController(RegisterResponseService registerResponseService, RedirectService redirectService) {
        this.registerResponseService = registerResponseService;
        this.redirectService = redirectService;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = HttpHeaders.AUTHORIZATION)
    public RegisterUrlResponse registerUrl(@Valid @RequestBody UrlData urlData, HttpServletResponse response) {

        log.info("Url is <{}>", urlData.getUrl());
        log.info("Redirect type is <{}>", urlData.getRedirectType());

        return registerResponseService.createRegisterUrlResponse(urlData, response);
    }

    @GetMapping(path = "/red/{shortUrlCode}")
    public void redirectToRealUrl(@PathVariable String shortUrlCode, HttpServletResponse response) {
        log.info("SortUrlCode is <{}>", shortUrlCode);

        redirectService.redirectToUrl(shortUrlCode, response);
    }
}
