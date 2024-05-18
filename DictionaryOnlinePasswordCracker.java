import java.util.HashMap;
import java.util.Map;

public class DictionaryOnlinePasswordCracker extends OnlinePasswordCracker {
    private Map<String, String> onlineDictionary;

    public DictionaryOnlinePasswordCracker() {
        // Initialisation du dictionnaire de mots de passe en ligne
        onlineDictionary = new HashMap<>();
        onlineDictionary.put("login1", "ndazazer@gmail.com");
        onlineDictionary.put("password", "passer");
        // Ajoutez d'autres paires login-mot de passe ici
    }

    @Override
    public String crack(String url, String login, String password) {
        // Implémentation de la méthode de craquage en ligne par dictionnaire
        if (onlineDictionary.containsKey(login)) {
            return onlineDictionary.get(login);
        } else {
            return null;
        }
    }
}
