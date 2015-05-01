/**
 * Created by sri on 26/3/15.
 */
import com.sun.javaws.exceptions.ExitException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Reading {
    static ArrayList<Pixel> pix = new ArrayList();
    public static void main(String[] args) throws IOException {
        ImageBlackNWhite xyz = new ImageBlackNWhite();
        /*
        ImageBlackNWhite xyz = new ImageBlackNWhite();
        BufferedImage img = null;
//        BufferedImage trialOP = ImageIO.read(new File("/home/sri/p/proj/trial/imgs/ga.bmp"));
        img = ImageIO.read(new File("/home/sri/p/proj/trial/imgs/gaBORDER.bmp"));
        System.out.println("Height of the image : " + img.getHeight());
        System.out.println("Width of the image : " + img.getWidth());
        int black = 0;
        BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 1; i < img.getHeight() - 1; i++) {
            for (int j = 1; j < img.getWidth() - 1; j++) {
                Color c = new Color(img.getRGB(j, i));
//                trialOP.setRGB(i, j, img.getRGB(i, j));
                if (c.getRed() == 0 && c.getBlue() == 0 && c.getGreen() == 0) {
                    // IF black, adds the pixel object to pix
                    black++;
                    pix.add(new Pixel(i, j, img.getRGB(i, j)));
                    image.setRGB(i, j, Color.WHITE.getRGB());
                }

            }
        }
        Grid g = new Grid(pix, img.getHeight(), img.getWidth());
        Extract charPixels = new Extract();
        /*
        Pixel start = new Pixel(0, 0);
        Pixel end = new Pixel(0, 0);
        charPixels.findX(0, start, end);
        charPixels.findY(0, start, end);
        System.out.println(start.i);
        System.out.println(start.j);
        System.out.println(end.i);
        System.out.println(end.j);
        Kmeans trial = new Kmeans(pix, 60);
        for(int i = 0; i < black; i++) {
            Pixel obj;
            obj = pix.get(i);
            image.setRGB(obj.i, obj.j, obj.c);
        }
        int[] gCol = new int[16];
        for(int i = 0; i < 16; i++) {
            gCol[i] = new Color(0, 255, 0).getRGB();
        }
        // for(int i = 0; i < 10; i++)
           // image.setRGB(20 * i, 20 * i, 4, 4, col, 0, 4);
        for(int i = 0; i < trial.nCntrds.size(); i++) {
            Pixel TEMP = trial.nCntrds.get(i);
//            TEMP.display();
            image.setRGB(TEMP.i, TEMP.j, 1, 1, gCol, 0, 1);
        }
        for(int i = start.i; i < end.i; i++) {
            // x
            trialOP.setRGB(i, start.j, 4, 4, bCol, 0, 4);
            trialOP.setRGB(i, end.j, 4, 4, bCol, 0, 4);
        }
        for(int i = start.j; i < end.j; i++) {
            trialOP.setRGB(start.i, i, 4, 4, bCol, 0, 4);
            trialOP.setRGB(end.i, i, 4, 4, bCol, 0, 4);
        }
//        trialOP.setRGB(start.i, start.j, 4, 4, bCol, 0, 4);
//        trialOP.setRGB(end.i, end.j - 18, 4, 4, bCol, 0, 4);
//        File op = new File("/home/sri/p/proj/trial/imgs/kga.jpg");
        File output = new File("/home/sri/p/proj/trial/imgs/kmeansGha.jpg");
        ImageIO.write(image, "jpg", output);
//        ImageIO.write(trialOP, "jpg", op);
        System.out.println("NUMBER OF CENTROIDS : " + trial.nCntrds.size());
        */
    }
}

