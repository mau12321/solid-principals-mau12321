package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.di.Client;
import edu.ensign.cs460.solid.di.SmsMessageService;

public class SmsMessageServiceTest {
    private SmsMessageService smsMessageService;
    private Client clientWithSmsEmail;
    private Client clientWithEmail;
    private TestHelpers testHelpers = new TestHelpers();

    @BeforeEach
    private void init() {
        this.smsMessageService = new SmsMessageService();
        List<Client> clients = this.testHelpers.setupClients();
        this.clientWithSmsEmail = clients.get(0);
        this.clientWithEmail = clients.get(1);  
    }

    @Test
    public void sendMesssage_happyPath_shouldReturnMessageSms() {
        // arrange
        String expSmsSnip = "sms";
        String expMessage = "test";
        String expMobileNumber = this.clientWithSmsEmail.getMobileNumber();
        // act
        String actMessage = this.smsMessageService.sendMessage(this.clientWithSmsEmail, expMessage);
        // assert
        assertTrue(actMessage.toLowerCase().contains(expSmsSnip), "Message does not contain email indicator");
        assertTrue(actMessage.contains(expMessage), "Message does not contain expected message: " + expMessage);
        assertTrue(actMessage.contains(expMobileNumber), "Message does not contain expected email address:" + expMobileNumber);
    }

    @Test
    public void sendMesssage_mobilePhoneIsNull_shouldReturnErrorMessage() {
        // arrange
        this.smsMessageService = new SmsMessageService();
        String expName = this.clientWithEmail.getName();
        // act
        String actMessage = this.smsMessageService.sendMessage(this.clientWithEmail, "meh");
        // assert
        assert(actMessage.contains(expName));
        assert(actMessage.toLowerCase().contains("does not have proper mobile number configuration"));
    }

}
