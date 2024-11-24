import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculateurReseauSwingApp extends UIComposant {
    private JTextField ipField;
    private JTextField masqueField;
    private JTextArea resultArea;
    private JButton calculerButton;

    public CalculateurReseauSwingApp() {
        initialiserUI();
    }

    @Override
    public void initialiserUI() {
        JFrame frame = new JFrame("Calculateur d'Adresse Réseau");
        frame.setLayout(new FlowLayout());

        ipField = new JTextField(15);
        masqueField = new JTextField(15);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        calculerButton = new JButton("Calculer");
        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traiterCalcul(ipField.getText(), masqueField.getText());
            }
        });

        frame.add(new JLabel("Adresse IP:"));
        frame.add(ipField);
        frame.add(new JLabel("Masque:"));
        frame.add(masqueField);
        frame.add(calculerButton);
        frame.add(new JScrollPane(resultArea));

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mettreAJourResultats(String result) {
        resultArea.setText(result);
    }

    public void traiterCalcul(String ip, String masque) {
        try {
            Reseau reseau = new Reseau(ip, masque);
            String result = "Classe: " + reseau.getClasse() + "\n" +
                    "Plage d'adresses: " + reseau.getAdresseDebut() + " - " + reseau.getAdresseFin();
            mettreAJourResultats(result);
            HistoriqueCalculs.ajouterCalcul(ip, masque, reseau.getClasse(), reseau.getAdresseDebut() + " - " + reseau.getAdresseFin());
        } catch (InvalidIPException e) {
            mettreAJourResultats("Erreur: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CalculateurReseauSwingApp();
    }
}
