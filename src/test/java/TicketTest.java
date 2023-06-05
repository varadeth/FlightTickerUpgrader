import exception.InvalidBookingClassException;
import exception.InvalidPNRException;
import exception.InvalidTicketingDateException;
import models.Person;
import models.Ticket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TicketTest {
    @Test
    void shouldValidateTicketingDateElseThrowException() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        assertDoesNotThrow(() -> ticket.validate());
    }

    @Test
    void shouldThrowExceptionForInvalidTicketingDate() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC123", "A", "2023-05-22", 2, "2023-06-04", "Economy", person);
        assertThrows(InvalidTicketingDateException.class, () -> ticket.validate());
    }

    @Test
    void shouldThrowExceptionForInvalidPNR() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC12", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        assertThrows(InvalidPNRException.class, () -> ticket.validate());
    }

    @Test
    void shouldNotThrowExceptionForValidPNR() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        assertDoesNotThrow(() -> ticket.validate());
    }

    @Test
    void shouldThrowExceptionIfBookingClassIsInvalid() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Econom", person);
        assertThrows(InvalidBookingClassException.class, () -> ticket.validate());
    }

    @Test
    void shouldNotThrowExceptionIfBookingClassIsValid() {
        Person person = new Person("Prasanjeet", "Mane", "prasanjeet@gmail.com", "9191919191");
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        assertDoesNotThrow(() -> ticket.validate());
    }

    @Test
    void shouldCallPersonValidation() throws Exception {
        Person person = Mockito.mock(Person.class);
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        ticket.validate();
        verify(person, times(1)).validate();
    }

    @Test
    void shouldReturnDiscountCodeAsOffer_20() throws Exception {
        Person person = Mockito.mock(Person.class);
        Ticket ticket = new Ticket("ABC123", "A", "2023-07-22", 2, "2023-06-04", "Economy", person);
        String expectedDiscountCode = "OFFER_20";

        String actualDiscountCode = ticket.getDiscountCode();

        verify(person, times(1)).validate();
        assertEquals(expectedDiscountCode, actualDiscountCode);
    }

    @Test
    void shouldReturnDiscountCodeAsOffer_30() throws Exception {
        Person person = Mockito.mock(Person.class);
        Ticket ticket = new Ticket("ABC123", "F", "2023-07-22", 2, "2023-06-04", "Economy", person);
        String expectedDiscountCode = "OFFER_30";

        String actualDiscountCode = ticket.getDiscountCode();

        verify(person, times(1)).validate();
        assertEquals(expectedDiscountCode, actualDiscountCode);
    }

    @Test
    void shouldReturnDiscountCodeAsOffer_25() throws Exception {
        Person person = Mockito.mock(Person.class);
        Ticket ticket = new Ticket("ABC123", "P", "2023-07-22", 2, "2023-06-04", "Economy", person);
        String expectedDiscountCode = "OFFER_25";

        String actualDiscountCode = ticket.getDiscountCode();

        verify(person, times(1)).validate();
        assertEquals(expectedDiscountCode, actualDiscountCode);
    }
}
