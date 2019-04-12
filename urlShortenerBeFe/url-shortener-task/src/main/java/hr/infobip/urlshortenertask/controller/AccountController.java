package hr.infobip.urlshortenertask.controller;

import hr.infobip.urlshortenertask.model.request.Account;
import hr.infobip.urlshortenertask.model.response.CreateAccountResponse;
import hr.infobip.urlshortenertask.service.implementation.AccountResponseService;
import hr.infobip.urlshortenertask.service.implementation.RedirectService;
import hr.infobip.urlshortenertask.service.implementation.RegisterResponseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Account controller that handles "/account" endpoint.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final AccountResponseService accountResponseService;

    @Autowired
    public AccountController(AccountResponseService accountResponseService, RegisterResponseService registerResponseService, RedirectService redirectService) {
        this.accountResponseService = accountResponseService;
    }

    @PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreateAccountResponse createAccount(@Valid @RequestBody Account userAccountData, HttpServletResponse response) {

        log.info("Account id is <{}>", userAccountData.getAccountId());

        return accountResponseService.createAccountResponseBasedOnUserExisting(userAccountData, response);

    }
}
