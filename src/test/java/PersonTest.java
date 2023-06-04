import exception.EmailInvalidException;
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
}
