import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão HTTP na API top 3 TV do IMDB
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopTVs.json";
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        // Conexão HTTP na API 3 imagens da NASA
        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

        // String url = "http://localhost:8080/linguagens";

        String url = "https://marceloicampos-linguagens-api.herokuapp.com/linguagens";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // extrair só os dados que interessam (titulo, poster, classificação)
        // códigos alocados nas classes extratoras

        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        // var extrator = new ExtratorDeConteudoDoIMDB();
        // var extrator = new ExtratorDeConteudoDaNasa();

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDasLinguagens();

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();
        // for (Map<String, String> conteudo : listaDeConteudo) {
        for (int i = 0; i < conteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);
            // Map<String, String> conteudo = listaDeConteudos.get(i);
            // System.out.println(conteudo.get("rank"));
            // System.out.println(conteudo.get("title"));
            // System.out.println(conteudo.get("image"));
            // System.out.println(conteudo.get("imDbRating"));
            // System.out.println(conteudo.get("url"));

            // String urlImagem = conteudo.get("image");
            // acima para IMDB abaixo para NASA
            // String urlImagem = conteudo.get("url");
            // String titulo = conteudo.get("title");

            // InputStream inputStream = new URL(urlImagem).openStream();
            // String nomeArquivo = "out/" + titulo + ".png";

            try {
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
                String nomeArquivo = "out/" + conteudo.getTitulo().replace(":", " -") + ".png";
                geradora.cria(inputStream, nomeArquivo);
                System.out.println(conteudo.getUrlImagem());
                System.out.println(conteudo.getTitulo());
                System.out.println();
            } catch (java.io.FileNotFoundException err) {
                System.out.println("Erro ao criar imagem");
            }
        }
    }
}
