package edu.ensign.cs460.solid.di;

import java.util.ArrayList;
import java.util.List;

public final class DependencyInverstionExample {
    private DependencyInverstionExample() {
    }
    public static void main(final String[] args) {
        IMessageService smsMessageService = new SmsMessageService();
        IMessageService emailMessageService = new EmailService();
        List<IMessageService> messageServices = new ArrayList<IMessageService>();
        messageServices.add(smsMessageService);
        messageServices.add(emailMessageService);

        MessageProcessor messageProcessor = new MessageProcessor(messageServices);
        Client client1 = new Client("Jane Doe", "jd@meh.com", "111-111-1111", "DoeRUs");
        Client client2 = new Client("John Doe", null, "222-222-2222", "John's Kitchen");
        Client client3 = new Client("Ziggy Doe", "zd@blah.com", null, "Ziggy's Place");
        List<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        for (Client client : clients) {
            System.out.println(messageProcessor.processMessage(client, "Christmas is coming!"));
        }
    }
}
