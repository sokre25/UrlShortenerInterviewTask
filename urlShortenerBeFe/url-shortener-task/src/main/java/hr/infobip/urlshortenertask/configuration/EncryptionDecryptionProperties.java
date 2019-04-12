package hr.infobip.urlshortenertask.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Salt and password properties used in the encryption/decryption process.
 */
@Component
public class EncryptionDecryptionProperties {

    @Value("${my.salt}")
    private String salt;

    @Value("${my.password}")
    private String password;

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }
}
