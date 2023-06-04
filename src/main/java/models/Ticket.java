package models;

public record Ticket(String pnr,
                     String fareClass,
                     String travelDate,
                     String numberOfPax,
                     String ticketingDate,
                     String bookedCabin,
                     Person person) implements IValidate{

    @Override
    public void validate() {
    }

}
