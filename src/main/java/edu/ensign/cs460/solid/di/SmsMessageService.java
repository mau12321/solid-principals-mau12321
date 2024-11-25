package edu.ensign.cs460.solid.di;

public final class SmsMessageService implements IMessageService {
    // if receiver does not have mobile number, return the following message:
    // "{receiver name} does not have proper mobile number configuration"
    public String sendMessage(final Client receiver, final String message) {
        // return a string stating:
        // "SMS sent to {receiver mobile phone} with message: {message}"
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
