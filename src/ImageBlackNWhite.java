import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by sri on 6/4/15.
 */
public class ImageBlackNWhite {
    ImageBlackNWhite() throws IOException {
        BufferedImage image = ImageIO.read(new File("/home/sri/p/proj/trial/imgs/kannada.jpg"));
        BufferedImage bNW = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        Color thrshld = new Color(127, 127, 127);
        System.out.println("WHITE : " + white.getRGB());
        System.out.println("BLACK : " + black.getRGB());
        int h = image.getHeight();
        int w = image.getWidth();
        for(int i = 0; i < h; i++)
            for(int j = 0; j < w; j++) {
                Color col = new Color(image.getRGB(j, i));
                if(col.getRGB() < thrshld.getRGB())
                    bNW.setRGB(j, i, black.getRGB());
                else
                    bNW.setRGB(j, i, white.getRGB());
            }
        File op = new File("/home/sri/p/proj/trial/imgs/kannadaBW.bmp");
        ImageIO.write(bNW, "bmp", op);
    }
}
