
package repositories;

import entities.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    public void save(Client client) {
        clients.add(client);
    }

    public List<Client> findAll() {
        return clients;
    }
}
