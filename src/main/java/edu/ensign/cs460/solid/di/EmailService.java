package edu.ensign.cs460.solid.di;

public final class EmailService implements IMessageService {
    // if receiver does not have email address, return the following message:
    // "{receiver name} does not have proper email configuration"
    public String sendMessage(final Client receiver, final String message) {
        // return a string stating:
        // "Email sent to {receiver emailAddress} with message: {message}"
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
