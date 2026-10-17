package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao")  // Bean "dao" : la source de données réelle
@Profile("prod")   // Chargé uniquement quand le profil "prod" est actif
public class DaoImpl implements IDao {
    // En production, ces valeurs viendraient des capteurs physiques de la station de Marrakech

    @Override
    public double getValue() {
        System.out.println("[PROD] Lecture des capteurs de la station météo de Marrakech");
        return 27.5;
    }

    @Override
    public double getHumidite() {
        return 40.0;  // Air plutôt sec
    }

    @Override
    public double getVitesseVent() {
        return 18.52;  // Brise légère
    }

    @Override
    public double getPression() {
        return 1013.25;  // Pression standard au niveau de la mer
    }
}
