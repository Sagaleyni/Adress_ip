public class Reseau extends AdresseIP {
    private String masque;
    private String adresseDebut;
    private String adresseFin;

    public Reseau(String ip, String masque) throws InvalidIPException {
        super(ip);
        this.masque = masque;
        calculerPlageAdresse();
    }

    public void calculerPlageAdresse() {
        // Calcul de la plage d'adresses en fonction de l'adresse IP et du masque
        // Exemple de calcul basique (à adapter selon l'algorithme de sous-réseau)
        this.adresseDebut = "192.168.1.1";  // Exemple statique
        this.adresseFin = "192.168.1.254";  // Exemple statique
    }

    public String getMasque() {
        return masque;
    }

    public String getAdresseDebut() {
        return adresseDebut;
    }

    public String getAdresseFin() {
        return adresseFin;
    }
}
