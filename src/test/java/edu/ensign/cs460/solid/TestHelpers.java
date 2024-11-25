package edu.ensign.cs460.solid;

import java.util.ArrayList;
import java.util.List;

import edu.ensign.cs460.solid.di.Client;

public class TestHelpers {
    public List<Client> setupClients() {

        List<Client> clients =  new ArrayList<Client>(){
            {
                add(new Client("Jane Doe", "jd@email.com", "111-111-1111", "DoeRUs"));
                add(new Client("John Doe", "john@john.com", null, "Jonny On The Spot"));
                add(new Client("Jim Doe", null, "222-222-2222", "Jiminy Chimney Sweeps"));
            }};    

        return clients;
    }

}
