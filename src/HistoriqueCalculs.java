import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoriqueCalculs {

    private static final String HISTORIQUE_PATH = "resources/historique.txt";

    public static void ajouterCalcul(String ip, String masque, String classe, String plageAdresse) {
        String resultat = "Calcul effectué : Adresse IP : " + ip + ", Masque : " + masque + ", Classe : " + classe + ", Plage d'adresses : " + plageAdresse;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORIQUE_PATH, true))) {
            writer.write(resultat);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
