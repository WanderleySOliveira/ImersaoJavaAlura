import model.Filme;
import parse.JsonParse;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLData;
import java.text.AttributedCharacterIterator;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        //Fazer um request HTTP e buscar o top filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        String url2 = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereço = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
//        System.out.println(body);

        //Realizar filtro para pegar somente os dados necessarios
        var parser = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //Exibir e manipular dados na aplicação
        var gerador = new StickersGenerate();
        for (Map<String, String> filme : listaDeFilmes) {

            var urlImagem = filme.get("image");
            var titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            gerador.criaStricker(inputStream, nomeArquivo);

                    System.out.println(filme.get("title"));
            System.out.println(titulo);
            System.out.println();
        }
    }
}
