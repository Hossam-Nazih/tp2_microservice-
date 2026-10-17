package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")  // Bean "metier" géré par le conteneur Spring
public class MetierImpl implements IMetier {

    // Constantes de la formule de Magnus pour le point de rosée
    private static final double MAGNUS_A = 17.62;
    private static final double MAGNUS_B = 243.12;

    // Spring fournit lui-même l'objet IDao : MetierImpl ne fait jamais de "new DaoImpl()"
    @Autowired
    @Qualifier("dao2")  // Parmi les beans IDao disponibles, on demande celui nommé "dao2"
    private IDao dao;

    @Override
    public double calcul() {
        // Conversion de la température de Celsius en Fahrenheit
        double celsius = dao.getValue();
        return celsius * 9 / 5 + 32;
    }

    @Override
    public double pointDeRosee() {
        // Formule de Magnus : combine température et humidité.
        // Plus le point de rosée est proche de la température, plus l'air est humide.
        double t = dao.getValue();
        double alpha = Math.log(dao.getHumidite() / 100) + MAGNUS_A * t / (MAGNUS_B + t);
        return MAGNUS_B * alpha / (MAGNUS_A - alpha);
    }

    @Override
    public double ventEnNoeuds() {
        // 1 nœud = 1 mille marin par heure = 1,852 km/h
        return dao.getVitesseVent() / 1.852;
    }

    @Override
    public double pressionEnMmHg() {
        // 1 hPa = 0,750062 mmHg (la pression standard 1013,25 hPa vaut 760 mmHg)
        return dao.getPression() * 0.750062;
    }

    // Permet aussi d'injecter le DAO à la main (tests) ou par la configuration XML
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
