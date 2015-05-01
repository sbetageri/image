import com.sun.javafx.binding.StringFormatter;

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
        String source = "/home/sri/p/proj/trial/imgs/GHA.bmp";
        String dest = "/home/sri/p/proj/trial/gha.bmp";
//        String pre = "/home/sri/p/ka/k";
//        String post = "/home/sri/p/KA/k";
//        String suf = ".bmp";
//        String oSuf = "BW.bmp";
//        String[] num = { "1", "2", "3", "4", "5", "6",
//            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
//            "17", "18", "19", "20", "21", "22", "23"};
//        for(String k : num) {
//            StringBuilder src = new StringBuilder();
//            StringBuilder dst = new StringBuilder();
//            src.append(pre);
//            src.append(k);
//            src.append(suf);
//            dst.append(post);
//            dst.append(k);
//            dst.append(oSuf);
//            System.out.println("SOURCE : " + src);
//            BufferedImage image = ImageIO.read(new File(src.toString()));
        BufferedImage image = ImageIO.read(new File(source));
            BufferedImage bNW = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            Color white = new Color(255, 255, 255);
            Color black = new Color(0, 0, 0);
            Color thrshld = new Color(127, 127, 127);
//            System.out.println("WHITE : " + white.getRGB());
//            System.out.println("BLACK : " + black.getRGB());
            int h = image.getHeight();
            int w = image.getWidth();
            for (int i = 0; i < h; i++)
                for (int j = 0; j < w; j++) {
                    Color col = new Color(image.getRGB(j, i));
                    if (col.getRGB() < thrshld.getRGB())
                        bNW.setRGB(j, i, black.getRGB());
                    else
                        bNW.setRGB(j, i, white.getRGB());
                }
//            File op = new File(dst.toString());
        File op = new File(dest);
            ImageIO.write(bNW, "bmp", op);
//        }
    }
}
