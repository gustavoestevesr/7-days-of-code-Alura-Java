import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

        final String KEY = "k_n6q7rmgq";
        String URL = "https://imdb-api.com/en/API/Top250Movies/";

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(URL + KEY))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
}
