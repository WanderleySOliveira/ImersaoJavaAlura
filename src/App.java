import parse.JsonParse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.AttributedCharacterIterator;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        JsonParse parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //System.out.println(listaDeFilmes.size());

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
        }
    }
}
