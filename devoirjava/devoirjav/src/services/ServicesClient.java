package services;

import entities.Client;
import repositories.ClientRepository;
import java.util.List;

public class ServicesClient {

    private ClientRepository clientRepository;

    public ServicesClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
