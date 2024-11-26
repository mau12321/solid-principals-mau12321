package edu.ensign.cs460.solid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.di.Client;
import edu.ensign.cs460.solid.di.EmailService;
import edu.ensign.cs460.solid.di.IMessageService;
import edu.ensign.cs460.solid.di.MessageProcessor;
import edu.ensign.cs460.solid.di.SmsMessageService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class MessageProcessorTest {
    private EmailService emailService;
    private SmsMessageService smsMessageService;
    private List<IMessageService> messageServices;
    private Client clientWithSmsEmail;
    private Client clientWithEmail;
    private Client clientWithSms;
    private TestHelpers testHelpers = new TestHelpers();

    @BeforeEach
    private void init() {
        this.setupMessageProcessor();
        List<Client> clients = this.testHelpers.setupClients();
        this.clientWithSmsEmail = clients.get(0);
        this.clientWithEmail = clients.get(1);
        this.clientWithSms = clients.get(2);
    }

    @Test
    public void processMessage_emailMessageService_shouldReturnMessageWithEmailDetails() {
        // arrange
        MessageProcessor messageProcessor = new MessageProcessor(this.messageServices);
        String expEmailSnip = "email";
        String expMessage = "test";
        String expEmail = this.clientWithSmsEmail.getEmailAddress();

        // act
        String actMessage = messageProcessor.processMessage(this.clientWithSmsEmail, expMessage);
        // assert
        assertTrue(actMessage.toLowerCase().contains(expEmailSnip), "Message does not contain email indicator");
        assertTrue(actMessage.toLowerCase().contains(expMessage), "Message does not contain expected message: " + expMessage);
        assertTrue(actMessage.contains(expEmail), "Message does not contain expected email address:" + expEmail);
    }

    @Test
    public void processMessage_smsMessageService_shouldReturnMessageWithSmsDetails() {
        // arrange
        MessageProcessor messageProcessor = new MessageProcessor(this.messageServices);
        String expSmsSnip = "sms";
        String expMessage = "test";
        String expMobileNumber = this.clientWithSmsEmail.getMobileNumber();

        // act
        String actMessage = messageProcessor.processMessage(this.clientWithSmsEmail, expMessage);
        assertTrue(actMessage.toLowerCase().contains(expSmsSnip), "Message does not contain sms indicator");
        assertTrue(actMessage.toLowerCase().contains(expMessage), "Message does not contain expected message: " + expMessage);
        assertTrue(actMessage.contains(expMobileNumber), "Message does not contain expected mobile number: " + expMobileNumber);
    }

    @Test
    public void processMessage_nullEmail_shouldReturnEmailNotConfigured() {
        // arrange
        MessageProcessor messageProcessor = new MessageProcessor(this.messageServices);
        String expMessage = "test";
        String expEmail = "does not have proper email configuration";

        // act
        String actMessage = messageProcessor.processMessage(this.clientWithSms, expMessage);
        // assert
        assertTrue(actMessage.toLowerCase().contains(expEmail), "Message does not contain expected message: " + expEmail);
    }

    @Test
    public void processMessage_nullMobileNumber_shouldReturnSmsNotConfigured() {
        // arrange
        MessageProcessor messageProcessor = new MessageProcessor(this.messageServices);
        String expMessage = "test";
        String expMobileNumber = "does not have proper mobile number configuration";

        // act
        String actMessage = messageProcessor.processMessage(this.clientWithEmail, expMessage);
        // assert
        assertTrue(actMessage.toLowerCase().contains(expMobileNumber), "Message does not contain expected message: " + expMobileNumber);
    }

    private void setupMessageProcessor() {
        this.emailService = new EmailService();
        this.smsMessageService = new SmsMessageService();
        this.messageServices = new ArrayList<IMessageService>();
        this.messageServices.add(this.smsMessageService);
        this.messageServices.add(this.emailService);
    }
}
