import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickersGenerate {

    public void criaStricker(InputStream inputStream, String nomeArquivo) throws IOException {

        //Leitura imagem através do BufferedImage fazendo a leitura da imagem através do read File
//        BufferedImage imagemOriginal = ImageIO.read(new File("images/filme.jpg"));


        //Pegando a imagem através do inputStream passando a variavel que armazena a imagem para o Read do imageIO, que retorna um BufferedImage
//        InputStream inputStream = new FileInputStream(new File("images/filme.jpg"));
//        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //Pegando a imagem da URL, fazendo a atribuição via inputStream que é uma classe que representa um stream de fonte de bytes.
//        InputStream inputStream1 = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        //Cria nova imagem
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copia a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        //Configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escreve uma frase na nova imagem
        graphics.drawString("TOPZERA", 150, novaAltura - 100);


        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

    public static void main(String[] args) throws IOException {
        StickersGenerate stickersGenerate = new StickersGenerate();
        stickersGenerate.criaStricker(new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream(), "Teste");
    }

}
