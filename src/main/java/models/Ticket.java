package models;

import exception.InvalidTicketingDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record Ticket(String pnr,
                     String fareClass,
                     String travelDate,
                     Integer numberOfPax,
                     String ticketingDate,
                     String bookedCabin,
                     Person person) implements IValidate{

    @Override
    public void validate() throws Exception {
        validateTicketingDate();
    }

    private void validateTicketingDate() throws InvalidTicketingDateException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ticketingDate = dateFormat.parse(this.ticketingDate);
        Date travelDate = dateFormat.parse(this.travelDate);
        if(travelDate.before(ticketingDate)) {
            throw new InvalidTicketingDateException("Travel date is before ticketing date");
        }
    }


}
