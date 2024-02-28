import java.util.List;
import java.util.Scanner;
import entities.Client;
import entities.Adresse;
import services.ServicesClient;
import services.ServicesAdresse;
import repositories.ClientRepository;
import repositories.AdresseRepository;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientRepository clientRepository = new ClientRepository();
        AdresseRepository adresseRepository = new AdresseRepository();
        ServicesClient servicesClient = new ServicesClient(clientRepository);
        ServicesAdresse servicesAdresse = new ServicesAdresse(adresseRepository);
        List<Client> allClients = null; 

        boolean quitter = false;
        while (!quitter) {
            System.out.println("Menu :");
            System.out.println("1. Créer un Client");
            System.out.println("2. Lister les Clients");
            System.out.println("3. Ajouter une adresse et lui associer un client");
            System.out.println("4. Lister les adresses en affichant le nom du client");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.println("Création d'un nouveau client :");
                    Client client = new Client();
                    System.out.print("Entrez l'ID du client : ");
                    client.setId(scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.print("Entrez le nom complet du client : ");
                    client.setNomComplet(scanner.nextLine());
                    System.out.print("Entrez le numéro de téléphone du client : ");
                    client.setTelephone(scanner.nextLine());
                    System.out.print("Entrez l'email du client : ");
                    client.setEmail(scanner.nextLine());
                    servicesClient.createClient(client);
                    System.out.println("Client créé avec succès !");
                    break;
                case 2:
                    System.out.println("Liste des clients :");
                    List<Client> clients = servicesClient.getAllClients();
                    for (Client c : clients) {
                        System.out.println("ID : " + c.getId());
                        System.out.println("Nom complet : " + c.getNomComplet());
                        System.out.println("Téléphone : " + c.getTelephone());
                        System.out.println("E-mail : " + c.getEmail());
                        System.out.println("--------------------");
                    }
                    break;
                case 3:
                    System.out.println("Ajout d'une adresse et association à un client :");
                    Adresse adresse = new Adresse();
                    System.out.print("Entrez l'ID de l'adresse : ");
                    adresse.setId(scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.print("Entrez la ville : ");
                    adresse.setVille(scanner.nextLine());
                    System.out.print("Entrez le quartier : ");
                    adresse.setQuartier(scanner.nextLine());
                    System.out.print("Entrez le numéro de villa : ");
                    adresse.setNumVilla(scanner.nextLine());
                    servicesAdresse.addAdresse(adresse);
                    System.out.println("Liste des clients disponibles :");
                    allClients = servicesClient.getAllClients(); 
                    for (Client c : allClients) {
                        System.out.println(c.getId() + " - " + c.getNomComplet());
                    }
                    System.out.print("Choisissez l'ID du client à associer à cette adresse : ");
                    int clientId = scanner.nextInt();
                    scanner.nextLine(); 
                    servicesAdresse.associateAdresseWithClient(clientId, adresse);
                    System.out.println("Adresse associée avec succès !");
                    break;
                case 4:
                    System.out.println("Liste des adresses avec le nom du client associé :");
                    List<Adresse> allAdresses = servicesAdresse.getAllAdresses();
                    allClients = servicesClient.getAllClients(); 
                    for (Adresse a : allAdresses) {
                        System.out.println("Adresse : " + a.getVille() + ", " + a.getQuartier() + ", " + a.getNumVilla());
                        for (Client c : allClients) {
                            if (c.getId() == a.getId()) {
                                System.out.println("Client : " + c.getNomComplet());
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    quitter = true;
                    System.out.println("Merci d'avoir utilisé notre application !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }

        scanner.close();
    }
}
