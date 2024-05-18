import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

public class BruteForceOnlinePasswordCracker extends OnlinePasswordCracker {
    private static final String BASE_URL = "https://github.com/logout";

    @Override
    public String crack(String url, String login, String password) {
        try {
            String formattedUrl = String.format(BASE_URL, login, password);
            URI uri = URI.create(formattedUrl);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return password; // Si le mot de passe est valide, le retourne
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Si aucun mot de passe n'est trouvé
    }
}


