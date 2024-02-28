package services;

import entities.Adresse;
import repositories.AdresseRepository;
import java.util.List;

public class ServicesAdresse {

    private AdresseRepository adresseRepository;

    public ServicesAdresse(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public void addAdresse(Adresse adresse) {
        adresseRepository.save(adresse);
    }

    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    public void associateAdresseWithClient(int clientId, Adresse adresse) {
        adresse.setId(clientId);
        adresseRepository.save(adresse);
    }
}
