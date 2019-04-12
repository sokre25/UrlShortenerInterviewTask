package hr.infobip.urlshortenertask.service;

import hr.infobip.urlshortenertask.model.db.User;

import java.util.Optional;

/**
 * Interface that contains methods for easy communication with User table.
 * These methods will be implemented in UserServiceImpl class.
 */
public interface UserService {
    void saveUser(User user);
    Optional<User> getUserByAccountId(String accountId);
}
