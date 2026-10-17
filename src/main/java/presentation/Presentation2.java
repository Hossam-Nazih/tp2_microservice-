package presentation;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Cette classe sert aussi de configuration Spring
@ComponentScan(basePackages = {"dao", "metier"})  // Spring cherche les @Component dans ces packages
public class Presentation2 {
    public static void main(String[] args) {
        // On crée un contexte vide pour pouvoir choisir le profil avant de le démarrer
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");  // Seuls les beans du profil "dev" seront créés
        context.register(Presentation2.class);
        context.refresh();  // Démarrage du conteneur : création et injection des beans

        // On demande au conteneur un objet de type IMetier, sans savoir quelle classe le réalise
        IMetier metier = context.getBean(IMetier.class);

        System.out.printf("Température    = %.2f °F%n", metier.calcul());
        System.out.printf("Point de rosée = %.2f °C%n", metier.pointDeRosee());
        System.out.printf("Vent           = %.2f nœuds%n", metier.ventEnNoeuds());
        System.out.printf("Pression       = %.2f mmHg%n", metier.pressionEnMmHg());
    }
}
