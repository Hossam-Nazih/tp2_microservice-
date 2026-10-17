package dao;

// Contrat d'accès aux données : fournit les mesures brutes d'une station météo.
// Le métier ne connaît que cette interface, jamais la source réelle des mesures.
public interface IDao {
    double getValue();        // Température en degrés Celsius
    double getHumidite();     // Humidité relative en %
    double getVitesseVent();  // Vitesse du vent en km/h
    double getPression();     // Pression atmosphérique en hectopascals (hPa)
}
