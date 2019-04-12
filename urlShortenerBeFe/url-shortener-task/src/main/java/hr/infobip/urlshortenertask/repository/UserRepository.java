package hr.infobip.urlshortenertask.repository;

import hr.infobip.urlshortenertask.model.db.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User CRUD repository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByAccountId(String accountId);
}
