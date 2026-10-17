package metier;

import dao.IDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetierImplTest {

    private MetierImpl metier;

    @Before
    public void setUp() {
        // Faux DAO aux valeurs choisies pour que les résultats attendus soient faciles à vérifier
        IDao dao = new IDao() {
            @Override
            public double getValue() {
                return -40.0;  // Seule température identique en Celsius et en Fahrenheit
            }

            @Override
            public double getHumidite() {
                return 100.0;  // Air saturé : le point de rosée égale la température
            }

            @Override
            public double getVitesseVent() {
                return 18.52;  // Exactement 10 nœuds
            }

            @Override
            public double getPression() {
                return 1013.25;  // Pression standard, soit 760 mmHg
            }
        };

        // Pas de Spring ici : on branche le faux DAO nous-mêmes grâce au setter
        metier = new MetierImpl();
        metier.setDao(dao);
    }

    @Test
    public void testCalcul() {
        Assert.assertEquals(-40.0, metier.calcul(), 0.001);
    }

    @Test
    public void testPointDeRosee() {
        Assert.assertEquals(-40.0, metier.pointDeRosee(), 0.001);
    }

    @Test
    public void testVentEnNoeuds() {
        Assert.assertEquals(10.0, metier.ventEnNoeuds(), 0.001);
    }

    @Test
    public void testPressionEnMmHg() {
        Assert.assertEquals(760.0, metier.pressionEnMmHg(), 0.01);
    }
}
