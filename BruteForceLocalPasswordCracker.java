import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BruteForceLocalPasswordCracker extends LocalPasswordCracker {
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String crack(String hash) {
        // Longueur maximale du mot de passe à tester
        int maxLength = 8; // Vous pouvez ajuster cette valeur selon vos besoins
        
        // Générer toutes les combinaisons de mots de passe possibles jusqu'à maxLength
        for (int length = 1; length <= maxLength; length++) {
            String password = generatePassword("", length);
            String hashedPassword = hashPassword(password);
            if (hashedPassword.equals(hash)) {
                return password; // Si le hachage correspond, retourne le mot de passe trouvé
            }
        }

        return null; // Si aucun mot de passe n'est trouvé
    }

    // Méthode récursive pour générer toutes les combinaisons de mots de passe possibles
    private String generatePassword(String prefix, int length) {
        if (length == 0) {
            return prefix;
        }
        String password = "";
        for (int i = 0; i < CHARSET.length(); i++) {
            password += generatePassword(prefix + CHARSET.charAt(i), length - 1);
        }
        return password;
    }

    // Méthode pour hacher un mot de passe avec l'algorithme MD5
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
