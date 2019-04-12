package hr.infobip.urlshortenertask.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import hr.infobip.urlshortenertask.AbstractTest;
import hr.infobip.urlshortenertask.model.request.Account;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class AccountControllerTest extends AbstractTest {

    @Autowired
    protected MockMvc mockMvc;

    private static final String MOCK_JSON_ACCOUNT = "{\"AccountId\":\"user1\"}";
    private static final String MOCK_JSON_INVALID_ACCOUNT = "{\"AccountId\":\123}";
    private static final String MOCK_JSON_EMPTY_ACCOUNT_ID = "{\"AccountId\":\"\"}";

    @Test
    public void testCreateAccount_ValidAccountIdIsUsed_AccountIsCreated() throws Exception {
        Account account = new Account();
        account.setAccountId("user1");

        mockMvc.perform(post("/account")
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                            .content(MOCK_JSON_ACCOUNT))
            .andExpect(status().isCreated());
    }

    @Test
    public void testCreateAccount_InValidAccountIdTypeIsUsed_NewAccountIsNotCreatedBadRequestIsReturned() throws Exception {
        mockMvc.perform(post("/account")
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                            .content(MOCK_JSON_INVALID_ACCOUNT))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAccount_accountIdIsEmpty_NewAccountIsNotCreatedBadRequestIsReturned() throws Exception {
        mockMvc.perform(post("/account")
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                            .content(MOCK_JSON_EMPTY_ACCOUNT_ID))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAccount_accountIdAlreadyExist_NewAccountIsNotCreatedConflictIsReturned() throws Exception {
        mockMvc.perform(post("/account")
                            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                            .content(MOCK_JSON_ACCOUNT))
            .andExpect(status().isConflict());
    }


}

