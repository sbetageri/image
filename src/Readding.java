/**
 * Created by sri on 26/3/15.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Readding {
    static ArrayList<Pixel> pix = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(new File("/home/sri/p/proj/trial/imgs/b.bmp"));
        System.out.println("Height of the image : " + img.getHeight());
        System.out.println("Width of the image : " + img.getWidth());
        int black = 0;
        for(int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color c = new Color(img.getRGB(i, j));
                if (c.getRed() == 0 && c.getBlue() == 0 && c.getGreen() == 0) {
                    black++;
                    pix.add(new Pixel(i, j, img.getRGB(i, j)));
                }
            }
        }
        Kmeans trial = new Kmeans(pix, 35);
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < black; i++) {
            Pixel obj;
            obj = pix.get(i);
            image.setRGB(obj.i, obj.j, obj.c);
        }
//        int[] col = new int[16];
        int[] gCol = new int[16];
        for(int i = 0; i < 16; i++) {
            //col[i] = new Color(0, 0, 255).getRGB();
            gCol[i] = new Color(0, 255, 0).getRGB();
        }
        // for(int i = 0; i < 10; i++)
           // image.setRGB(20 * i, 20 * i, 4, 4, col, 0, 4);
        for(int i = 0; i < trial.nCntrds.size(); i++) {
            Pixel TEMP = trial.nCntrds.get(i);
            TEMP.display();
            image.setRGB(TEMP.i, TEMP.j, 4, 4, gCol, 0, 4);
        }
        File op = new File("/home/sri/p/proj/trial/imgs/bmpB.jpg");
        ImageIO.write(image, "jpg", op);
        System.out.println("NUMBER OF CENTROIDS : " + trial.nCntrds.size());
    }
}

