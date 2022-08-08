package Stickers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class StickerGenerator {

    public void criar() throws Exception {
        String url = "https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg";

        //Leitura imagem
//        InputStream inputStream = new FileInputStream(new File("img/filme.jpg"));
        InputStream inputStream = new URL(url).openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //Criar nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original pra novo imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        boolean drawImage = graphics.drawImage(imagemOriginal, 0, 0, null);

        //Definir nova fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //Excrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        //Excrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("img/novaImagem.png"));



    }
}
