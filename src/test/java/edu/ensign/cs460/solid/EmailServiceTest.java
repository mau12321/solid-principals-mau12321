package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.ensign.cs460.solid.di.Client;
import edu.ensign.cs460.solid.di.EmailService;

public class EmailServiceTest {
    private EmailService emailService;
    private Client clientWithSmsEmail;
    private Client clientWithSms;
    private TestHelpers testHelpers = new TestHelpers();

    @BeforeEach
    private void init() {
        this.emailService = new EmailService();
        List<Client> clients = this.testHelpers.setupClients();
        this.clientWithSmsEmail = clients.get(0);
        this.clientWithSms = clients.get(2);
    }

    @Test
    public void sendMesssage_happyPath_shouldReturnMessageEmail() {
        // arrange
        String expEmailSnip = "email";
        String expMessage = "test";
        String expEmail = this.clientWithSmsEmail.getEmailAddress();
        // act
        String actMessage = this.emailService.sendMessage(this.clientWithSmsEmail, expMessage);
        // assert
        assertTrue(actMessage.toLowerCase().contains(expEmailSnip), "Message does not contain email indicator");
        assertTrue(actMessage.contains(expMessage), "Message does not contain expected message: " + expMessage);
        assertTrue(actMessage.contains(expEmail), "Message does not contain expected email address:" + expEmail);
    }

    @Test
    public void sendMesssage_emailAddressIsNull_shouldReturnErrorMessage() {
        // arrange
        this.emailService = new EmailService();
        String expMessage = "test";
        String expName = this.clientWithSms.getName();
        // act
        String actMessage = this.emailService.sendMessage(this.clientWithSms, expMessage);
        // assert
        assert(actMessage.contains(expName));
        assert(actMessage.toLowerCase().contains("does not have proper email configuration"));
    }

}
