import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AppLive {
  public static void main(String[] args) throws Exception {
    // acessar a url
    // https://imdb-api.com/api
    var url = "https://imdb-api.com/en/API/Top250Movies/k_4nd8abqo";
    URI uri = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(uri).build();

    // pegando o texto do JSON
    String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

    // imprimir o JSON
    System.out.println(json);
    // System.out.println("Hello, World!");
  }
}
