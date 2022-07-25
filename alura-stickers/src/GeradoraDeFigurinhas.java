import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
// import java.net.URL;
// import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

    // leitura da imagem
    // BufferedImage imagemOriginal = ImageIO.read(new File("in/filme.jpg"));

    // InputStream inputStream = new FileInputStream(new File("in/filme.jpg"));
    // BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // InputStream inputStream = new
    // URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a cor e a fonte, e aplica
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
    graphics.setColor(Color.RED);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 50, novaAltura - 100);

    // escrever a nova imagem em um arquivo
    // ImageIO.write(novaImagem, "png", new File("out/filmeFigurinha.png"));
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }

  // public static void main(String[] args) throws IOException {
  // GeradoraDeFigurinhas imagem = new GeradoraDeFigurinhas();
  // imagem.cria();
  // }
}
