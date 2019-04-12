package hr.infobip.urlshortenertask.service.implementation;

import static hr.infobip.urlshortenertask.util.PasswordOrUrlShortCodeGenerator.*;
import static hr.infobip.urlshortenertask.util.TextConstants.SUCCESSFUL_ACCOUNT_CREATION_MSG;
import static hr.infobip.urlshortenertask.util.TextConstants.UNSUCCESSFUL_ACCOUNT_CREATION_MSG;

import hr.infobip.urlshortenertask.model.request.Account;
import hr.infobip.urlshortenertask.model.response.CreateAccountResponse;
import hr.infobip.urlshortenertask.model.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

/**
 * Service for generating account response.
 */
@Service
public class AccountResponseService {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountResponseService(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public CreateAccountResponse createAccountResponseBasedOnUserExisting(Account accountData, HttpServletResponse response) {
        CreateAccountResponse createAccountResponse;

        Optional<User> user = userService.getUserByAccountId(accountData.getAccountId());

        if (user.isPresent()) {
            createAccountResponse = new CreateAccountResponse();
            createAccountResponse.setSuccess(false);
            createAccountResponse.setDescription(UNSUCCESSFUL_ACCOUNT_CREATION_MSG);

            response.setStatus(HttpStatus.CONFLICT.value());

        } else {
            String generatedUserPassword = getGeneratedString(8);
            User newUser = new User(accountData.getAccountId(), passwordEncoder.encode(generatedUserPassword));
            userService.saveUser(newUser);

            createAccountResponse = new CreateAccountResponse();
            createAccountResponse.setSuccess(true);
            createAccountResponse.setDescription(SUCCESSFUL_ACCOUNT_CREATION_MSG);
            createAccountResponse.setPassword(generatedUserPassword);

            response.setStatus(HttpStatus.CREATED.value());
        }

        return createAccountResponse;
    }

}
