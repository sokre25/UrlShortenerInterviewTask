package hr.infobip.urlshortenertask.util;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

/**
 * Password generator.
 */
public class PasswordOrUrlShortCodeGenerator {
    public static String getGeneratedString(int length) {
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
            .build();

        return stringGenerator.generate(length);
    }
}
