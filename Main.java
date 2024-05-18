public class Main {
    public static void main(String[] args) {
        // Exemple d'utilisation
        String hash = "hash1";
        
        // Utilisation du cracker local par dictionnaire
        LocalPasswordCracker localCracker = new DictionaryLocalPasswordCracker();
        String localPassword = localCracker.crack(hash);
        if (localPassword != null) {
            System.out.println("Mot de passe local trouvé: " + localPassword);
        } else {
            System.out.println("Mot de passe local non trouvé.");
        }
        
        // Utilisation du cracker en ligne par force brute avec une liste de mots de passe prédéfinis
        String url = "https://github.com/logout";
        String login = "yvesperlyngabo1@esp.sn";
        String[] passwordsToTest = {"Passer", "patience#3", "passer123@#", "password3", "123456", "qwerty", "abc123", "passer"}; // Liste de mots de passe prédéfinis
        OnlinePasswordCracker onlineCracker = new BruteForceOnlinePasswordCracker();
        
        for (String password : passwordsToTest) {
            String onlinePassword = onlineCracker.crack(url, login, password);
            if (onlinePassword != null) {
                System.out.println("Mot de passe en ligne trouvé: " + onlinePassword);
                break; // Sortir de la boucle si un mot de passe est trouvé
            }
            else
            {
                System.out.println("Mot de passe en ligne non trouvé");
            }
           
        }
        
        
    }
}
