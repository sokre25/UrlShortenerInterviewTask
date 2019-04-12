package hr.infobip.urlshortenertask.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hr.infobip.urlshortenertask.model.db.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSavingToDatabase_DataIsValid_NewUrlIsCreated() {
        User user = new User();
        user.setAccountId("user1");
        user.setPassword("1234");

        entityManager.persist(user);
        entityManager.flush();

        Optional<User> foundUser = userRepository.findByAccountId(user.getAccountId());

        assertThat(foundUser.get().getAccountId()).isEqualTo(user.getAccountId());
    }
}
