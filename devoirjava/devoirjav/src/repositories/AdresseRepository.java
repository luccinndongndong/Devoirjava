
package repositories;

import entities.Adresse;
import java.util.ArrayList;
import java.util.List;

public class AdresseRepository {

    private List<Adresse> adresses;

    public AdresseRepository() {
        this.adresses = new ArrayList<>();
    }

    public void save(Adresse adresse) {
        adresses.add(adresse);
    }

    public List<Adresse> findAll() {
        return adresses;
    }
}
