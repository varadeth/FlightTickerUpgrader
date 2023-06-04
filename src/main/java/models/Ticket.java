package models;

import exception.InvalidPNRException;
import exception.InvalidTicketingDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        validatePNR();
    }

    private void validatePNR() throws InvalidPNRException {
        String regex = "^[A-Z0-9]{6}$";
        Pattern pnrPattern = Pattern.compile(regex);
        Matcher matcher = pnrPattern.matcher(pnr);
        if(!matcher.matches())
            throw new InvalidPNRException("PNR Number is not valid");
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
