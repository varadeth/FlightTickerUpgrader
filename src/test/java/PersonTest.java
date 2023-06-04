import exception.EmailInvalidException;
import exception.MobileInvalidException;
import models.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    void shouldThrowExceptionWhenIncorrectEmailAddressForPerson() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet", "9191919191");
        assertThrows(EmailInvalidException.class, () -> person.validate());
    }

    @Test
    void shouldNotThrowExceptionWhenCorrectEmailAddressPassedForPerson() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        assertDoesNotThrow(() -> person.validate());
    }

    @Test
    void shouldThrowExceptionWhenIncorrectMobileNumberForPerson() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "919191919");
        assertThrows(MobileInvalidException.class, () -> person.validate());
    }

    @Test
    void shouldNotThrowExceptionWhenCorrectMobileNumberForPerson() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        assertDoesNotThrow(() -> person.validate());
    }
}
