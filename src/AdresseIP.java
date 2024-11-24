public class AdresseIP {
    private int[] octets = new int[4];
    private String classe;

    public AdresseIP(String ip) throws InvalidIPException {
        validerAdresse(ip);
        String[] parts = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            octets[i] = Integer.parseInt(parts[i]);
        }
        this.classe = calculerClasse();
    }

    public void validerAdresse(String ip) throws InvalidIPException {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            throw new InvalidIPException("L'adresse IP doit avoir 4 octets.");
        }
        for (String part : parts) {
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) {
                throw new InvalidIPException("Octet invalide : " + part);
            }
        }
    }

    public String getClasse() {
        return classe;
    }

    public String calculerClasse() {
        int premierOctet = octets[0];
        if (premierOctet >= 1 && premierOctet <= 127) {
            return "Classe A";
        } else if (premierOctet >= 128 && premierOctet <= 191) {
            return "Classe B";
        } else if (premierOctet >= 192 && premierOctet <= 223) {
            return "Classe C";
        } else {
            return "Invalide";
        }
    }

    public int[] getOctets() {
        return octets;
    }
}
