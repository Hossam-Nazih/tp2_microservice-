package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationXML {
    public static void main(String[] args) {
        // Ici les beans et leurs liens sont décrits dans un fichier XML, sans annotations
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // On récupère le bean par l'identifiant qu'il porte dans le XML
        IMetier metier = (IMetier) context.getBean("metier");

        System.out.printf("(XML) Température    = %.2f °F%n", metier.calcul());
        System.out.printf("(XML) Point de rosée = %.2f °C%n", metier.pointDeRosee());
        System.out.printf("(XML) Vent           = %.2f nœuds%n", metier.ventEnNoeuds());
        System.out.printf("(XML) Pression       = %.2f mmHg%n", metier.pressionEnMmHg());
    }
}
