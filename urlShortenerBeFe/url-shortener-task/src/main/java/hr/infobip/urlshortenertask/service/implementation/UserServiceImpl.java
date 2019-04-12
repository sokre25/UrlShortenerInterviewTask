package hr.infobip.urlshortenertask.service.implementation;

import hr.infobip.urlshortenertask.model.db.User;
import hr.infobip.urlshortenertask.repository.UserRepository;
import hr.infobip.urlshortenertask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of UserService methods.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves user into database.
     *
     * @param user user for saving.
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Returns user object based on Account id.
     *
     * @param accountId account id.
     *
     * @return user determined by given account id.
     */
    @Override
    public Optional<User> getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId);
    }
}
