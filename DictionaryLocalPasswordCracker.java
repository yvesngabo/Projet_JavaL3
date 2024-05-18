import java.util.HashMap;
import java.util.Map;

public class DictionaryLocalPasswordCracker extends LocalPasswordCracker {
    private Map<String, String> dictionary;

    public DictionaryLocalPasswordCracker() {
        // Initialisation du dictionnaire de mots de passe
        dictionary = new HashMap<>();
        dictionary.put("hash1", "passer1234");
        dictionary.put("hash2", "password2");
        dictionary.put("hash3", "password10");
        dictionary.put("hash4", "passer1");
        dictionary.put("hash5", "password123");
        // Ajoutez d'autres mots de passe et leurs hash ici
    }

    @Override
    public String crack(String hash) {
        // Implémentation de la méthode de craquage par dictionnaire
        if (dictionary.containsKey(hash)) {
            return dictionary.get(hash);
        } else {
            return null;
        }
    }
}
