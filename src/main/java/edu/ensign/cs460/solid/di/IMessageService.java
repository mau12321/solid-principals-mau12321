package edu.ensign.cs460.solid.di;

public interface IMessageService {
    // All Implementations: If receiver does not have the proper configuration
    // (email address or mobile number = null), return exact message below - either
    // "{receiver name} does not have proper email configuration"
    // or "{receiver name} does not have proper mobile number configuration"
    String sendMessage(Client receiver, String message);
}
