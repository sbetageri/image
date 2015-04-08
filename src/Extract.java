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

    Extract() throws IOException {
        image = ImageIO.read(new File("/home/sri/p/proj/trial/imgs/a.bmp"));
        OutlineChar trial = new OutlineChar(image);
        height = image.getHeight();
        width = image.getWidth();
        numChar = 0;
        pChar = new ArrayList<PixelCharacter>();
        int[] rCol = new int[4];
        rCol[0] = (new Color(255, 0, 0)).getRGB();
        for(int i = 1; i < 4; i++)
            rCol[i] = rCol[i - 1];
        extractChar(image);
        for(int i = 0; i < pChar.size(); i++) {
            System.out.println("PixelCharacter");
            pChar.get(i).showPixels();
        }
    }

    BufferedImage getImage() {
        return image;
    }

    void extractChar(BufferedImage img) {
        for(int i = 0; i < width; i++) {
            Pixel start = new Pixel();
            Pixel end = new Pixel();
            if(!findX(i, start, end))
                continue;
            findY(0, start, end);
            if(i < end.i)
                i = end.i + 1;
            pChar.add(new PixelCharacter(start, end));
        }
    }

    void findY(int stY, Pixel start, Pixel end) {
        // Finds the first and last y co-ordinates where there are black pixels
        boolean flag = false;
        Color a = new Color(0, 0, 0);
        for(int i = stY; i < height; i++) {
            int white = 0;
            for(int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                if(c.getBlue() == 0 && c.getGreen() == 0 && c.getRed() == 0) {
                    // Magic conditions, equivalent conditions don't hold
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

    boolean findX(int stX, Pixel start, Pixel end) {
        // Finds the first and last x co-rds where there are black pixels
        // Need to scan along Y
        // stX :
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
                else if(c != Color.black)
                    white++;
            }
            if (white == height && flag) {
                    end.i = i;
                    break;
            }
        }
        return flag;
    }
}
