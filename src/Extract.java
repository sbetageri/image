import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sri on 31/3/15.
 */
public class Extract {
    // Extracts and places the co-ordinates in an array of Pixel Character
    BufferedImage image;
    int height; // height of the image
    int width; // width of the image
    ArrayList<PixelCharacter> pChar; // Has list of all pixels
    int numChar;

    Extract(BufferedImage img) {
        image = img;
        height = img.getHeight();
        width = img.getWidth();
        numChar = 0;
        pChar = new ArrayList<PixelCharacter>();
    }

    void findY(int stY, Pixel start, Pixel end) {
        // Finds the first and last y co-ordinates where there are black pixels
        boolean flag = false;
        for(int i = stY; i < height; i++) {
            int white = 0;
            for(int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                if(c.getBlue() == 0 && c.getGreen() == 0 && c.getBlue() == 0) {
                    if (!flag) {
                        flag = true;
                        start.j = i;
                    }
                }
                else
                    white++;
            }
            if(white == width && flag) {
                end.j = i;
                break;
            }
        }

    }

    void findX(int stX, Pixel start, Pixel end) {
        // Finds the first and last x co-rds where there are black pixels
        // Need to scan along Y
        /*
            For each column, it checks if there is a black pixel in it
            If there is a pixel, flag is set to mark that the character has started.
            Once the flag is set, it checks for a column that has only white pixels
         */
        boolean flag = false;
        for (int i = stX; i < width; i++) {
            // i here is the x co-ordinate
            int white = 0;
            for (int j = 0; j < height; j++) {
                // j here is the y co-ordinate
                Color c = new Color(image.getRGB(i, j));
                if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0) {
                    if (!flag) {
                        flag = true;
                        start.i = i;
                    }
                }
                else if(c.getBlue() == 255 && c.getGreen() == 255 && c.getRed() == 255)
                    white++;
            }
            if (white == height && flag) {
                    end.i = i;
                    break;
            }
        }
    }
}


/*
    TODO
    Add code to extract the entire set of characters from a given image
 */
