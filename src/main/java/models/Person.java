package models;


import exception.EmailInvalidException;
import exception.MobileInvalidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public record Person(String firstName, String lastName, String email, String mobileNumber) implements IValidate{
    @Override
    public void validate() throws Exception {
        validateEmail();
    }

    private void validateEmail() throws EmailInvalidException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(email);
        if(!matcher.matches()) {
            throw new EmailInvalidException("Email is invalid");
        }
    }
}
