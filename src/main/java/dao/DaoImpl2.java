package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao2")  // Bean "dao2" : une source simulée pour développer sans matériel
@Profile("dev")     // Chargé uniquement quand le profil "dev" est actif
public class DaoImpl2 implements IDao {
    // En développement, on renvoie des mesures fictives (temps humide et venteux) au lieu d'interroger les capteurs

    @Override
    public double getValue() {
        System.out.println("[DEV] Mesures simulées des capteurs de test");
        return 12.5;
    }

    @Override
    public double getHumidite() {
        return 85.0;
    }

    @Override
    public double getVitesseVent() {
        return 37.04;
    }

    @Override
    public double getPression() {
        return 1000.0;  // Pression basse : approche d'une perturbation
    }
}
