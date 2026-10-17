package metier;

// Contrat de la couche métier : transforme les mesures fournies par le DAO.
public interface IMetier {
    double calcul();          // Température en degrés Fahrenheit
    double pointDeRosee();    // Température à laquelle la vapeur d'eau se condense, en °C
    double ventEnNoeuds();    // Vitesse du vent en nœuds
    double pressionEnMmHg();  // Pression en millimètres de mercure
}
