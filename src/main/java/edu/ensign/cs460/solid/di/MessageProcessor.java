package edu.ensign.cs460.solid.di;

import java.util.List;

public final class MessageProcessor {

    // if no message service is provided, throw an IllegalArgumentException
    public MessageProcessor(final List<IMessageService> messageServices) {
    }

    // return a log of all the messages received from the message services sendMessage calls
    public String processMessage(final Client receiver, final String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
